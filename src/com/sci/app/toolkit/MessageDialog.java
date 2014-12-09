package com.sci.app.toolkit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MessageDialog{

	public static void showMessage(String message){
		
		JLabel label = new JLabel(message);
        JButton btn = new JButton("确定");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });
        
        JPanel buttons = new JPanel();
        buttons.add(btn);
        
		JPanel content = new JPanel(new BorderLayout());
        content.add(label, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);
		
		JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setTitle("");
        dialog.getContentPane().add(content);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
	}
	
	public static void main(String[] args){
		showMessage("aaaaa");
	}
}
