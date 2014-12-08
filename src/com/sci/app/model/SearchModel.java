package com.sci.app.model;

public class SearchModel {

	private String dbName;
	private String fromTime = "1900";
	private String toTime = "2020";
	private String language = "";
	private String doctype = "";
	private String exps = "";
	
	private String interval = "30";//秒单位
	private String startupTime = "";//启动时间
	
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getExps() {
		return exps;
	}
	public void setExps(String exps) {
		this.exps = exps;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getStartupTime() {
		return startupTime;
	}
	public void setStartupTime(String startupTime) {
		this.startupTime = startupTime;
	}
}
