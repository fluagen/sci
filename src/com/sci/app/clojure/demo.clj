(ns com.sci.app.clojure.demo)

(require '[clj-http.client :as client])
;(clojure.pprint/pprint cs)

;(client/get "http://apps.webofknowledge.com/" {:accept :json})
;(def cs (clj-http.cookies/cookie-store))
;(client/get "http://site.com/resources/3" {:accept :json} )

(def cs (clj-http.cookies/cookie-store))
(client/get "http://apps.webofknowledge.com/" {:cookie-store cs})

(defn sid [] (
               
           doseq [a (. cs getCookies)]
					  (if(= "SID" (. a getName))
					     (println (. a getValue))  
					    )
            )
 )


(defn sid [] 
  (
    for [a (. cs getCookies)
        :let [x (. a getName)]
        :when (= "SID" x)
        ] 
     (. a getValue)
    )
 )

