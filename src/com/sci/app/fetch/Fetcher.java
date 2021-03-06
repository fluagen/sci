package com.sci.app.fetch;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;

import com.sci.app.model.FetcherModel;
import com.sci.app.toolkit.DBType;

public class Fetcher {

	private static IFn requireFN = RT.var("clojure.core", "require").fn();

	static {
		requireFN.invoke(Symbol.intern("com.sci.app.clojure.core"));
	}
	private static IFn getSID = RT.var("com.sci.app.clojure.core",
			"getSID").fn();
	private static IFn getProductProp = RT.var("com.sci.app.clojure.core",
			"get-product-prop").fn();
	private static IFn set_search_adv = RT.var("com.sci.app.clojure.core",
			"set-search-adv").fn();
	private static IFn fetch_file = RT.var("com.sci.app.clojure.core",
			"fetch-file").fn();
	
	private static String ROOTDIC = System.getProperty("user.dir")+File.separator+"fetchFile";
	private static String SAVEDRESC = "save/savedrecs.txt";
	private static String CHARTSET = "UTF-8";
	
	FetcherModel model;
	File localDic;
	String sid;
	Object productProp;
	
	public Fetcher(FetcherModel fetcherModel){
		this.model = fetcherModel;
		this.model.setProduct(DBType.getProduct(fetcherModel.getDbName()));
		sid = makeSid(fetcherModel);
		localDic = makeLocalDic(sid);
		productProp = getProductProp.invoke(sid,this.model);
	}
	
	
	private File makeLocalDic(String sid){
		File dic = new File(ROOTDIC+File.separator+sid);
		if(!dic.exists()){
			dic.mkdirs();
		}
		return dic;
	}
	
	private String makeSid(FetcherModel model){
		String sid = (String) getSID.invoke();
		if(sid == null || sid.trim().equals("")){
			return "";
		}
		System.out.println("sid:"+sid);
		return sid;
	}
	public String getSid(){
		return sid;
	}
	
	public Integer getRecordTotal(){
		int total = 0;
		try{
			String countRecord = (String)set_search_adv.invoke(productProp);
			countRecord = countRecord.replace(",", "");
			total = Integer.parseInt(countRecord);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return total;
	}
	
	public String fetch(int startNum,int endNum){
		
		String content = (String) fetch_file.invoke(productProp,startNum,endNum);
		
		write(startNum,endNum,content);
		
		return content;
	}
	
	private void write(int startNum,int endNum,String content){
		File f = new File(localDic.getPath()+File.separator+startNum+"_"+endNum+".txt");
		try {
//			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			out.write(content.getBytes(CHARTSET));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean mergeTxt(){
		File[] files = localDic.listFiles();
		if(files == null || files.length == 0){
			return false;
		}
		try{
			File dic = new File(localDic.getPath()+File.separator+"save");
			dic.mkdirs();
			File savedrecs = new File(localDic.getPath()+File.separator+SAVEDRESC);
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(savedrecs));
			for(int i=0; i<files.length; i++){
				//File f = files[i];
				//if(f.isDirectory()) continue;
				BufferedReader reader = new BufferedReader(new FileReader(files[i]));
				
				String line = "";
				while((line = reader.readLine()) != null){
					if(line.contains("FN") || line.contains("VR") || line.contains("EF")){
						continue;
					}
					line = line + "\n";
					out.write(line.getBytes(CHARTSET));
					out.flush();
				}
				reader.close();
			}
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String getRootDic(){
		return ROOTDIC;
	}
	
	public static String getSavedresc(){
		return SAVEDRESC;
	}
	
	public static void main(String[] args){
		File f = new File("F:/workspace/sci-app/sci/fetchFile/4FgJ9QL6i8LG1UpfmAJ");
		File[] files = f.listFiles();
		try{
			File dic = new File("F:/workspace/sci-app/sci/fetchFile/4FgJ9QL6i8LG1UpfmAJ/save");
			dic.mkdirs();
			File savedrecs = new File("F:/workspace/sci-app/sci/fetchFile/4FgJ9QL6i8LG1UpfmAJ/save/savedrecs.txt");
			PrintWriter writer = new PrintWriter(savedrecs);
			
			for(int i=0; i<files.length; i++){
				File f2 = files[i];
				if(f2.isDirectory()) continue;
				BufferedReader reader = new BufferedReader(new FileReader(files[i]));
				String line = "";
				while((line = reader.readLine()) != null){
					if(line.contains("FN") || line.contains("VR") || line.contains("EF")){
						continue;
					}
//					writer.write(line);
					writer.println(line);
					writer.flush();
				}
				reader.close();
				writer.flush();
			}
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
