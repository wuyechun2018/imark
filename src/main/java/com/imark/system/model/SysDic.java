package com.imark.system.model;
// Generated 2016-3-15 9:15:24 by Hibernate Tools 3.2.2.GA


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/*******************************************************************************
 *  功能说明: 系统字典
  
 *  2016-3-15 下午5:35:37 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2016-3-15 下午5:35:37 ycwu 修改文件
 * 
 ******************************************************************************/
@Entity
@Table(name="SYS_DIC")
public class SysDic {


     private String id;
     private String pid;
     private String dicCode;
     private String dicType;
     private String dicName;
     private String dicMemo;
     private String isUse;
     private String updateUser;
     private Date updateDate;
     private String disOrder;

    public SysDic() {
    }

	
    public SysDic(String id) {
        this.id = id;
    }
    public SysDic(String id, String pid, String dicCode, String dicType, String dicName, String dicMemo, String isUse, String updateUser, Date updateDate, String disOrder) {
       this.id = id;
       this.pid = pid;
       this.dicCode = dicCode;
       this.dicType = dicType;
       this.dicName = dicName;
       this.dicMemo = dicMemo;
       this.isUse = isUse;
       this.updateUser = updateUser;
       this.updateDate = updateDate;
       this.disOrder = disOrder;
    }
   
    @Id 
    @Column(name="ID", unique=true, nullable=false)
    //@GenericGenerator(name="generator",strategy="uuid.hex")
    //@GeneratedValue(generator="generator")
    @GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(name="PID")
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    
    @Column(name="DIC_CODE")
    public String getDicCode() {
        return this.dicCode;
    }
    
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }
    
    @Column(name="DIC_TYPE")
    public String getDicType() {
        return this.dicType;
    }
    
    public void setDicType(String dicType) {
        this.dicType = dicType;
    }
    
    @Column(name="DIC_NAME")
    public String getDicName() {
        return this.dicName;
    }
    
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
    
    @Column(name="DIC_MEMO")
    public String getDicMemo() {
        return this.dicMemo;
    }
    
    public void setDicMemo(String dicMemo) {
        this.dicMemo = dicMemo;
    }
    
    @Column(name="IS_USE", length=32)
    public String getIsUse() {
        return this.isUse;
    }
    
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
    
    @Column(name="UPDATE_USER", length=32)
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="UPDATE_DATE")
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    @Column(name="DIS_ORDER", length=10)
    public String getDisOrder() {
        return this.disOrder;
    }
    
    public void setDisOrder(String disOrder) {
        this.disOrder = disOrder;
    }




}


