package com.sci.app;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.sci.app.model.FetcherTableModel;
import com.sci.app.progressbar.ProgressBarRenderer;

public class FetcherTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TableCellLongTextRenderer textRender = new TableCellLongTextRenderer();

	public FetcherTable(FetcherTableModel model){
		super(model);
		this.setRowHeight(30);
		TableColumn sidColumn = this.getColumn(FetcherTableModel.SID_COLUMNNAME);
		sidColumn.setMaxWidth(0);
		sidColumn.setMinWidth(0);
		sidColumn.setWidth(0);
		sidColumn.setPreferredWidth(0);
		
		TableColumn statusCodeColumn = this.getColumn(FetcherTableModel.STATUSCODE_COLUMNNAME);
		statusCodeColumn.setMaxWidth(0);
		statusCodeColumn.setMinWidth(0);
		statusCodeColumn.setWidth(0);
		statusCodeColumn.setPreferredWidth(0);
		
		TableColumn dbNameColumn = this.getColumn(FetcherTableModel.DBNAME_COLUMNNAME);
		dbNameColumn.setPreferredWidth(150);
		TableColumn timespanColumn = this.getColumn(FetcherTableModel.TIMESPAN_COLUMNNAME);
		timespanColumn.setPreferredWidth(80);
		TableColumn intervalColumn = this.getColumn(FetcherTableModel.INTERVAL_COLUMNNAME);
		intervalColumn.setPreferredWidth(20);
		TableColumn startTimeColumn = this.getColumn(FetcherTableModel.STARTTIME_COLUMNNAME);
		startTimeColumn.setPreferredWidth(100);
		TableColumn statusColumn = this.getColumn(FetcherTableModel.STATUS_COLUMNNAME);
		statusColumn.setPreferredWidth(150);
		
		FetcherTableMouseAdapterListener tableMouseListener = new FetcherTableMouseAdapterListener(this);
		this.addMouseListener(tableMouseListener);
		this.addMouseMotionListener(tableMouseListener);
		
		TableColumn expsColumn = this.getColumn(FetcherTableModel.EXPS_COLUMNNAME);
		expsColumn.setPreferredWidth(150);
		expsColumn.setCellRenderer(textRender);
		
		TableColumn progressBar = this.getColumn(FetcherTableModel.PROGRESS_COLUMNNAME);
		progressBar.setCellRenderer(new ProgressBarRenderer());
	}
}

