package com.sci.app.view.impl;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import com.sci.app.toolkit.DocType;
import com.sci.app.toolkit.Language;
import com.sci.app.toolkit.Timespan;
import com.sci.app.toolkit.UIIdentity;
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
			drawLanguage(panel);
			drawDoctype(panel);
			drawExps(panel);
			drawBottom(panel);
			
		}
		return panel;
	}
	
	public static void drawTimespan(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		JLabel timespan = new JLabel("时间跨度：");
		timespan.setPreferredSize(new Dimension(100,10));
		gbc.fill = GridBagConstraints.BOTH;
//		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(timespan,gbc);
		
//		JPanel strut = new JPanel();
//		gbc.gridwidth = 0;
//		gbc.weightx = 1;
//		gbc.weighty = 0;
		
		JLabel from = new JLabel("从");
//		from.setPreferredSize(new Dimension(30,10));
		panel.add(from,gbc);
		JComboBox fComboBox = new JComboBox(Timespan.getTimespan());
		fComboBox.setName(UIIdentity.FROM_TIME_COMBOBOX);
		panel.add(fComboBox,gbc);
		JLabel to = new JLabel("到");
//		to.setPreferredSize(new Dimension(30,10));
		panel.add(to,gbc);
		JComboBox tComboBox = new JComboBox(Timespan.getTimespan());
		tComboBox.setName(UIIdentity.TO_TIME_COMBOBOX);
		panel.add(tComboBox,gbc);
		
		JPanel strut = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		panel.add(strut,gbc);
		
	}
	
	public static void drawLanguage(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		JLabel label = new JLabel("语种：");
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		JList list = new JList(Language.getLanguages());
		list.setName(UIIdentity.LANGUAGE_LIST);
		//list.setPreferredSize(new Dimension(200,80));
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(150, 80));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 5;
		gbc.weightx = 1;
		panel.add(scroll,gbc);
		
		JPanel strut = new JPanel();
		strut.setPreferredSize(new Dimension(150,80));
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		panel.add(strut,gbc);
		
	}
	
	public static void drawDoctype(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("文献类型：");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		JList list = new JList(DocType.getDocTypes());
		list.setName(UIIdentity.DOCTYPE_LIST);
		//list.setPreferredSize(new Dimension(200,80));
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(150, 80));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 5;
		gbc.weightx = 1;
		panel.add(scroll,gbc);
		
		JPanel strut = new JPanel();
		strut.setPreferredSize(new Dimension(150,20));
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		panel.add(strut,gbc);
	}
	
	public static void drawExps(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("检索表达式：");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		JTextArea textArea = new JTextArea();
		textArea.setName(UIIdentity.EXPS_TEXTAREA);
		//textArea.setRows(10);
		textArea.setLineWrap(true); // 激活自动换行功能
		textArea.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setPreferredSize(new Dimension(150, 80));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		panel.add(scroll,gbc);
	}
	
	public static void drawBottom(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		JPanel bottom = new JPanel();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		panel.add(bottom,gbc);
	}
	
	
	@Override
	public JPanel getJPanel() {
		return createJPanel();
	}

}
