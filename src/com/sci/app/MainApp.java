package com.sci.app;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.sci.app.fetch.Fetcher;
import com.sci.app.model.FetcherModel;
import com.sci.app.model.FetcherTableModel;
import com.sci.app.toolkit.MessageDialog;
import com.sci.app.toolkit.SavedrescMerger;

public class MainApp extends JFrame{

	
	public MainApp(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width/2;
		int height = screenSize.height/2;
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("抓取任务列表");
	}
	
	private static MainApp app;
	private static FetcherTableModel tableModel = new FetcherTableModel();
	private static JScrollPane scrollPane;
	private static JTable table;
	
	private static void initView(MainApp mainApp){
		app = mainApp;
		Container contentPane = mainApp.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 0, 10);//设置组件之间彼此的间距
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		
		table = new FetcherTable(tableModel);
		scrollPane = new JScrollPane(table);
		
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		contentPane.add(scrollPane,gbc);
		
		final JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		JButton fetchBtn = new JButton("新增抓取任务");
		JButton exportBtn = new JButton("导出");
		JButton mergeBtn = new JButton("合并后导出");
		addItem(buttons, fetchBtn, 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST);
		addItem(buttons, exportBtn, 1, 0, 1, 1, 0, 0, GridBagConstraints.WEST);
		addItem(buttons, mergeBtn, 2, 0, 1, 1, 0, 0, GridBagConstraints.WEST);
		addItem(buttons, new JPanel(), 3, 0, 0, 0, 100, 100, GridBagConstraints.WEST);
		
		
		gbc.gridwidth = 0;
		gbc.weighty = 1;
		contentPane.add(buttons,gbc);
		
		fetchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FetcherTaskDialog dialog = new FetcherTaskDialog();
				FetcherModel model = dialog.showDialog(app, true);
				if(model == null || !model.isValid()){
					return;
				}
				tableModel.addRow(model);
				TaskExecutor.execute(tableModel, model);
			}
		});
		exportBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if(rowIndex != 1){
					MessageDialog.showMessage("请选取一条记录导出！");
					return;
				}
				String code = (String) table.getValueAt(rowIndex, tableModel.getStatusCodeColumnIndex());
				if(code == null || !code.equals(FetcherTableModel.STATUSCODE_OK)){
					MessageDialog.showMessage("该记录不可导出！");
					return;
				}
				String sid = (String) table.getValueAt(rowIndex, tableModel.getSidColumnIndex());
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(buttons);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						File savedrecs = new File(Fetcher.getRootDic()+File.separator+sid+File.separator+Fetcher.getSavedresc());
						if(!savedrecs.exists()){
							MessageDialog.showMessage("savedrecs文件不存在，导出失败！");
						}
						FileInputStream fi = new FileInputStream(savedrecs);
						FileOutputStream fo = new FileOutputStream(file);
						FileChannel in = fi.getChannel();
						FileChannel out = fo.getChannel();
						in.transferTo(0, in.size(), out);
						
						fi.close();
						in.close();
						fo.close();
						out.close();
						
						MessageDialog.showMessage("导出完成！");
					} catch (Exception e1) {
//						e1.printStackTrace();
						MessageDialog.showMessage(e1.getMessage());
					}
				}
			}
		});
		
		mergeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 int[] rows = table.getSelectedRows();
				 if(rows.length < 2){
					MessageDialog.showMessage("请选择2条以上已完成的记录进行合并导出！");
					return;
				 }
				 JFileChooser fc = new JFileChooser();
				 int returnVal = fc.showSaveDialog(buttons);
				 if (returnVal == JFileChooser.APPROVE_OPTION) {
						try {
							File file = fc.getSelectedFile();
							LinkedHashMap<String,StringBuilder> buf = new LinkedHashMap<String,StringBuilder>();
							for (int i = 0; i < rows.length; i++) {
								String code = (String) table.getValueAt(rows[i],tableModel.getStatusCodeColumnIndex());
								if (code == null || !code.equals(FetcherTableModel.STATUSCODE_OK)) {
									MessageDialog.showMessage("存在未完成的任务，合并导出不可用！");
									return;
								}
	
								String sid = (String) table.getValueAt(rows[i],tableModel.getSidColumnIndex());
								File savedrecs = new File(Fetcher.getRootDic()
										+ File.separator + sid + File.separator
										+ Fetcher.getSavedresc());
								buf.putAll(SavedrescMerger.parseToMap(savedrecs));
							}
							FileOutputStream out = new FileOutputStream(file);
							for(StringBuilder str : buf.values()){
								out.write(str.toString().getBytes("UTF-8"));
								out.flush();
							}
							out.close();
							MessageDialog.showMessage("合并导出完成！");
						} catch (Exception e1) {
							MessageDialog.showMessage(e1.getMessage());
						}
				}
			}
		});
		mainApp.setVisible(true);
	}
	private static void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int weightx, int weighty, int align) {
	    GridBagConstraints gc = new GridBagConstraints();
	    gc.gridx = x;
	    gc.gridy = y;
	    gc.gridwidth = width;
	    gc.gridheight = height;
	    gc.weightx = weightx;
	    gc.weighty = weighty;
	    gc.insets = new Insets(5, 5, 5, 5);
	    gc.anchor = align;
	    gc.fill = GridBagConstraints.NONE;
	    p.add(c, gc);
	  }
	
	public static void initFont(){
		Font font = new Font("Dialog",Font.PLAIN,12);
		UIManager.put("ToolTip.font",font);
		UIManager.put("Table.font",font);
		UIManager.put("TableHeader.font",font); 
		UIManager.put("TextField.font",font); 
		UIManager.put("ComboBox.font",font); 
		UIManager.put("TextField.font",font); 
		UIManager.put("PasswordField.font",font); 
		UIManager.put("TextArea.font",font); 
		UIManager.put("TextPane.font",font); 
		UIManager.put("EditorPane.font",font); 
		UIManager.put("FormattedTextField.font",font); 
		UIManager.put("Button.font",font); 
		UIManager.put("CheckBox.font",font); 
		UIManager.put("RadioButton.font",font); 
		UIManager.put("ToggleButton.font",font); 
		UIManager.put("ProgressBar.font",font); 
		UIManager.put("DesktopIcon.font",font); 
		UIManager.put("TitledBorder.font",font); 
		UIManager.put("Label.font",font); 
		UIManager.put("List.font",font); 
		UIManager.put("TabbedPane.font",font); 
		UIManager.put("MenuBar.font",font); 
		UIManager.put("Menu.font",font); 
		UIManager.put("MenuItem.font",font); 
		UIManager.put("PopupMenu.font",font); 
		UIManager.put("CheckBoxMenuItem.font",font); 
		UIManager.put("RadioButtonMenuItem.font",font); 
		UIManager.put("Spinner.font",font); 
		UIManager.put("Tree.font",font); 
		UIManager.put("ToolBar.font",font); 
		UIManager.put("OptionPane.messageFont",font); 
		UIManager.put("OptionPane.buttonFont",font); 
	}
	public static void main(String[] args){
		MainApp mainApp = new MainApp();
//		initFont();
		initView(mainApp);
//		mainApp.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				new Runnable() {
//					@Override
//					public void run() {
//						File fetcherDic = new File(Fetcher.getRootDic());
//						File[] files = fetcherDic.listFiles();
//						for(File f : files){
//							System.out.println(f.getPath());
//						}
//					}
//				}.run();
//				
//			}
//		});
	}
}
