(ns com.sci.app.clojure.diidw)
(import 'com.sci.app.model.FetcherModel)

(def advsearch-url "http://apps.webofknowledge.com/DIIDW_AdvancedSearch.do")

(def adv-param
  {
   "product" "DIIDW"
   "search_mode" "AdvancedSearch"
   "action" "search"
   "value(searchOp)" "search"
   "limitStatus" "collapsed"
   "ss_lemmatization" "On"
   "ss_spellchecking" "Suggest"
   "SinceLastVisit_UTC" ""
   "SinceLastVisit_DATE" ""
   "range" "ALL"
   "period"	"Year Range"
   "editions" ["CDerwent","EDerwent","MDerwent"]
   "update_back2search_link_param"	"yes"
   "ss_query_language" ""
   "rs_sort_by" "Date"
   }
  )

(def outbound-param
  {
   "product" "DIIDW"
   "mark_id" "DIIDW"
   "colName" "DIIDW"
   "search_mode" "AdvancedSearch"
   "sortBy" "Date"
   "mode" "OpenQuickOutputForDII"
   "qid" "1"
   "format" "saveToFile"
   "filters" "FullNoCitRef"
   ;"mark_from" "1"
   ;"mark_to" "10"
   ;"incitesCount" "36776"
   ;"selectedIds" "11;12;13;14;15;16;17;18;19;20"
   "count_new_items_marked" "0"
   "IncitesEntitled" "no"
   "value(record_select_type)" "pagerecords"
   "fields_selection" "FullNoCitRef"
   "save_options" "fieldtagged"
   }
  )
(defn get-adv-param
  [sid,^FetcherModel model]
  (
    conj adv-param {
	                 "SID" sid
	                 "value(input1)" (.getExps model)
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
