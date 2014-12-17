(ns com.sci.app.clojure.kjd)
(import 'com.sci.app.model.FetcherModel)

(def advsearch-url "http://apps.webofknowledge.com/KJD_AdvancedSearch.do")

(def adv-param
  {
   "product" "KJD"
   "search_mode" "AdvancedSearch"
   "action" "search"
   "value(searchOp)" "search"
   "value(select2)" "LA"
   "value(input2)" ""
   "value(select3)" "DT"
   "value(input3)" ""
   "value(limitCount)"	"14"
   "limitStatus" "collapsed"
   "ss_lemmatization" "On"
   "ss_spellchecking" "Suggest"
   "SinceLastVisit_UTC" ""
   "SinceLastVisit_DATE" ""
   "range" "ALL"
   "period"	"Year Range"
   "editions" "KJD"
   "update_back2search_link_param"	"yes"
   "ss_query_language" ""
   "rs_sort_by" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A.en"
   }
  )

(def outbound-param
  {
   "product" "KJD"
   "mark_id" "KJD"
   "colName" "KJD"
   "search_mode" "AdvancedSearch"
   "sortBy" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A.en"
   "mode" "OpenOutputService"
   "qid" "1"
   "format" "saveToFile"
   "filters" "TITLE SOURCE ISSN AUTHORSIDENTIFIERS ACCESSION_NUM AUTHORS"
   ;"mark_from" "1"
   ;"mark_to" "10"
   ;"incitesCount" "36776"
   ;"selectedIds" "11;12;13;14;15;16;17;18;19;20"
   "count_new_items_marked" "0"
   "IncitesEntitled" "no"
   "value(record_select_type)" "pagerecords"
   "fields_selection" "TITLE SOURCE ISSN AUTHORSIDENTIFIERS ACCESSION_NUM AUTHORS"
   "save_options" "fieldtagged"
   }
  )
(defn get-adv-param
  [sid,^FetcherModel model]
  (
    conj adv-param {
	                 "SID" sid
	                 "value(input1)" (.getExps model)
								   "value(input2)" (if (.contains (.getLanguage model) "All languages") "" (.getLanguage model) )
								   "value(input3)" (if (.contains (.getDoctype model) "All document") "" (.getDoctype model))
								   "startYear" (.getFromTime model)
								   "endYear" (.getToTime model)
	                 }
    )
  )
(defn get-outbound-param
  [sid,^FetcherModel model]
  (
    conj outbound-param {
                         "SID" sid
                         "queryNatural" (.getExps model)
                         }
    )
  )

