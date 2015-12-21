package com.imark.common.vo;

import java.util.ArrayList;
import java.util.List;


/***
 * 
 * 
 * Easy-Grid  数据实体类
 * 
 * ycwu3
 * 2015-10-19 上午10:20:05
 * 
 * @version 1.0.0
 *
 */
public class EasyGrid {
	
	//总数
	private Long total = 0L;
	//数据
	private List rows = new ArrayList();
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}
