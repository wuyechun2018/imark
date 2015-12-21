package com.imark.common.vo;

public class EasyPager {
	
	/**
	 * 当前页
	 */
	private Integer page=1;
	
	/**
	 * 每页条数
	 */
	private Integer rows=10;
	
	/**
	 * 开始记录
	 */
	private Integer start;
	
	/**
	 * 结束记录
	 */
	private Integer end;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		if(page<1){
			page=1;
		}
		return (page-1)*rows+1;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		if(page<1){
			page=1;
		}
		return page*rows;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
	
	
	
	

}
