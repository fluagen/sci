package com.sci.app.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class DBComboBoxModel extends AbstractListModel implements ComboBoxModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SCI = "sci";
	public static final String BIOSIS_PREVIEWS = "BIOSISPreviews";
	public static final String DERWENT_INNOVATIONS_INDEX = "DerwentInnovations";
	public static final String INSPEC = "Inspec";
	public static final String KCI = "kci";
	public static final String MEDLINE = "medline";
	public static final String SCIELO_CITATION_INDEX = "SciELOCitationIndex";
	
	List<String> list = new ArrayList<String>();
	
	private String selectedItem;
	
	public static final LinkedHashMap<String,String> nameCodeMap = new LinkedHashMap<String,String>();
	
	public DBComboBoxModel(){
		
		nameCodeMap.put("Web of Science核心合集", SCI);
		nameCodeMap.put("BIOSIS Previews", BIOSIS_PREVIEWS);
		nameCodeMap.put("Derwent Innovations Index", DERWENT_INNOVATIONS_INDEX);
		nameCodeMap.put("Inspec", INSPEC);
		nameCodeMap.put("KCI-朝鲜语期刊数据库", KCI);
		nameCodeMap.put("MEDLINE", MEDLINE);
		nameCodeMap.put("SciELO Citation Index", SCIELO_CITATION_INDEX);
		
		list.addAll(nameCodeMap.keySet());
		
		selectedItem = list.get(0);
	}
	
	@Override
	public int getSize() {
		return nameCodeMap.size();
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
