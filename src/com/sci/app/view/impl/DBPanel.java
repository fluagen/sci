package com.sci.app.view.impl;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sci.app.toolkit.DBType;

public class DBPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBPanel(){
		
		JLabel db = new JLabel("数据库：");
		JComboBox dbBox = new JComboBox(DBType.getDBTypes());
		dbBox.setPreferredSize(new Dimension(10, 10));
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.add(db);
		//this.add(Box.createHorizontalStrut(10));
		this.add(dbBox);
		
		
		this.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		this.setPreferredSize(new Dimension(50, 50));
		
	}
}
