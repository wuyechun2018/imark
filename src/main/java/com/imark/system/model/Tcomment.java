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
@Table(name = "T_COMMENT")
public class Tcomment {
	
	private String id;
	private String articleId;
	private String commentUserId;
	private String commentUserName;
	private String commentType;
	private String commentIp;
	private int zanCount;
	private String commentContent;
	private Date commentDate;
	private String status;
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name = "ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "ARTICLE_ID")
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	@Column(name = "COMMENT_USER_ID")
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	
	@Column(name = "COMMENT_USER_NAME")
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	
	@Column(name = "COMMENT_TYPE")
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	
	@Column(name = "ZAN_COUNT")
	public int getZanCount() {
		return zanCount;
	}
	public void setZanCount(int zanCount) {
		this.zanCount = zanCount;
	}
	
	@Column(name = "COMMENT_CONTENT")
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "COMMENT_DATE")
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "COMMENT_IP")
	public String getCommentIp() {
		return commentIp;
	}
	public void setCommentIp(String commentIp) {
		this.commentIp = commentIp;
	}
	

}
