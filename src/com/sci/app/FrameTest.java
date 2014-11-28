package com.sci.app;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sci.app.clojure.*;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;

public class FrameTest {

	private static IFn requireFN = RT.var("clojure.core", "require").fn();

	static {
		requireFN.invoke(Symbol.intern("com.sci.app.clojure.core"));
	}
	private static IFn check_sid = RT.var("com.sci.app.clojure.core",
			"check-sid").fn();
	private static IFn set_search_exps = RT.var("com.sci.app.clojure.core",
			"set-search-exps").fn();
	private static IFn pull_file = RT.var("com.sci.app.clojure.core",
			"pull-file").fn();

	public static void main(String args[]) {
		JFrame frame = new JFrame("test");
		JComponent comp = new JTextArea();
		frame.getContentPane().add(comp, BorderLayout.CENTER);
		frame.setSize(288, 188);
		frame.setVisible(true);
		
		JPanel contentPanel = new JPanel();
		frame.setContentPane(contentPanel);
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		contentPanel.add(b1);
		contentPanel.add(b2);
		
		
		

//		System.out.println(check_sid.invoke());
//
//		System.out
//				.println(set_search_exps
//						.invoke("SO=(BULLETIN OF MARINE SCIENCE OR CAHIERS DE BIOLOGIE MARINE OR CAHIERS DE BIOLOGIE MARINE OR CONTRIBUTIONS IN MARINE SCIENCE OR ESTUARINE \"AND\" COASTAL MARINE SCIENCE OR GEO MARINE LETTERS OR HELGOLAND MARINE RESEARCH OR ICES JOURNAL OF MARINE SCIENCE OR INDIAN JOURNAL OF GEO MARINE SCIENCES OR INDIAN JOURNAL OF MARINE SCIENCES OR INTERNATIONAL JOURNAL OF MARINE \"AND\" COASTAL LAW OR JOURNAL OF EXPERIMENTAL MARINE BIOLOGY \"AND\" ECOLOGY OR JOURNAL OF MARINE BIOTECHNOLOGY OR JOURNAL OF MARINE ENGINEERING \"AND\" TECHNOLOGY OR JOURNAL OF MARINE RESEARCH OR JOURNAL OF MARINE SCIENCE \"AND\" TECHNOLOGY OR JOURNAL OF MARINE SCIENCE \"AND\" TECHNOLOGY TAIWAN OR JOURNAL OF MARINE SYSTEMS OR JOURNAL OF THE MARINE BIOLOGICAL ASSOCIATION OF THE UNITED KINGDOM)"));
//
//		System.out
//				.println(pull_file
//						.invoke("SO=(BULLETIN OF MARINE SCIENCE OR CAHIERS DE BIOLOGIE MARINE OR CAHIERS DE BIOLOGIE MARINE OR CONTRIBUTIONS IN MARINE SCIENCE OR ESTUARINE \"AND\" COASTAL MARINE SCIENCE OR GEO MARINE LETTERS OR HELGOLAND MARINE RESEARCH OR ICES JOURNAL OF MARINE SCIENCE OR INDIAN JOURNAL OF GEO MARINE SCIENCES OR INDIAN JOURNAL OF MARINE SCIENCES OR INTERNATIONAL JOURNAL OF MARINE \"AND\" COASTAL LAW OR JOURNAL OF EXPERIMENTAL MARINE BIOLOGY \"AND\" ECOLOGY OR JOURNAL OF MARINE BIOTECHNOLOGY OR JOURNAL OF MARINE ENGINEERING \"AND\" TECHNOLOGY OR JOURNAL OF MARINE RESEARCH OR JOURNAL OF MARINE SCIENCE \"AND\" TECHNOLOGY OR JOURNAL OF MARINE SCIENCE \"AND\" TECHNOLOGY TAIWAN OR JOURNAL OF MARINE SYSTEMS OR JOURNAL OF THE MARINE BIOLOGICAL ASSOCIATION OF THE UNITED KINGDOM)",
//								1, 10));

	}
}