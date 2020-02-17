package com.thd.bi.dto.example;

import java.util.List;

public class ModelBean {
	private int flag;
	private String formName;
	List<SubList> subListArray ;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public List<SubList> getSubListArray() {
		return subListArray;
	}
	public void setSubListArray(List<SubList> subListArray) {
		this.subListArray = subListArray;
	}
	
	
}
