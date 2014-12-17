package com.sci.app.toolkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;

public class SavedrescMerger {
	
	private static String PT = "PT ";
	private static String UT_WOS = "UT WOS:";
	private static String UT_BIOSIS = "UT BIOSIS:";
	private static String UT_DIIDW = "UT DIIDW:";
	private static String UT_INSPEC = "UT INSPEC:";
	private static String UT_KJD = "UT KJD:";
	private static String UT_MEDLINE = "UT MEDLINE:";
	private static String UT_SCIELO = "UT SCIELO:";
	
	private static String ER = "ER\r\n";

	/**
	 * key : UT
	 * value : 一条记录拼接的字符串 
	 */
	public static LinkedHashMap<String,StringBuilder> mergeSavedresc(List<File> savedFiles){
		if(savedFiles == null || savedFiles.isEmpty()){
			return null;
		}
		LinkedHashMap<String,StringBuilder> rst = new LinkedHashMap<String,StringBuilder>();
		for(int i=0; i<savedFiles.size(); i++){
			File f = savedFiles.get(i);
			try {
				rst.putAll(parseToMap(f));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rst;
	}
	/**
	 * key : UT
	 * value : 一条记录拼接的字符串 
	 */
	public static LinkedHashMap<String,StringBuilder> parseToMap(File savedFile) throws Exception{
		LinkedHashMap<String,StringBuilder> buf = new LinkedHashMap<String,StringBuilder>();
		BufferedReader reader = new BufferedReader(new FileReader(savedFile));
		String line = "";
		StringBuilder builder = null;
		while((line = reader.readLine()) != null){
			if(line.startsWith(PT)){//记录头
				builder = new StringBuilder();
			}
			if(builder == null) continue;
			
			builder.append(line+"\n");
			
			if(line.contains(UT_WOS) || line.contains(UT_BIOSIS) || line.contains(UT_DIIDW) ||
					line.contains(UT_INSPEC) || line.contains(UT_KJD) || line.contains(UT_MEDLINE) ||
					line.contains(UT_SCIELO)){
//				System.out.println(line);
				buf.put(line, builder);
			}
		}
		reader.close();
		return buf;
	}
}
