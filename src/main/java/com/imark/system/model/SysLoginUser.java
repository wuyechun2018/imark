package com.imark.system.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the SYS_LOGIN_USER database table.
 * 
 */
@Entity
@Table(name="SYS_LOGIN_USER")
public class SysLoginUser implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="USER_ID",length=32,nullable=false,unique=true)
    @GenericGenerator(name="generator",strategy="uuid.hex")
    @GeneratedValue(generator="generator")
	private String userId;

	//登录账号
	@Column(name="LOGIN_ACCOUNT")
	private String loginAccount;

	@Column(name="LOGIN_PWD")
	private String loginPwd;

	private String memo;

	@Column(name="ORDER_BY")
	private BigDecimal orderBy;

	 // 性别 0 女 1男 2 不确定
	private String sex;

	@Column(name="USER_ALIAS")
	private String userAlias;

	// 用户编码
	@Column(name="USER_CODE")
	private String userCode;

	// 用户邮件
	@Column(name="USER_EMAIL")
	private String userEmail;

	@Column(name="USER_NAME")
	private String userName;

	// 用户状态 R:注册 U:在用 L:锁定 D:删除
	@Column(name="USER_STATE")
	private String userState;

	//用户主题
	@Column(name="USER_THEME")
	private String userTheme;

	// 用户类型
	@Column(name="USER_TYPE")
	private String userType;

    //手机号
	@Column(name="MOBILE_PHONE")
	private String mobilePhone;


    public SysLoginUser() {
    }

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginAccount() {
		return this.loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public BigDecimal getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(BigDecimal orderBy) {
		this.orderBy = orderBy;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserAlias() {
		return this.userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserTheme() {
		return this.userTheme;
	}

	public void setUserTheme(String userTheme) {
		this.userTheme = userTheme;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}