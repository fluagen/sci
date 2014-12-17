package com.sci.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sci.app.model.FetcherModel;
import com.sci.app.toolkit.DateToolkit;
import com.sci.app.toolkit.MessageDialog;
import com.sci.app.view.IBaseCustomView;
import com.sci.app.view.ICondView;
import com.sci.app.view.impl.BaseCustomView;
import com.sci.app.view.impl.CondView;

public class FetcherTaskDialog {
	
	private static final int WIDTH = 800;
	private static final int HIGHT = 700;
	
	ICondView condView = null;
	IBaseCustomView baseCustomView = null;
	FetcherModel model;

	public  FetcherModel showDialog(JFrame owner,Boolean modal){
		
		final JDialog dialog = new JDialog(owner,modal);
		
		dialog.setSize(WIDTH, HIGHT);
		dialog.setTitle("创建抓取任务");
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		
		baseCustomView = BaseCustomView.getInstance();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		dialog.add(baseCustomView.getJPanle(),gbc);
		
		condView = CondView.getInstance();
		JPanel condPanel = condView.getJPanel();
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1;
		dialog.add(condPanel,gbc);
		
		
		JPanel bottomPanel = new JPanel();
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton btn = new JButton("确定");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new FetcherModel();
				if(baseCustomView.getDBComponent() != null){
					model.setDbName(baseCustomView.getDBComponent().getSelectedItem().toString());
				}
				if(baseCustomView.getStartTimeComponent() != null){
					model.setStartTime(baseCustomView.getStartTimeComponent().getText());
				}
				if(condView.getFromTimespanComponent() != null){
					model.setFromTime(condView.getFromTimespanComponent().getSelectedItem().toString());
				}
				if(condView.getToTimespanComponent() != null){
					model.setToTime(condView.getToTimespanComponent().getSelectedItem().toString());
				}
				if(condView.getLanguageComponent() != null){
					model.setLanguage(condView.getLanguageComponent().getSelectedValue().toString());
				}
				if(condView.getDoctypeComponent() != null){
					model.setDoctype(condView.getDoctypeComponent().getSelectedValue().toString());
				}
				if(condView.getExpsComponent() != null){
					model.setExps(condView.getExpsComponent().getText());
				}
//				System.out.println("model db:"+model.getDbName()+", fromtime:"+model.getFromTime()+", totime:"+model.getToTime()
//						+", exps:"+model.getExps());
				if(!verify(model)){
					model.setValid(false);
					return;
				}
				dialog.dispose();
			}
		});
		
		bottomPanel.add(btn);
		dialog.add(bottomPanel,gbc);
		
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
		return model;
	}
	
	private boolean verify(FetcherModel model){
		boolean passed = true;
		//验证任务开始时间格式
		if(!DateToolkit.verify(model.getStartTime())){
			MessageDialog.showMessage("请输入正确的日期格式！");
			return false;
		}
		if(model.getExps() == null || model.getExps().equals("")){
			MessageDialog.showMessage("请输入检索表达式！");
			return false;
		}
		return passed;
	}
}
