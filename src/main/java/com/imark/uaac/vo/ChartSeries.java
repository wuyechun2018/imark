package com.imark.uaac.vo;

/**
 * 图表数据封装
 * 
 * @author lwzhang
 * 
 */
/**
 * @author Administrator
 *
 */
public class ChartSeries {
	// 名称
	private Object name;
	// 类型
	private Object type;
	// 数据
	private String data;

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
