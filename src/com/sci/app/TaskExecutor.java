package com.sci.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.sci.app.fetch.Fetcher;
import com.sci.app.model.FetcherTableModel;
import com.sci.app.model.SearchModel;
import com.sci.app.progressbar.ProgressBarRenderer;
import com.sci.app.toolkit.Pagination;

public class TaskExecutor {

	
	public static void execute(FetcherTableModel fetchertableModel,SearchModel searchModel){
		final SearchModel model = searchModel;
		final FetcherTableModel tableModel = fetchertableModel;
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.execute(new Runnable() {
			@Override
			public void run() {
				int row = tableModel.getRowCount()-1;
				int column = tableModel.getColumnCount()-1;
				int perNum = 50;
				Fetcher fetcher = new Fetcher(model);
				int total = fetcher.getRecordTotal();
				int pagenum = Pagination.countPageNum(total, perNum);
				System.out.println("total:"+total+",pagenum:"+pagenum);
				for(int i=1; i<=pagenum; i++){
					fetcher.fetch(Pagination.getStartNum(i, perNum), Pagination.getEndNum(i, perNum));
					tableModel.setValueAt(ProgressBarRenderer.getProgrees(i, pagenum), row, column);
					try {
						Thread.sleep(2*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				fetcher.mergeTxt();
				tableModel.setValueAt(100, row, column);
			}
		});
	}
	
}
