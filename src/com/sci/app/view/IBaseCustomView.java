package com.sci.app.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface IBaseCustomView {

	public JPanel getJPanle();
	public JComboBox getDBComponent();
	public JTextField getIntervalComponent();
	public JTextField getStartTimeComponent();
	public JLabel getStartTimeTipComponent();
}
