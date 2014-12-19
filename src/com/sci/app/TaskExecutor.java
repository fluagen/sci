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
				tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_RUNNING, "任务执行中...");
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
				
				String runningInfo = "";
				for(int i=1; i<=pagenum; i++){
					int startNum = Pagination.getStartNum(i, perNum);
					int endNum = Pagination.getEndNum(i, perNum);
					fetcher.fetch(startNum, endNum);
					tableModel.updateProgress(row, ProgressBarRenderer.getProgrees(i, pagenum));
					runningInfo = "任务执行中...\n"
							+ "共"+total+"条记录，已抓取"+endNum+"条记录";
					tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_RUNNING, runningInfo);
					try {
						Thread.sleep(interval*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				fetcher.mergeTxt();
				tableModel.updateProgress(row, 100);
				runningInfo = "任务已完成\n"
						+ "共抓取到"+total+"条记录";
				tableModel.setTaskStatus(row, FetcherTableModel.STATUSCODE_OK, runningInfo);
			}
		}, DateToolkit.delay(model.getStartTime()), TimeUnit.MILLISECONDS);
	}
	
}
