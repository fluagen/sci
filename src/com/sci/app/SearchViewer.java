package com.sci.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sci.app.toolkit.DBType;
import com.sci.app.view.IDBViewer;
import com.sci.app.view.impl.DBViewer;

public class SearchViewer extends JFrame{

	private static final int WIDTH = 800;
	private static final int HIGHT = 600;
	
	JPanel condPanel = new JPanel();
	
	
	public SearchViewer(){
		this.setTitle("");
		setSize(WIDTH, HIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initViewer(){
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		
		
		//数据库选择
		JLabel db = new JLabel("数据库：");
		JComboBox dbBox = new JComboBox(DBType.getDBTypes());
		dbBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					
					IDBViewer viewer = new DBViewer();
					Box horizontalBox = Box.createHorizontalBox();
					viewer.drawTimespan(horizontalBox);
					Box horizontalBox2 = Box.createHorizontalBox();
					viewer.drawLanguage(horizontalBox2);
					Box horizontalBox3 = Box.createHorizontalBox();
					viewer.drawExps(horizontalBox3);
					
					Box vbox = Box.createVerticalBox();
					vbox.add(horizontalBox);
					vbox.add(horizontalBox2);
					vbox.add(horizontalBox3);
					
					condPanel.removeAll();
					condPanel.invalidate();
					condPanel.setBorder(BorderFactory.createTitledBorder(e.getItem().toString()));
					condPanel.add(vbox);
					condPanel.validate();
					
				}
			}
		});
		Box hbox = Box.createHorizontalBox();
		hbox.add(db);
		hbox.add(dbBox);
		
		Box hbox2 = Box.createHorizontalBox();
		condPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		hbox2.add(condPanel);
		
		Box topBox = Box.createVerticalBox();
		topBox.add(hbox);
		topBox.add(hbox2);
		
		panel.add(topBox);
		panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		
		dbBox.setSelectedIndex(1);
		
		//contentPane.add(panel);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		SearchViewer v = new SearchViewer();
		v.initViewer();
	}

}
