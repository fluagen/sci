package com.sci.app;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTable;

public class FetcherTableMouseAdapterListener extends MouseMotionAdapter
	implements MouseListener{
	
	JTable table;
	int oldY = 0;
    int newY = 0;
    int row = 0;
    int oldHeight = 0;
    boolean drag = false;
    int increase = 0;
	
	public FetcherTableMouseAdapterListener(JTable table){
		this.table = table;
	}
	
	public void mouseMoved(MouseEvent e) {
        int onRow = table.rowAtPoint(e.getPoint());

        int height = 0;
        for (int i = 0; i <= onRow; i++) {
            height = height + table.getRowHeight(i);
        }

        if (height - e.getY() < 10) {
            drag = true;
            table.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        } else {
            drag = false;
            table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

    }

    public void mouseDragged(MouseEvent e) {
        if (drag) {
            int value = oldHeight + e.getY() - oldY;
            if (value < 30)
                table.setRowHeight(row, 30);
            else                     
                table.setRowHeight(row, oldHeight + e.getY() - oldY);
            
            table.setRowSelectionInterval(row, row);                
        }
    }

    public void mousePressed(MouseEvent e) {
        oldY = e.getY();
        row = table.rowAtPoint(e.getPoint());
        oldHeight = table.getRowHeight(row);
        table.setRowSelectionInterval(row, row);
    }

    public void mouseReleased(MouseEvent e) {
        newY = e.getY();
        table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
