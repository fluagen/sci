package com.sci.app.demo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberPlainDocment extends PlainDocument {

	private static final long serialVersionUID = 5155604094685219161L;
	private static final String ALLOWED = "0123456789";

	public NumberPlainDocment() {
		super();
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if(str == null || str.trim().equals("")){
			return;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(ALLOWED.indexOf(c) == -1){
				return;
			}
		}
		
		super.insertString(offs, str, a);
	}

}
