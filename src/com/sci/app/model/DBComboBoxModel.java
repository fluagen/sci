package com.sci.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class DBComboBoxModel extends AbstractListModel implements ComboBoxModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SCI = "Web of Science核心合集";
	public static final String BIOSIS_PREVIEWS = "BIOSIS Previews";
	public static final String DERWENT_INNOVATIONS_INDEX = "Derwent Innovations Index";
	public static final String INSPEC = "Inspec";
	public static final String KCI = "KCI-朝鲜语期刊数据库";
	public static final String MEDLINE = "MEDLINE";
	public static final String SCIELO_CITATION_INDEX = "SciELO Citation Index";
	
	List<String> list = new ArrayList<String>();
	
	private String selectedItem;
	
	private static DBComboBoxModel model = null;
	
	
	private DBComboBoxModel(){
		
		list.add(SCI);
		list.add(BIOSIS_PREVIEWS);
		list.add(DERWENT_INNOVATIONS_INDEX);
		list.add(INSPEC);
		list.add(KCI);
		list.add(MEDLINE);
		list.add(SCIELO_CITATION_INDEX);
		
		selectedItem = SCI;
	}
	
	public static DBComboBoxModel getInstance(){
		if(model == null){
			model = new DBComboBoxModel();
		}
		return model;
	}
	
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public String getElementAt(int index) {
		return list.get(index);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if(anItem == null){
			return;
		}
		selectedItem = (String) anItem;
	}

	@Override
	public String getSelectedItem() {
		return selectedItem;
	}

}
