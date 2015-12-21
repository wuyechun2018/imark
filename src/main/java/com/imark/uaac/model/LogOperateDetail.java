package com.imark.uaac.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOG_OPERATE_DETAIL database table.
 * 
 */
@Entity
@Table(name="LOG_OPERATE_DETAIL")
public class LogOperateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_ID")
	private long numId;

    @Lob()
	@Column(name="OPERATE_CONDITION")
	private String operateCondition;

	@Column(name="OPERATE_ERROR_CODE")
	private String operateErrorCode;

	@Column(name="OPERATE_NAME")
	private String operateName;

	@Column(name="OPERATE_RESULT")
	private String operateResult;

	@Column(name="OPERATE_TABLE")
	private String operateTable;

	@Column(name="OPERATE_TIME")
	private String operateTime;

	@Column(name="OPERATE_TYPE")
	private String operateType;

	@Column(name="OPERATE_URL")
	private String operateUrl;

	@Column(name="ORGANIZATION_ID")
	private String organizationId;

	@Column(name="ORGANIZATION_NAME")
	private String organizationName;

	@Column(name="REG_ID")
	private String regId;

	private String sessionid;

	@Column(name="TERMINAL_ID")
	private String terminalId;

	@Column(name="USER_ID")
	private String userId;

	@Column(name="USER_NAME")
	private String userName;

    public LogOperateDetail() {
    }

	public long getNumId() {
		return this.numId;
	}

	public void setNumId(long numId) {
		this.numId = numId;
	}

	public String getOperateCondition() {
		return this.operateCondition;
	}

	public void setOperateCondition(String operateCondition) {
		this.operateCondition = operateCondition;
	}

	public String getOperateErrorCode() {
		return this.operateErrorCode;
	}

	public void setOperateErrorCode(String operateErrorCode) {
		this.operateErrorCode = operateErrorCode;
	}

	public String getOperateName() {
		return this.operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getOperateResult() {
		return this.operateResult;
	}

	public void setOperateResult(String operateResult) {
		this.operateResult = operateResult;
	}

	public String getOperateTable() {
		return this.operateTable;
	}

	public void setOperateTable(String operateTable) {
		this.operateTable = operateTable;
	}

	public String getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateType() {
		return this.operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateUrl() {
		return this.operateUrl;
	}

	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}

	public String getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}