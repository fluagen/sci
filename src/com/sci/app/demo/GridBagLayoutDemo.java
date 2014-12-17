package com.sci.app.demo;

/*
 * GirdBagLayoutDemo.java requires no other files.
 */
 

import java.awt.Container;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;

 
public class GridBagLayoutDemo extends JFrame{
	
	private JButton btn1 = new JButton("Button1");
	private JButton btn2 = new JButton("Button2");
	private JButton btn3 = new JButton("Button3 what a fine day");
	private JButton btn4 = new JButton("Button4 what a fine da");
	private JButton btn5 = new JButton("Button5 what a fine d");
	private JButton btn6 = new JButton("Button6 what a fines");
	
	GridBagLayoutDemo()
	{
		super();
		initComponent();
		
	}
	private void initComponent()
	{
		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints ctr1 = new GridBagConstraints();
		ctr1.gridx = 0;
		ctr1.gridy = 0;
		ctr1.weighty = 3;
		//ctr1.weightx = 1;
		ctr1.gridwidth = 4;
		ctr1.gridheight = 1;
		//ctr1.anchor = GridBagConstraints.WEST;
		ctr1.fill = GridBagConstraints.HORIZONTAL;
		container.add(btn1,ctr1);
		
		GridBagConstraints ctr2 = new GridBagConstraints();
		ctr2.gridx = 0;
		ctr2.gridy = 1;
		ctr2.weighty = 2;
		//ctr2.weightx = 2;
		ctr2.gridwidth = 2;
		ctr2.gridheight = 1;
		//ctr2.anchor = GridBagConstraints.WEST;
		ctr2.fill = GridBagConstraints.HORIZONTAL;
		container.add(btn2,ctr2);
		
		GridBagConstraints ctr3 = new GridBagConstraints();
		ctr3.gridx= 2;
		ctr3.gridy = 1;
		ctr3.weighty = 2;
		//ctr3.weightx = 1;
		ctr3.gridwidth = 1;
		ctr3.gridheight = 1;
		//ctr3.anchor = GridBagConstraints.WEST;
		ctr3.fill = GridBagConstraints.HORIZONTAL;
		ctr3.insets = new Insets(0,20,0,0);//top,left,bottom,right
		ctr3.ipady = 40;
		container.add(btn3,ctr3);
		
		GridBagConstraints ctr4 = new GridBagConstraints();
		ctr4.gridx = 0;
		ctr4.gridy = 2;
		ctr4.weighty = 1;
		//ctr4.weightx = 3;
		ctr4.gridwidth = 1;
		ctr4.gridheight = 1;
		//ctr4.anchor = GridBagConstraints.WEST;
		ctr4.fill = GridBagConstraints.HORIZONTAL;
		container.add(btn4,ctr4);
		
		GridBagConstraints ctr5 = new GridBagConstraints();
		ctr5.gridx = 1;
		ctr5.gridy = 2;
		ctr5.weighty = 1;
		//ctr5.weightx = 2;
		ctr5.gridwidth = 1;
		ctr5.gridheight = 1;
		//ctr5.anchor = GridBagConstraints.WEST;
		ctr5.fill = GridBagConstraints.HORIZONTAL;
		container.add(btn5,ctr5);
		
		GridBagConstraints ctr6 = new GridBagConstraints();
		ctr6.gridx = 2;
		ctr6.gridy = 2;
		ctr6.weighty = 1;
		//ctr6.weightx = 1;
		ctr6.gridwidth = 2;
		ctr6.gridheight = 1;
		ctr6.fill = GridBagConstraints.HORIZONTAL;
		container.add(btn6,ctr6);
	}
	
	public static void main(String[] args)
	{
		GridBagLayoutDemo frame = new GridBagLayoutDemo();
		frame.pack();
		frame.setVisible(true);
	}
	
}

