package com.sci.app.toolkit;

public class Pagination {

	
	public static int getStartNum(int pageNum,int perNum){
		return (pageNum-1)*perNum +1 ;
	}
	
	public static int getEndNum(int pageNum,int perNum){
		return pageNum*perNum;
	}
	
	public static int countPageNum(int total,int perNum){
		int pagenum = total / perNum;
		if(pagenum%perNum > 0){
			pagenum += 1;
		}
		return pagenum;
	}
}
