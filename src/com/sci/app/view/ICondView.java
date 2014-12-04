package com.sci.app.view;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public interface ICondView {

	public JPanel getJPanel();
	
	public JComboBox getFromTimespanComponent();
	
	public JComboBox getToTimespanComponent();
	
	public JList getLanguageComponent();
	
	public JList getDoctypeComponent();
	
	public JTextArea getExpsComponent();
}
