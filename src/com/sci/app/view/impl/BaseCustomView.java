package com.sci.app.view.impl;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sci.app.model.DBComboBoxModel;
import com.sci.app.view.IBaseCustomView;

public class BaseCustomView implements IBaseCustomView{

	private JPanel panel = null;
	private JComboBox dbComponent = null;
	private JTextField intervalComponent = null;
	
	public BaseCustomView(){
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		drawDB(panel);
		drawInterval(panel);
	}
	
	@Override
	public JPanel getJPanle() {
		return panel;
	}

	@Override
	public JComboBox getDBComponent() {
		return dbComponent;
	}

	@Override
	public JTextField getIntervalComponent() {
		return intervalComponent;
	}

	private void drawDB(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		JLabel label = new JLabel("数据库：");
		//label.setPreferredSize(new Dimension(100,20));
		dbComponent = new JComboBox(new DBComboBoxModel());
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		pl.add(label,gbc);
		gbc.gridwidth = 3;
		pl.add(dbComponent,gbc);
		
		JPanel strut1 = new JPanel();
//		gbc.gridwidth = 1;
//		gbc.weightx = 0;
//		gbc.weighty = 0;
//		pl.add(strut1,gbc);
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		pl.add(strut1,gbc);
	}
	private void drawInterval(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		JLabel label = new JLabel("执行频率：");
		intervalComponent = new JTextField("30");
		intervalComponent.setPreferredSize(new Dimension(50,20));
		JLabel label2 = new JLabel("秒");
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		
		pl.add(label,gbc);
		pl.add(intervalComponent,gbc);
		//gbc.gridwidth = 2;
		pl.add(label2,gbc);
		
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		pl.add(strut1,gbc);
	}
	
}
