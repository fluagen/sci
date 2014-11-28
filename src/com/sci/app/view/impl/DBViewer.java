package com.sci.app.view.impl;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

import com.sci.app.toolkit.DocType;
import com.sci.app.toolkit.Language;
import com.sci.app.toolkit.Timespan;
import com.sci.app.view.IDBViewer;

public class DBViewer implements IDBViewer{

	public static final int STRUT = 20;

	@Override
	public void drawExps(Box horizontalBox) {
		
		JLabel label = new JLabel("检索表达式：");
		JTextArea textArea = new JTextArea("",8,12);
		
		horizontalBox.add(label);
		horizontalBox.add(Box.createHorizontalStrut(STRUT));
		horizontalBox.add(textArea);
	}

	@Override
	public void drawLanguage(Box horizontalBox) {
		JLabel label = new JLabel("语种：");
		JList list = new JList(Language.getLanguages());
		
		horizontalBox.add(label);
		horizontalBox.add(Box.createHorizontalStrut(STRUT));
		horizontalBox.add(list);
	}

	@Override
	public void drawTimespan(Box horizontalBox) {
		JLabel label = new JLabel("时间跨度：");
		JLabel from = new JLabel("从");
		JLabel to = new JLabel("到");
		JComboBox fComboBox = new JComboBox(Timespan.getTimespan());
		JComboBox tComboBox = new JComboBox(Timespan.getTimespan());
		
		horizontalBox.add(label);
		horizontalBox.add(Box.createHorizontalStrut(STRUT));
		horizontalBox.add(from);
		horizontalBox.add(fComboBox);
		horizontalBox.add(to);
		horizontalBox.add(tComboBox);
		
	}

	@Override
	public void drawDoctype(Box horizontalBox) {
		JLabel label = new JLabel("文献类型：");
		JList list = new JList(DocType.getDocTypes());
		
		horizontalBox.add(label);
		horizontalBox.add(Box.createHorizontalStrut(STRUT));
		horizontalBox.add(list);
		
	}

}
