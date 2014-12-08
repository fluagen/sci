package com.sci.app;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import junit.awtui.ProgressBar;

import com.sci.app.model.FetcherTableModel;
import com.sci.app.model.SearchModel;
import com.sci.app.progressbar.ProgressBarRenderer;

public class MainApp extends JFrame{

	private static final int WIDTH = 800;
	private static final int HIGHT = 600;
	
	
	public MainApp(){
		setSize(WIDTH, HIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static MainApp app;
	private static FetcherTableModel tableModel = new FetcherTableModel();
	
	private static void initView(MainApp mainApp){
		app = mainApp;
		Container contentPane = mainApp.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15, 10, 15, 10);//设置组件之间彼此的间距
		
		JPanel topPanel = new JPanel();
		JButton btn = new JButton("新增抓取任务");
		
		GridBagConstraints topPanelGbc = new GridBagConstraints();
		topPanelGbc.insets = new Insets(15, 10, 15, 10);
		topPanelGbc.gridwidth = 1;
		topPanelGbc.fill = GridBagConstraints.BOTH;
		topPanel.add(btn,topPanelGbc);
		JPanel strut1 = new JPanel();
		gbc.gridwidth = 0;
		topPanel.add(strut1,topPanelGbc);
		
		gbc.gridwidth = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		contentPane.add(topPanel,gbc);
		
		JTable table = new JTable(tableModel);
		TableColumn progressBar = table.getColumn("执行状态");
		progressBar.setCellRenderer(new ProgressBarRenderer());
		JScrollPane scrollPane = new JScrollPane(table);
		gbc.gridwidth = 0;
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TaskConfigurationDialog dialog = new TaskConfigurationDialog();
				SearchModel model = dialog.showDialog(app, true);
				tableModel.addRow(model);
				TaskExecutor.execute(tableModel, model);
			}
		});
		
		contentPane.add(scrollPane,gbc);
		
		mainApp.setVisible(true);
	}
	
	public static void main(String[] args){
		MainApp mainApp = new MainApp();
		initView(mainApp);
	}
}
