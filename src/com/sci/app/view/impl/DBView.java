package com.sci.app.view.impl;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sci.app.model.DBComboBoxModel;
import com.sci.app.toolkit.DBType;
import com.sci.app.view.IDBView;

public class DBView implements IDBView{

	private JPanel panel = null;
	private JComboBox dbComponent = null;
	
	
	public DBView(){
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		drawDB(panel);
	}
	
	private void drawDB(JPanel pl){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		JLabel dbLabel = new JLabel("数据库：");
		dbComponent = new JComboBox(new DBComboBoxModel());
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		pl.add(dbLabel,gbc);
		pl.add(dbComponent,gbc);
		
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		pl.add(strut1,gbc);
	}
	
	@Override
	public JPanel getJPanle() {
				
		return panel;
	}

	@Override
	public JComboBox getDBComponent() {
		
		return dbComponent;
	}

}
