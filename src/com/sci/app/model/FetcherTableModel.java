package com.sci.app.model;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class FetcherTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	
	
	public static final String STATUSCODE_WAIT = "wait";
	public static final String STATUSCODE_RUNNING = "running";
	public static final String STATUSCODE_FAIL = "fail";
	public static final String STATUSCODE_OK = "ok";
	
	public static final String SID_COLUMNNAME = "SID";
	public static final String STATUSCODE_COLUMNNAME = "statusCode";
	public static final String DBNAME_COLUMNNAME = "数据库";
	public static final String TIMESPAN_COLUMNNAME = "时间范围";
	public static final String LANGUAGE_COLUMNNAME = "语种";
	public static final String DOCTYPE_COLUMNNAME = "文献类型";
	public static final String EXPS_COLUMNNAME = "检索表达式";
	public static final String INTERVAL_COLUMNNAME = "频率";
	public static final String STARTTIME_COLUMNNAME = "开始时间";
	public static final String STATUS_COLUMNNAME = "执行状态";
	public static final String PROGRESS_COLUMNNAME = "执行进度";
	
	private int statusColumnIndex;
	private int progressColumnIndex;
	private int sidColumnIndex;
	private int statusCodeColumnIndex;

	public FetcherTableModel(){
		super();
		addColumn(SID_COLUMNNAME);
		addColumn(STATUSCODE_COLUMNNAME);
		addColumn(DBNAME_COLUMNNAME);
		addColumn(TIMESPAN_COLUMNNAME);
		addColumn(LANGUAGE_COLUMNNAME);
		addColumn(DOCTYPE_COLUMNNAME);
		addColumn(EXPS_COLUMNNAME);
		addColumn(INTERVAL_COLUMNNAME);
		addColumn(STARTTIME_COLUMNNAME);
		addColumn(STATUS_COLUMNNAME);
		addColumn(PROGRESS_COLUMNNAME);
		
		int count = this.getColumnCount();
		this.statusColumnIndex = count -2;
		this.progressColumnIndex = count -1;
		this.sidColumnIndex = 0;
		this.statusCodeColumnIndex = 1;
		
	}
	
	public void setTaskStatus(int row, String statusCode, String statusValue){
		if(statusCode == null || statusCode.equals("")){
			return;
		}
		setValueAt(statusCode, row, statusCodeColumnIndex);
		setValueAt(statusValue, row, statusColumnIndex);
	}
	
	public void updateProgress(int row,int progress){
		this.setValueAt(progress, row, progressColumnIndex);
	}
	
	/**
	 * 设置为不可编辑
	 */
	public boolean isCellEditable(int row, int column) {
        return false;
    }
	
	public void addRow(FetcherModel model){
		if(model != null){
			Vector<Object> row = new Vector<Object>();
			row.add(model.getSid());
			row.add(STATUSCODE_WAIT);
			row.add(model.getDbName());
			String timespan = model.getFromTime() +" 至 "+ model.getToTime();
			row.add(timespan);
			row.add(model.getLanguage());
			row.add(model.getDoctype());
			row.add(model.getExps());
			row.add(model.getInterval()+" 秒");
			row.add(model.getStartTime());
			row.add("");//执行状态
			row.add(0);//执行进度条
			
			this.addRow(row);
		}
	}

	public int getSidColumnIndex() {
		return sidColumnIndex;
	}

	public int getStatusCodeColumnIndex() {
		return statusCodeColumnIndex;
	}

}
