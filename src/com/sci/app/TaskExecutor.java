package com.sci.app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;

import com.sci.app.model.FetcherTableModel;
import com.sci.app.model.SearchModel;

public class TaskExecutor {

	private static IFn requireFN = RT.var("clojure.core", "require").fn();

	static {
		requireFN.invoke(Symbol.intern("com.sci.app.clojure.core"));
	}
	private static IFn getSID = RT.var("com.sci.app.clojure.core",
			"getSID").fn();
	private static IFn set_search_exps = RT.var("com.sci.app.clojure.core",
			"set-search-exps").fn();
	private static IFn fetch_file = RT.var("com.sci.app.clojure.core",
			"fetch-file").fn();
	
	public static void execute(FetcherTableModel fetchertableModel,SearchModel searchModel){
		final SearchModel model = searchModel;
		final FetcherTableModel tableModel = fetchertableModel;
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.execute(new Runnable() {
			@Override
			public void run() {
				String sid = (String) getSID.invoke();
				System.out.println(sid);
				
				set_search_exps.invoke(sid,model.getExps());
				
				//tableModel.setValueAt(Integer.parseInt(showValue.split(":")[1]), Integer.parseInt(showValue.split(":")[0]), 1);
				System.out.println(fetch_file.invoke(model.getExps(),1000,1500));
			}
		});
	}
}
