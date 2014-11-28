package com.sci.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.sci.app.toolkit.DocType;
import com.sci.app.toolkit.Language;
import com.sci.app.toolkit.Timespan;

public class PullSCIApp {

	public void initView() {
		JFrame frame = new JFrame("SCI 资源抓取应用");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("SCI 资源抓取应用"));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(12, 12, 12, 12);

		JLabel labExps = new JLabel("检索表达式：");
		JTextArea textExps = new JTextArea("", 10, 15);
		textExps.setSelectedTextColor(Color.RED);
		textExps.setLineWrap(true); // 激活自动换行功能
		textExps.setWrapStyleWord(true);

		JLabel labInterval = new JLabel("时间间隔：");
		JTextField textInterval = new JTextField(new NumberPlainDocment(), "",
				5);
		JLabel labInterval2 = new JLabel("秒");
		
		JList lLanguage = new JList(Language.getLanguages());
		lLanguage.setBorder(BorderFactory.createTitledBorder("语种"));
		lLanguage.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JList lDocType = new JList(DocType.getDocTypes());
		lDocType.setBorder(BorderFactory.createTitledBorder("文献类型"));
		lDocType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel timespan = new JLabel("时间跨度：");
		JComboBox comboTimespan = new JComboBox(Timespan.getTimespan());
		comboTimespan.setSelectedItem(2012);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(labExps, gbc);
		gbc.gridx = 1;
		panel.add(new JScrollPane(textExps), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(labInterval);
		gbc.gridx = 1;
		panel.add(textInterval);
		gbc.gridx = 3;
		panel.add(labInterval2);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(new JScrollPane(lLanguage));
		
		panel.add(new JScrollPane(lDocType));
		
		panel.add(comboTimespan);

		contentPane.add(panel);

		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new PullSCIApp().initView();
	}
}
