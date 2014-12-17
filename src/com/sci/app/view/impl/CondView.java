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
import com.sci.app.view.ICondView;

public class CondView implements ICondView{

	private JPanel panel = null;
	
	private JComboBox fromTimespanComponent = null;
	private JComboBox toTimespanComponent = null;
	private JList languageComponent = null;
	private JList doctypeComponent = null;
	private JTextArea expsComponent = null;
	
	private static CondView view = null;
	
	private CondView(){
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(400,500));
		panel.setBorder(BorderFactory.createTitledBorder("检索条件"));
		panel.setLayout(new GridBagLayout());
		
		drawTimespan(panel);
		drawLanguage(panel);
		drawDoctype(panel);
		drawExps(panel);
		drawBottom(panel);
	}
	
	public static CondView getInstance(){
		if(view == null){
			view = new CondView();
		}
		return view;
	}
	
	public void drawTimespan(JPanel panel){
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
		fromTimespanComponent = new JComboBox(Timespan.getTimespan());
		panel.add(fromTimespanComponent,gbc);
		JLabel to = new JLabel("到");
//		to.setPreferredSize(new Dimension(30,10));
		panel.add(to,gbc);
		toTimespanComponent = new JComboBox(Timespan.getTimespan());
		toTimespanComponent.setSelectedIndex(toTimespanComponent.getItemCount()-1);
		panel.add(toTimespanComponent,gbc);
		
		JPanel strut = new JPanel();
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		panel.add(strut,gbc);
		
	}
	
	public void drawLanguage(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		JLabel label = new JLabel("语种：");
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		languageComponent = new JList(Language.getLanguages());
		//list.setPreferredSize(new Dimension(200,80));
		languageComponent.setSelectedIndex(0);
		languageComponent.setVisibleRowCount(5);
		languageComponent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(languageComponent);
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
	
	public void drawDoctype(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("文献类型：");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		doctypeComponent = new JList(DocType.getDocTypes());
		//list.setPreferredSize(new Dimension(200,80));
		doctypeComponent.setSelectedIndex(0);
		doctypeComponent.setVisibleRowCount(5);
		doctypeComponent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(doctypeComponent);
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
	
	public void drawExps(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel label = new JLabel("检索表达式：");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		panel.add(label,gbc);
		
		expsComponent = new JTextArea();
		//textArea.setRows(10);
		expsComponent.setLineWrap(true); // 激活自动换行功能
		expsComponent.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(expsComponent);
		scroll.setPreferredSize(new Dimension(150, 80));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		panel.add(scroll,gbc);
	}
	
	public void drawBottom(JPanel panel){
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
		return panel;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JComboBox getFromTimespanComponent() {
		return fromTimespanComponent;
	}

	public JComboBox getToTimespanComponent() {
		return toTimespanComponent;
	}

	public JList getLanguageComponent() {
		return languageComponent;
	}

	public JList getDoctypeComponent() {
		return doctypeComponent;
	}

	@Override
	public JTextArea getExpsComponent() {
		return expsComponent;
	}
	

}
