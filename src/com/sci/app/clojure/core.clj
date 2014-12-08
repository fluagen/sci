(ns com.sci.app.clojure.core)
(use 'hickory.core)
(require '[clojure.string :as string])
(require '[clj-http.client :as client])
(require '[clj-http.util :as http-util])
(require '[hickory.select :as s])
(import 'com.sci.app.model.SearchModel)


(def wos_advsearch_param 
  {
   "product" "WOS"
   "search_mode" "AdvancedSearch"
   "action" "search"
   "value(searchOp)" "search"
   "value(select2)" "LA"
   "value(input2)" ""
   "value(select3)" "DT"
   "value(input3)" ""
   "value(limitCount)"	"14"
   "limitStatus" "collapsed"
   "range" "ALL"
   ;"startYear" "1900"
   ;"endYear" "2014"
   "editions" ["SCI","SSCI","AHCI","ISTP","ISSHP","CCR","IC"]
   "rs_sort_by" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A"
   "ss_lemmatization" "On"
   "ss_spellchecking" "Suggest"
   "SinceLastVisit_UTC" ""
   "SinceLastVisit_DATE" ""
   "period"	"Year Range"
   "ss_query_language" ""
   }
  )

(def wos_outbound_param
  {
   "product" "WOS"
   "mark_id" "WOS"
   "colName" "WOS"
   "search_mode" "AdvancedSearch"
   "sortBy" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A"
   "mode" "OpenOutputService"
   "qid" "1"
   "format" "saveToFile"
   "filters" "AUTHORSIDENTIFIERS ACCESSION_NUM ISSN CONFERENCE_SPONSORS ABSTRACT CONFERENCE_INFO SOURCE TITLE AUTHORS"
   ;"mark_from" "1"
   ;"mark_to" "10"
   ;"incitesCount" "36776"
   ;"selectedIds" "11;12;13;14;15;16;17;18;19;20"
   "count_new_items_marked" "0"
   "IncitesEntitled" "no"
   "value(record_select_type)" "pagerecords"
   "fields_selection" "AUTHORSIDENTIFIERS ACCESSION_NUM ISSN CONFERENCE_SPONSORS ABSTRACT CONFERENCE_INFO SOURCE TITLE AUTHORS"
   "save_options" "fieldtagged"
   }
  )

(def wos_est_param
  {"product" "UA"
   "colName" "WOS"
   "qid" "2"
   ;"mark_from" "36770"
   ;"mark_to" " 36780"
   "fileOpt" "fieldtagged"
   "displayCitedRefs" "true"
   "parentQid" "1"
   "displayTimesCited" "true"
   "sortBy" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A"
   "UserIDForSaveToRID" ""
   "action" "saveToFile"
   "filters" "AUTHORSIDENTIFIERS ACCESSION_NUM ISSN CONFERENCE_SPONSORS ABSTRACT CONFERENCE_INFO SOURCE TITLE AUTHORS"
   }
  )



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

(defn set-search-exps
  "设置检索表达式,并解析出该表达式可以检索出的记录数"
  [sid,exps]
  (
    let [param (conj (conj wos_advsearch_param {"SID" sid}) (conj wos_advsearch_param {"value(input1)" exps}))]
      (
        let [rst-htree (-> (client/get ((:headers (client/post "http://apps.webofknowledge.com/WOS_AdvancedSearch.do" {:form-params param
                                                                           ;:debug true 
                                                                           })) "Location")) :body parse as-hickory )]
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

(defn get-adv-param
  [^SearchModel model]
  (
    merge wos_advsearch_param {
                               "value(input1)" (.getExps model)
														   "value(input2)" (.getLanguage model)
														   "value(input3)" (.getDoctype model)
														   "startYear" (.getFromTime model)
														   "endYear" (.getToTime model)
                               }
  )
)
(defn set-search-adv
  "设置高级检索条件,并解析出该表达式可以检索出的记录数"
  [sid,^SearchModel model]
   (
    let [param (conj {"SID" sid} (get-adv-param model))]
      (
        let [rst-htree (-> (client/get (
                                         (:headers (client/post "http://apps.webofknowledge.com/WOS_AdvancedSearch.do" {:form-params param})
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
  [sid,exps,fNum,tNum]
  (
    let [selectedIds (clojure.string/join ";" (range fNum (+ 1 tNum)))
         totalMarked (+(- tNum fNum) 1)]
    (let [param (merge wos_outbound_param {"SID" sid} {"queryNatural" exps} {"mark_form" fNum} {"mark_to" tNum} {"selectedIds" selectedIds})]
      (client/post (str "http://apps.webofknowledge.com/OutboundService.do?action=go&totalMarked=" totalMarked)
                 {:form-params param
                  ;:debug true 
                  })
      )
    )
  )

(defn fetch-file
  [sid,exps,fNum,tNum]
  (
    let [url ((:headers (outbound sid exps fNum tNum)) "Location")]
    (
      :body (client/get url)
      )
    )
  )
