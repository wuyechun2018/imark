package com.imark.common.vo;

public class EasyCombobox {
	
	private String id;
	
	private String text;
	

	public EasyCombobox(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public EasyCombobox() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
