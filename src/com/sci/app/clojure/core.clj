(ns com.sci.app.clojure.core)
(use 'hickory.core)
(require '[clojure.string :as string])
(require '[clj-http.client :as client])
(require '[clj-http.util :as http-util])
(require '[hickory.select :as s])
(require '[com.sci.app.clojure.wos :as wos])
(require '[com.sci.app.clojure.biosis :as biosis])
(require '[com.sci.app.clojure.diidw :as diidw])
(require '[com.sci.app.clojure.inspec :as inspec])
(require '[com.sci.app.clojure.kjd :as kjd])
(require '[com.sci.app.clojure.medline :as medline])
(require '[com.sci.app.clojure.scielo :as scielo])
(import 'com.sci.app.model.FetcherModel)



(defn getSID []
  (
    let [cookies (clj-http.cookies/cookie-store)]
	    (client/get "http://apps.webofknowledge.com/" {:cookie-store cookies})
	    (->
			  (for [a (. cookies getCookies)
			        :when(= "SID" (. a getName))
			        ]
			    (. a getValue)
	      )
	      first    
	    )
    )
  )

(defn get-product-prop
  [sid,^FetcherModel model]
  (let [prop {}
        product (.getProduct model)]
    (
      case (string/upper-case product)
      "WOS" (merge prop
                   {"advurl" wos/advsearch-url}
                   {"advparam" (wos/get-adv-param sid model)}
                   {"outboundParam" (wos/get-outbound-param sid model)}
                   )
      "BIOSIS" (merge prop
                   {"advurl" biosis/advsearch-url}
                   {"advparam" (biosis/get-adv-param sid model)}
                   {"outboundParam" (biosis/get-outbound-param sid model)}
                   )
      "DIIDW" (merge prop
                   {"advurl" diidw/advsearch-url}
                   {"advparam" (diidw/get-adv-param sid model)}
                   {"outboundParam" (diidw/get-outbound-param sid model)}
                   )
      "INSPEC" (merge prop
                   {"advurl" inspec/advsearch-url}
                   {"advparam" (inspec/get-adv-param sid model)}
                   {"outboundParam" (inspec/get-outbound-param sid model)}
                   )
      "KJD" (merge prop
                   {"advurl" kjd/advsearch-url}
                   {"advparam" (kjd/get-adv-param sid model)}
                   {"outboundParam" (kjd/get-outbound-param sid model)}
                   )
      "MEDLINE" (merge prop
                   {"advurl" medline/advsearch-url}
                   {"advparam" (medline/get-adv-param sid model)}
                   {"outboundParam" (medline/get-outbound-param sid model)}
                   )
      "SCIELO" (merge prop
                   {"advurl" scielo/advsearch-url}
                   {"advparam" (scielo/get-adv-param sid model)}
                   {"outboundParam" (scielo/get-outbound-param sid model)}
                   )
      "default" {}
      )
    )
  )

(defn set-search-adv
  "设置高级检索条件,并解析出该表达式可以检索出的记录数"
  [productProp]
   (
    let [advurl (productProp "advurl")
         advparam (productProp "advparam")]
      (
        let [rst-htree (-> (client/get (
                                         (:headers (client/post advurl {:form-params advparam})
                                                   )
                                         "Location")
                                       ) :body parse as-hickory 
                         )]
        (->
          (s/select (s/child 
                    (s/class "historyResults")
                    (s/tag :a)
                           ) 
                    rst-htree
                    )
          first :content first string/trim
          )
        )
    )
  )

(defn outbound
  [productProp,fNum,tNum]
  (
    let [selectedIds (clojure.string/join ";" (range fNum (+ 1 tNum)))
         totalMarked (+(- tNum fNum) 1)
         outboundParam (productProp "outboundParam")]
    (let [param (merge outboundParam {"mark_form" fNum} {"mark_to" tNum} {"selectedIds" selectedIds})]
      (client/post (str "http://apps.webofknowledge.com/OutboundService.do?action=go&totalMarked=" totalMarked)
                 {:form-params param
                  ;:debug true 
                  })
      )
    )
  )

(defn fetch-file
  [productProp,fNum,tNum]
  (
    let [url ((:headers (outbound productProp fNum tNum)) "Location")]
    (
      :body (client/get url {:as "UTF-8"})
      )
    )
  )
