package com.sci.app.view;

import javax.swing.Box;

public interface IDBViewer {

	//检索表达式视图
	public void drawExps(Box horizontalBox);
	
	//语种视图
	public void drawLanguage(Box horizontalBox);
	
	//时间跨度视图
	public void drawTimespan(Box horizontalBox);
	
	//文献类型视图
	public void drawDoctype(Box horizontalBox);
}
