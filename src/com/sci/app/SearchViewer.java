package com.sci.app;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sci.app.toolkit.DBType;
import com.sci.app.view.ICondView;
import com.sci.app.view.impl.CondView;

public class SearchViewer extends JFrame{

	private static final int WIDTH = 800;
	private static final int HIGHT = 600;
	
	JPanel condPanel = new JPanel();
	
	
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
		
		//数据库选择
		JLabel dbLabel = new JLabel("数据库：");
		JComboBox dbBox = new JComboBox(DBType.getDBTypes());
		
		gbc.gridwidth = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		
		contentPane.add(dbLabel,gbc);
		contentPane.add(dbBox,gbc);
		
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		contentPane.add(strut1,gbc);
		
		ICondView condView = new CondView();
		JPanel condPanel = condView.getJPanel();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1;
		contentPane.add(condPanel,gbc);
		
//		JPanel bottomPanel = new JPanel();
//		bottomPanel.setBorder(BorderFactory.createTitledBorder("bottom"));
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.gridwidth = 0;
//		gbc.weightx = 1;
//		gbc.weighty = 1;
//		contentPane.add(bottomPanel,gbc);
		
		
		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new SearchViewer();
	}

}
