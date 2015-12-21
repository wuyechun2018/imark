package com.imark.system.model;

public class SysMarkLogs {
	
	private String  id;
	
	/***
	 * 日志类型
	 */
	private String markType;
	
	/**
	 * 操作时间
	 */
	private String opDate;
	
	
	/**
	 * 业务ID（如上传操作时候的部门ID）
	 */
	private String bizId;
	
	/***
	 * 业务类型
	 */
	private String bizType;
	
	/****
	 * 业务参数（如上传操作时候的文件路径）
	 */
	private String bizParam;
	
    /***
     * 业务描述（如 上传操作时的文件文件名称）
     */
	private String bizDesc;
	
	/**
	 * 业务状态
	 */
	private String bizStatus="0";
	
	/**
	 * 逻辑状态,0,正常,1,删除
	 */
	private String logicStatus="0";
	
	
	/***
	 * 操作人
	 */
	private String opUser;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getMarkType() {
		return markType;
	}

	public void setMarkType(String markType) {
		this.markType = markType;
	}

	public String getOpDate() {
		return opDate;
	}

	public void setOpDate(String opDate) {
		this.opDate = opDate;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizParam() {
		return bizParam;
	}

	public void setBizParam(String bizParam) {
		this.bizParam = bizParam;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}

	public String getBizStatus() {
		return bizStatus;
	}

	public void setBizStatus(String bizStatus) {
		this.bizStatus = bizStatus;
	}

	public String getLogicStatus() {
		return logicStatus;
	}

	public void setLogicStatus(String logicStatus) {
		this.logicStatus = logicStatus;
	}

	public String getOpUser() {
		return opUser;
	}

	public void setOpUser(String opUser) {
		this.opUser = opUser;
	}
	
	
	
	

}
