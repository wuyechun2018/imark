package com.imark.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 行政许可实体类
 * @author lwzhang
 *
 */
@Entity
@Table(name="XYWH_XZXK")
public class Xzxk {
	
	/**
	 * 物理ID
	 */
	@Id
	@Column(name="ID",length=32,nullable=false,unique=true)
    @GenericGenerator(name="generator",strategy="uuid.hex")
    @GeneratedValue(generator="generator")
    private String id;
	
	/**
	 * 部门编码
	 */
	@Column(name="BMBH",length=500)
	private String bmbh;
	
	/**
	 * 部门名称
	 */
	@Column(name="BMMC",length=500)
	private String bmmc;
	
	/**
	 * 信息分类
	 */
	@Column(name="XXFL",length=500)
	private String xxfl;
	
	/**
	 * 序号
	 */
	@Column(name="XH",length=500)
	private String xh;
	
	/**
	 * 决定书文号
	 */
	@Column(name="JDSWH",length=500)
	private String jdswh;
	
	/**
	 * 公文原文
	 */
	@Column(name="GWYW")
	private String gwyw;
	
	/**
	 * 设定依据
	 */
	@Column(name="SDYJ")
	private String sdyj;
	
	/**
	 * 项目名称
	 */
	@Column(name="XMMC",length=500)
	private String xmmc;
	
	/**
	 * 审批类别
	 */
	@Column(name="SPLB",length=500)
	private String splb;
	
	/**
	 * 信用代码
	 */
	@Column(name="XYDM",length=500)
	private String xydm;
	
	/**
	 * 生效日期
	 */
	@Column(name="TAKEEFFECTDATE",length=500)
	private String takeEffectDate;
	
	/**
	 * 失效日期
	 */
	@Column(name="LOSTEFFECTDATE",length=500)
	private String lostEffectDate;
	
	/**
	 * 承办部门
	 */
	@Column(name="CBBM",length=500)
	private String cbbm;
	
	/**
	 * 其它共同审批部门
	 */
	@Column(name="QTGTSPBM",length=500)
	private String qtgtspbm;
	
	/**
	 * 办理结果
	 */
	@Column(name="BLJG",length=500)
	private String bljg;
	
	/**
	 * 许可对象
	 */
	@Column(name="XKDX",length=500)
	private String xkdx;
	
	/**
	 * 上传时间
	 */
	@Column(name="SCSJ",length=500)
	private String scsj;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBmbh() {
		return bmbh;
	}

	public void setBmbh(String bmbh) {
		this.bmbh = bmbh;
	}

	public String getBmmc() {
		return bmmc;
	}

	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}

	public String getXxfl() {
		return xxfl;
	}

	public void setXxfl(String xxfl) {
		this.xxfl = xxfl;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getJdswh() {
		return jdswh;
	}

	public void setJdswh(String jdswh) {
		this.jdswh = jdswh;
	}

	public String getGwyw() {
		return gwyw;
	}

	public void setGwyw(String gwyw) {
		this.gwyw = gwyw;
	}

	public String getSdyj() {
		return sdyj;
	}

	public void setSdyj(String sdyj) {
		this.sdyj = sdyj;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public String getSplb() {
		return splb;
	}

	public void setSplb(String splb) {
		this.splb = splb;
	}

	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getTakeEffectDate() {
		return takeEffectDate;
	}

	public void setTakeEffectDate(String takeEffectDate) {
		this.takeEffectDate = takeEffectDate;
	}

	public String getLostEffectDate() {
		return lostEffectDate;
	}

	public void setLostEffectDate(String lostEffectDate) {
		this.lostEffectDate = lostEffectDate;
	}

	public String getCbbm() {
		return cbbm;
	}

	public void setCbbm(String cbbm) {
		this.cbbm = cbbm;
	}

	public String getQtgtspbm() {
		return qtgtspbm;
	}

	public void setQtgtspbm(String qtgtspbm) {
		this.qtgtspbm = qtgtspbm;
	}

	public String getBljg() {
		return bljg;
	}

	public void setBljg(String bljg) {
		this.bljg = bljg;
	}

	public String getXkdx() {
		return xkdx;
	}

	public void setXkdx(String xkdx) {
		this.xkdx = xkdx;
	}

	public String getScsj() {
		return scsj;
	}

	public void setScsj(String scsj) {
		this.scsj = scsj;
	}

}
