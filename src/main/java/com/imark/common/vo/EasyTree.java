package com.imark.common.vo;

import java.util.Map;

public class EasyTree {
	
	private String id;
	private String text;
	//节点状态，有两个值  'open' or 'closed', 默认为'open'. 当为‘closed’,说明此节点下有子节点否则此节点为叶子节点
	private String state;
	private String checked;
	//节点中其他属性的集合
	private Map attributes;
	//子节点集合
	private String children;
	//图标
	private String iconCls;

	
	public EasyTree(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public EasyTree() {
		// TODO Auto-generated constructor stub
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public Map getAttributes() {
		return attributes;
	}

	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	

}
