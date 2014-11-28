package com.sci.app.toolkit;

import java.util.Vector;

public class DBType {

	private static Vector<String> dbTypes = new Vector<String>();
	
	private static Vector<String> create(){
		Vector<String> v = new Vector<String>();
		v.add("Web of Science核心合集");
		v.add("BIOSIS Previews");
		v.add("Derwent Innovations Index");
		v.add("Inspec");
		v.add("KCI-朝鲜语期刊数据库");
		v.add("MEDLINE");
		v.add("SciELO Citation Index");
		return v;
	}
	
	public static Vector<String> getDBTypes(){
		if(dbTypes == null || dbTypes.isEmpty()){
			dbTypes = create();
		}
		return dbTypes;
	}
}
