package com.imark.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ATTACH")
public class Attach {
	
	//主键
	private String id;
	//附件名称
	private String attachName;
	//附件类型
	private String bizType;
	//业务Id
	private String bizId;
	//文件路径
	private String filePath;
	//文件内容
	private byte[] fileContent;
	//创建人
	private String createUserId;
	//创建时间
	private Date createDate;
	//更新人
	private String updateUserId;
	//更新时间
	private Date updateDate;
	
	public Attach() {

	}

	public Attach(String id, String attachName, String bizType, String bizId,
			String filePath, String createUserId, Date createDate,
			String updateUserId, Date updateDate) {
		super();
		this.id = id;
		this.attachName = attachName;
		this.bizType = bizType;
		this.bizId = bizId;
		this.filePath = filePath;
		this.createUserId = createUserId;
		this.createDate = createDate;
		this.updateUserId = updateUserId;
		this.updateDate = updateDate;
	}


	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@GenericGenerator(name="generator",strategy="uuid.hex")
    @GeneratedValue(generator="generator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "ATTACH_NAME", length = 200)
	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	@Column(name = "BIZ_TYPE", length = 20)
	public String getBizType() {
		return bizType;
	}


	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	@Column(name = "BIZ_ID", length = 32)
	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@Column(name = "FILE_PATH", length = 100)
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	@Column(name = "FILE_CONTENT")
	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Column(name = "CREATE_USER_ID", length = 32)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "UPDATE_USER_ID", length = 32)
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
