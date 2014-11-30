package com.sci.app.view.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sci.app.toolkit.Timespan;
import com.sci.app.view.ICondView;

public class CondView implements ICondView{

	private static JPanel panel = null;
	
	private static JPanel createJPanel(){
		if(panel == null){
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(400,500));
//			panel.setSize(new Dimension(400,500));
			panel.setBorder(BorderFactory.createTitledBorder("检索条件"));
			panel.setLayout(new GridBagLayout());
			
			drawTimespan(panel);
			
		}
		return panel;
	}
	
	public static void drawTimespan(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel timespan = new JLabel("时间跨度：");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(timespan,gbc);
		
//		JPanel strut = new JPanel();
//		gbc.gridwidth = 0;
//		gbc.weightx = 1;
//		gbc.weighty = 0;
		
		JLabel from = new JLabel("从");
		panel.add(from,gbc);
		JComboBox fComboBox = new JComboBox(Timespan.getTimespan());
		panel.add(fComboBox,gbc);
		JLabel to = new JLabel("到");
		panel.add(to,gbc);
		JComboBox tComboBox = new JComboBox(Timespan.getTimespan());
		panel.add(tComboBox,gbc);
		
		JPanel strut = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		panel.add(strut,gbc);
		
	}
	
	
	@Override
	public JPanel getJPanel() {
		return createJPanel();
	}

}
