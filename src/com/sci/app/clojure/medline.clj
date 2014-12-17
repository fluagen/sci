(ns com.sci.app.clojure.medline)
(import 'com.sci.app.model.FetcherModel)

(def advsearch-url "http://apps.webofknowledge.com/MEDLINE_AdvancedSearch.do")

(def adv-param
  {
   "product" "MEDLINE"
   "search_mode" "AdvancedSearch"
   "action" "search"
   "value(searchOp)" "search"
   "value(select2)" "LA"
   "value(input2)" ""
   "value(select3)" "DT"
   "value(input3)" ""
   "value(select8)"	"CSUB"
   "value(input8)"	""
   "value(select9)"	"ALZ"
   "value(input9)"	""
   "value(select10)"	"SLZ"
   "value(input10)"	""
   "value(select11)"	"GLZ"
   "value(input11)"	""
   "value(select12)"	"DB"
   "value(input12)"	""
   "value(select14)"	"ST"
   "value(input14)"	""
   "value(limitCount)"	"14"
   "limitStatus" "collapsed"
   "ss_lemmatization" "On"
   "ss_spellchecking" "Suggest"
   "SinceLastVisit_UTC" ""
   "SinceLastVisit_DATE" ""
   "range" "ALL"
   "period"	"Year Range"
   "editions" "MEDLINE"
   "update_back2search_link_param"	"yes"
   "ss_query_language" ""
   "rs_sort_by" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A"
   }
  )

(def outbound-param
  {
   "product" "MEDLINE"
   "mark_id" "MEDLINE"
   "colName" "MEDLINE"
   "search_mode" "AdvancedSearch"
   "sortBy" "PY.D;LD.D;SO.A;VL.D;PG.A;AU.A"
   "mode" "OpenOutputService"
   "qid" "1"
   "format" "saveToFile"
   "filters" "AUTHORSIDENTIFIERS ACCESSION_NUM ISSN ABSTRACT SOURCE TITLE AUTHORS"
   ;"mark_from" "1"
   ;"mark_to" "10"
   ;"incitesCount" "36776"
   ;"selectedIds" "11;12;13;14;15;16;17;18;19;20"
   "count_new_items_marked" "0"
   "IncitesEntitled" "no"
   "value(record_select_type)" "pagerecords"
   "fields_selection" "AUTHORSIDENTIFIERS ACCESSION_NUM ISSN ABSTRACT SOURCE TITLE AUTHORS"
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

