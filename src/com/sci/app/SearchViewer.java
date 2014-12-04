package com.sci.app;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sci.app.model.DBComboBoxModel;
import com.sci.app.model.SearchModel;
import com.sci.app.view.IBaseCustomView;
import com.sci.app.view.ICondView;
import com.sci.app.view.IDBView;
import com.sci.app.view.impl.BaseCustomView;
import com.sci.app.view.impl.CondView;
import com.sci.app.view.impl.DBView;

public class SearchViewer extends JFrame{

	private static final int WIDTH = 800;
	private static final int HIGHT = 600;
	
	ICondView condView = null;
	IDBView dbView = null;
	IBaseCustomView baseCustomView = null;
	
	
	public SearchViewer(){
		this.setTitle("");
		setSize(WIDTH, HIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}
	public void init(){
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		//数据库选择视图
//		dbView = new DBView();
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.gridwidth = 0;
//		gbc.weightx = 0;
//		gbc.weighty = 0;
//		contentPane.add(dbView.getJPanle(),gbc);
		
		baseCustomView = new BaseCustomView();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		contentPane.add(baseCustomView.getJPanle(),gbc);
		
		condView = new CondView();
		JPanel condPanel = condView.getJPanel();
//		gbc.gridx = 0;
//		gbc.gridy = 1;
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1;
		contentPane.add(condPanel,gbc);
		
		
		JPanel bottomPanel = new JPanel();
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		JButton btn = new JButton("检索");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchModel model = new SearchModel();
				if(baseCustomView.getDBComponent() != null){
					String code = DBComboBoxModel.nameCodeMap.get(baseCustomView.getDBComponent().getSelectedItem());
					model.setDbName(code);
				}
				if(condView.getFromTimespanComponent() != null){
					model.setFromTime(condView.getFromTimespanComponent().getSelectedItem().toString());
				}
				if(condView.getToTimespanComponent() != null){
					model.setToTime(condView.getToTimespanComponent().getSelectedItem().toString());
				}
				if(condView.getExpsComponent() != null){
					model.setExps(condView.getExpsComponent().getText());
				}
				System.out.println("model db:"+model.getDbName()+", fromtime:"+model.getFromTime()+", totime:"+model.getToTime()
						+", exps:"+model.getExps());
				
			}
		});
		
		bottomPanel.add(btn);
		
		contentPane.add(bottomPanel,gbc);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new SearchViewer();
	}

}
