package com.sci.app;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sun.font.CreatedFontTracker;

import com.sci.app.toolkit.DBType;

public class Demo {

	
	public static JPanel createTopPanel(){
		JPanel topPanel = new JPanel();
		
		JLabel label = new JLabel("数据库：");
		JComboBox box = new JComboBox(DBType.getDBTypes());
		
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.add(label);
		topPanel.add(box);
		
		return topPanel;
	}
	
	public static JPanel createMidllePanel(){
		JPanel middlePanel = new JPanel();
		
		JLabel label = new JLabel("检索式：");
		JTextArea textArea = new JTextArea(10,10);
		
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
		middlePanel.add(label);
		middlePanel.add(textArea);
		
		return middlePanel;
	}
	
	public static JPanel createBottomPanel(){
		JPanel bottomPanel = new JPanel();
		
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.add(Box.createHorizontalStrut(20));
		
		return bottomPanel;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		Container pane = frame.getContentPane();
		
		pane.setLayout(new GridBagLayout());
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
		
		JLabel label = new JLabel("数据库：");
		JComboBox box = new JComboBox(DBType.getDBTypes());
		
		c1.gridx = 0;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.weightx = 0;
		c1.weighty = 0;
		pane.add(label,c1);
		
		c1.gridx = 1;
		c1.gridwidth = 1;
		c1.weightx = 0;
		c1.weighty = 0;
		pane.add(box,c1);
		
		JPanel panel2 = new JPanel();
		c1.gridx = 2;
		c1.gridwidth = 0;
		c1.weightx = 1;
		c1.weighty = 0;
		pane.add(panel2,c1);
		
		JPanel panel = new JPanel();
		c1.gridx = 0;
		c1.gridy = 1;
		c1.gridwidth = 0;
//		c1.gridheight = 0;
		c1.weightx = 1;
		c1.weighty = 1;
		
		pane.add(panel,c1);
		
		
		frame.setVisible(true);
		
		
	}
}
