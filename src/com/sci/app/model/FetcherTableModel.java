package com.sci.app.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class FetcherTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	public FetcherTableModel(){
		super();
		addColumn("数据库");
		addColumn("时间范围");
		addColumn("语种");
		addColumn("文献类型");
		addColumn("检索表达式");
		addColumn("频率");
		addColumn("执行状态");
	}
	
	/**
	 * 设置为不可编辑
	 */
	public boolean isCellEditable(int row, int column) {
        return false;
    }
	
	public void addRow(SearchModel searchModel){
		if(searchModel != null){
			Vector<Object> row = new Vector<Object>();
			row.add(searchModel.getDbName());
			String timespan = searchModel.getFromTime() +" 至 "+ searchModel.getToTime();
			row.add(timespan);
			row.add(searchModel.getLanguage());
			row.add(searchModel.getDoctype());
			row.add(searchModel.getExps());
			row.add("");
			row.add(0);//执行进度条
			
			this.addRow(row);
		}
	}
}