package com.sci.app.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TeachYou {
	public static void main(String[] args) {
		// 这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
		double percent = 100 / 150;
		// 输出一下，确认你的小数无误
		System.out.println("小数：" + percent);
		// 获取格式化对象
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(2);
		// 最后格式化并输出
		System.out.println("百分数：" + nt.format(percent));
		
		BigDecimal bd = new BigDecimal(100.00D/178.00D);
		bd = bd.setScale(4, RoundingMode.HALF_UP);
		System.out.println(bd.toString());
		
		Integer d = new Integer(100);
		Integer d2 = new Integer(170);
		System.out.println(d.doubleValue()/d2.doubleValue());
		
		Integer percent2 = new Integer(0);
		Integer mol = new Integer(80);
		Integer den = new Integer(170);
		BigDecimal bd2 = new BigDecimal(mol.doubleValue()/den.doubleValue());
		bd2 = bd2.setScale(2, RoundingMode.HALF_UP);
		percent2 = Double.valueOf(bd2.doubleValue()*100).intValue();
		System.out.println(percent2);
		
	}
}
