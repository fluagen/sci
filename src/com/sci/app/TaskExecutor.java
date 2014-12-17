package com.sci.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.sci.app.fetch.Fetcher;
import com.sci.app.model.FetcherModel;
import com.sci.app.model.FetcherTableModel;
import com.sci.app.progressbar.ProgressBarRenderer;
import com.sci.app.toolkit.DateToolkit;
import com.sci.app.toolkit.Pagination;

public class TaskExecutor {

	
	public static void execute(FetcherTableModel fetchertableModel,FetcherModel fetcherModel){
		final FetcherModel model = fetcherModel;
		final FetcherTableModel tableModel = fetchertableModel;
		final int row = tableModel.getRowCount()-1;
		
//		tableModel.setValueAt("任务未启动", row, statusColumnIndex);
		tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_WAIT, "任务未启动");
		
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.schedule(new Runnable() {
			@Override
			public void run() {
//				System.out.println("TaskExecutor scheduled time:"+ new Date());
//				tableModel.setValueAt("任务执行中", row, statusColumnIndex);
				tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_RUNNING, "任务执行中");
				int interval = Integer.parseInt(model.getInterval());
				int perNum = 50;
				Fetcher fetcher = new Fetcher(model);
				String sid = fetcher.getSid();
				if(sid == null || sid.equals("")){
//					tableModel.setValueAt("生成SID失败，请检查你的IP是否合法和网络是否异常", row, statusColumnIndex);
					tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_FAIL, "生成SID失败，请检查你的IP是否合法和网络是否异常");
					return;
				}else{
					tableModel.setValueAt(sid, row, tableModel.getSidColumnIndex());
				}
				int total = fetcher.getRecordTotal();
				if(total == 0){
//					tableModel.setValueAt("抓取的记录数为0，请检查你配置的抓取条件", row, statusColumnIndex);
					tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_FAIL, "抓取的记录数为0，请检查你配置的抓取条件");
					return;
				}
				int pagenum = Pagination.countPageNum(total, perNum);
				System.out.println("total:"+total+",pagenum:"+pagenum);
				
				
				for(int i=1; i<=pagenum; i++){
					fetcher.fetch(Pagination.getStartNum(i, perNum), Pagination.getEndNum(i, perNum));
					tableModel.updateProgress(row, ProgressBarRenderer.getProgrees(i, pagenum));
					try {
						Thread.sleep(interval*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				fetcher.mergeTxt();
				tableModel.updateProgress(row, 100);
				tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_OK, "任务完成");
			}
		}, DateToolkit.delay(model.getStartTime()), TimeUnit.MILLISECONDS);
	}
	
}
