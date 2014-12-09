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
import com.sci.app.toolkit.DateToolkit;
import com.sci.app.view.IBaseCustomView;

public class BaseCustomView implements IBaseCustomView{

	private JPanel panel = null;
	private JComboBox dbComponent = null;
	private JTextField intervalComponent = null;
	private JTextField startTimeComponent = null;
	private JLabel startTimeTipComponent = null;
	
	public BaseCustomView(){
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		drawDB(panel);
		drawInterval(panel);
		drawStartTime(panel);
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
	@Override
	public JTextField getStartTimeComponent() {
		return startTimeComponent;
	}

	@Override
	public JLabel getStartTimeTipComponent() {
		return startTimeTipComponent;
	}

	private void drawDB(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel label = new JLabel("数据库：");
		dbComponent = new JComboBox(new DBComboBoxModel());
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		pl.add(label,gbc);
		gbc.gridwidth = 3;
		pl.add(dbComponent,gbc);
		
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		pl.add(strut1,gbc);
	}
	private void drawInterval(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel label = new JLabel("执行频率：");
		intervalComponent = new JTextField("5");
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
	private void drawStartTime(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel label = new JLabel("开始时间：");
		startTimeComponent = new JTextField(DateToolkit.getToday());
		startTimeComponent.setPreferredSize(new Dimension(180,20));
		startTimeTipComponent = new JLabel("格式如：2014-12-12 18:00:00");
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		pl.add(label,gbc);
		pl.add(startTimeComponent,gbc);
		pl.add(startTimeTipComponent,gbc);
		
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		pl.add(strut1,gbc);
	}

	

}
