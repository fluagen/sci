package com.sci.app.demo;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int limit;
  JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }

  JTextFieldLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}

public class JTextFieldLimitDemo extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

JTextField textfield1;

  JLabel label1;

  public void init() {
    setLayout(new FlowLayout());
    label1 = new JLabel("max 10 chars");
    textfield1 = new JTextField(15);
    add(label1);
    add(textfield1);
    textfield1.setDocument(new JTextFieldLimit(10));

    setSize(300,300);
    setVisible(true);
  }
  
  public static void main(String[] args){
	  JTextFieldLimitDemo demo = new JTextFieldLimitDemo();
	  demo.init();
  }
}
