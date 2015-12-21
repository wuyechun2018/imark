package com.imark.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 行政处罚实体类
 * @author lwzhang
 *
 */
@Entity
@Table(name="XYWH_XZCF")
public class Xzcf {
	private static final long serialVersionUID = 1L;

	/**
	 * 物理ID
	 */
	@Id
	@Column(name="ID",length=32,nullable=false,unique=true)
    @GenericGenerator(name="generator",strategy="uuid.hex")
    @GeneratedValue(generator="generator")
	private String id;
	
	/**
	 * 部门编号
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
	 * 执法依据
	 */
	@Column(name="ZFYJ")
	private String zfyj;
	
	/**
	 * 案件名称
	 */
	@Column(name="AJMC",length=500)
	private String ajmc;
	
	/**
	 * 信用代码
	 */
	@Column(name="XYDM",length=500)
	private String xydm;
	
	/**
	 * 处罚事由
	 */
	@Column(name="CFSY",length=500)
	private String cfsy;
	
	/**
	 * 处罚结果
	 */
	@Column(name="CFJG",length=500)
	private String cfjg;
	
	/**
	 * 处罚履行方式
	 */
	@Column(name="CFLXFS",length=500)
	private String cflxfs;
	
	/**
	 * 生效日期
	 */
	@Column(name="SXRQ",length=500)
	private String sxrq;
	
	/**
	 * 处罚期限
	 */
	@Column(name="CFQX",length=500)
	private String cfqx;
	
	/**
	 * 处罚部门
	 */
	@Column(name="CFBM",length=500)
	private String cfbm;
	
	/**
	 * 结案日期
	 */
	@Column(name="JARQ",length=500)
	private String jarq;
	
	/**
	 * 救济渠道
	 */
	@Column(name="JJQD",length=500)
	private String jjqd;
	
	/**
	 * 处罚对象
	 */
	@Column(name="CFDX",length=500)
	private String cfdx;
	
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

	public String getZfyj() {
		return zfyj;
	}

	public void setZfyj(String zfyj) {
		this.zfyj = zfyj;
	}
	
	public String getAjmc() {
		return ajmc;
	}

	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}

	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getCfsy() {
		return cfsy;
	}

	public void setCfsy(String cfsy) {
		this.cfsy = cfsy;
	}

	public String getCfjg() {
		return cfjg;
	}

	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}

	public String getCflxfs() {
		return cflxfs;
	}

	public void setCflxfs(String cflxfs) {
		this.cflxfs = cflxfs;
	}

	public String getSxrq() {
		return sxrq;
	}

	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}

	public String getCfqx() {
		return cfqx;
	}

	public void setCfqx(String cfqx) {
		this.cfqx = cfqx;
	}

	public String getCfbm() {
		return cfbm;
	}

	public void setCfbm(String cfbm) {
		this.cfbm = cfbm;
	}

	public String getJarq() {
		return jarq;
	}

	public void setJarq(String jarq) {
		this.jarq = jarq;
	}

	public String getJjqd() {
		return jjqd;
	}

	public void setJjqd(String jjqd) {
		this.jjqd = jjqd;
	}

	public String getCfdx() {
		return cfdx;
	}

	public void setCfdx(String cfdx) {
		this.cfdx = cfdx;
	}

	public String getScsj() {
		return scsj;
	}

	public void setScsj(String scsj) {
		this.scsj = scsj;
	}

}
