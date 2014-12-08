package com.sci.app.progressbar;

import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 工具条的渲染器
 */
public class ProgressBarRenderer extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
    private final JProgressBar b;
    public ProgressBarRenderer(){
    	super();
        setOpaque(true);
        b = new JProgressBar();
		//是否显示进度字符串
		b.setStringPainted(true);
		b.setMinimum(0);
		b.setMaximum(100);
		//是否绘制边框
		b.setBorderPainted(true);
        b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    }
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Integer i = (Integer) value;
        b.setValue(i);
        return b;
    }
	
	public static Integer getProgrees(Integer num,Integer total){
		BigDecimal bd = new BigDecimal(num.doubleValue()/total.doubleValue());
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return Double.valueOf(bd.doubleValue()*100).intValue();
	}
}