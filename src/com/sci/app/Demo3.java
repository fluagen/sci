package com.sci.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wenliang
 */
public class Demo3 extends JFrame implements ActionListener, Runnable {

    private JButton bt1, bt2, bt3;
    private JScrollPane jspane;
    private JTable table;
    private JPanel btnPanel, mainPanel;
    private DefaultTableModel model;
    int a = 0;
    int b = 1;

    public Demo3() {//构造方法
        initComponents();
        this.getContentPane().add("Center", mainPanel);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {//构造面板
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        model = new DefaultTableModel(new Object[][]{{"原始列", "原始列", "原始列"},
                    {"原始列", "原始列", "原始列"}, {"原始列", "原始列", "原始列"}},
                new String[]{"表头1", "表头2", "表头3"});
        table = new JTable(model);
        jspane = new JScrollPane(table);
        bt1 = new JButton("加到第一行前");
        bt2 = new JButton("追加到最后一行");
        bt3 = new JButton("追加到当前行前");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        btnPanel = new JPanel(new GridLayout(1, 3));
        btnPanel.add(bt1);
        btnPanel.add(bt2);
        btnPanel.add(bt3);
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add("Center", jspane);
        mainPanel.add("South", btnPanel);
    }

    public void actionPerformed(ActionEvent e) {
        Thread thread = new Thread(this);
        thread.start();

        Object object = e.getSource();
        if (object == bt1) { // 最加到第一行
            model.insertRow(0, new Object[]{"追加列_0", "追加列_0", "追加列_0"});
        } else if (object == bt2) {// 追加到最后行
        } else if (object == bt3) {// 追加到当前行前
            if (table.getSelectedRow() != -1) {
                model.insertRow(table.getSelectedRow(), new Object[]{
                            "追加列_0_0_0", "追加列_0_0_0", "追加列_0_0_0"});

            }

        }
    }

    /**
     * 测试MAIN方法已注释掉.....
     * @param args
     */
    public static void main(String args[]) {//main 方法
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	Demo3 jtable = new Demo3();

                jtable.setVisible(true);
            }
        });
    }

    public void run() {
        // TODO Auto-generated method stub

        while (true) {

            model.insertRow(model.getRowCount(), new Object[]{"追加列_0_0",
                        "追加列_0_0", "追加列_0_0"});
            // System.out.println(model.getRowCount());


            table.updateUI(); // 刷新

            System.out.println("刷新了一次" + a);
            a++;
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
    }
}