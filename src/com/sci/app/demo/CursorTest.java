package com.sci.app.demo;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class CursorTest extends JFrame {

	private static final long	serialVersionUID	= 1L;
	private JPanel				jContentPane		= null;
	private JPanel				jPanel				= null;
	private JPanel				jPanel1				= null;
	private JPanel				jPanel2				= null;
	private JPanel				jPanel3				= null;
	private JPanel				jPanel4				= null;
	private JPanel				jPanel5				= null;
	private JPanel				jPanel6				= null;
	private JPanel				jPanel7				= null;
	private JPanel				jPanel8				= null;
	private JPanel				jPanel9				= null;
	private JPanel				jPanel10			= null;
	private JPanel				jPanel11			= null;
	private JPanel				jPanel12			= null;
	private JPanel				jPanel13			= null;

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel
					.setBorder(BorderFactory
							.createTitledBorder(null, "HAND_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1
					.setBorder(BorderFactory
							.createTitledBorder(null, "CROSSHAIR_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel1.setCursor(Cursor
					.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2
					.setBorder(BorderFactory
							.createTitledBorder(null, "MOVE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3
					.setBorder(BorderFactory
							.createTitledBorder(null, "N_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel3.setCursor(Cursor
					.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		}
		return jPanel3;
	}

	/**
	 * This method initializes jPanel4
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4
					.setBorder(BorderFactory
							.createTitledBorder(null, "NE_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel4.setCursor(Cursor
					.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
		}
		return jPanel4;
	}

	/**
	 * This method initializes jPanel5
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GridBagLayout());
			jPanel5
					.setBorder(BorderFactory
							.createTitledBorder(null, "NW_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel5.setCursor(Cursor
					.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
		}
		return jPanel5;
	}

	/**
	 * This method initializes jPanel6
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(new GridBagLayout());
			jPanel6
					.setBorder(BorderFactory
							.createTitledBorder(null, "S_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel6.setCursor(Cursor
					.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
		}
		return jPanel6;
	}

	/**
	 * This method initializes jPanel7
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jPanel7 = new JPanel();
			jPanel7.setLayout(new GridBagLayout());
			jPanel7
					.setBorder(BorderFactory
							.createTitledBorder(null, "SE_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel7.setCursor(Cursor
					.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		}
		return jPanel7;
	}

	/**
	 * This method initializes jPanel8
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jPanel8 = new JPanel();
			jPanel8.setLayout(new GridBagLayout());
			jPanel8
					.setBorder(BorderFactory
							.createTitledBorder(null, "SW_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel8.setCursor(Cursor
					.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
		}
		return jPanel8;
	}

	/**
	 * This method initializes jPanel9
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jPanel9 = new JPanel();
			jPanel9.setLayout(new GridBagLayout());
			jPanel9
					.setBorder(BorderFactory
							.createTitledBorder(null, "TEXT_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel9.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		}
		return jPanel9;
	}

	/**
	 * This method initializes jPanel10
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel10() {
		if (jPanel10 == null) {
			jPanel10 = new JPanel();
			jPanel10.setLayout(new GridBagLayout());
			jPanel10
					.setBorder(BorderFactory
							.createTitledBorder(null, "W_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel10.setCursor(Cursor
					.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		}
		return jPanel10;
	}

	/**
	 * This method initializes jPanel11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jPanel11 = new JPanel();
			jPanel11.setLayout(new GridBagLayout());
			jPanel11
					.setBorder(BorderFactory
							.createTitledBorder(null, "WAIT_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel11.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		}
		return jPanel11;
	}

	/**
	 * This method initializes jPanel12
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel12() {
		if (jPanel12 == null) {
			jPanel12 = new JPanel();
			jPanel12.setLayout(new GridBagLayout());
			jPanel12
					.setBorder(BorderFactory
							.createTitledBorder(null, "DEFAULT_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel12.setCursor(Cursor
					.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
		return jPanel12;
	}

	/**
	 * This method initializes jPanel13
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JPanel();
			jPanel13.setLayout(new GridBagLayout());
			jPanel13
					.setBorder(BorderFactory
							.createTitledBorder(null, "E_RESIZE_CURSOR", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(
									"Dialog", Font.BOLD, 12), new Color(51, 51,
									51)));
			jPanel13.setCursor(Cursor
					.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
		}
		return jPanel13;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CursorTest thisClass = new CursorTest();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public CursorTest() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(647, 357);
		this.setContentPane(getJContentPane());
		this.setTitle("Cursors");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJPanel2(), null);
			jContentPane.add(getJPanel3(), null);
			jContentPane.add(getJPanel4(), null);
			jContentPane.add(getJPanel5(), null);
			jContentPane.add(getJPanel6(), null);
			jContentPane.add(getJPanel7(), null);
			jContentPane.add(getJPanel8(), null);
			jContentPane.add(getJPanel9(), null);
			jContentPane.add(getJPanel10(), null);
			jContentPane.add(getJPanel11(), null);
			jContentPane.add(getJPanel12(), null);
			jContentPane.add(getJPanel13(), null);
		}
		return jContentPane;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
