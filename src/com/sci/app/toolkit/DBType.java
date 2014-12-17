package com.sci.app.toolkit;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class DBType {

	public static Vector<String> dbTypes = new Vector<String>();
	
	private static LinkedHashMap<String,String> productMap = new LinkedHashMap<String,String>();
	
	static{
		productMap.put("WOS", "Web of Science核心合集");
		productMap.put("BIOSIS", "BIOSIS Previews");
		productMap.put("DIIDW", "Derwent Innovations Index");
		productMap.put("INSPEC", "Inspec");
		productMap.put("KJD", "KCI-朝鲜语期刊数据库");
		productMap.put("MEDLINE", "MEDLINE");
		productMap.put("SCIELO", "SciELO Citation Index");
		
		dbTypes.addAll(productMap.values());
	}
	
	public static Vector<String> getDBTypes(){
		return dbTypes;
	}
	
	public static String getProduct(String dbName){
		String product = "";
		if(dbName == null || dbName.equals("")){
			return "";
		}
		for(Map.Entry<String, String> e : productMap.entrySet()){
			if(e.getValue().equals(dbName)){
				product = e.getKey();
				break;
			}
		}
		return product;
	}
}
