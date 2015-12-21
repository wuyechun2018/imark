package com.imark.system.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the APP_DISP_DATA database table.
 * 
 */
@Entity
@Table(name="APP_DISP_DATA")
public class AppDispData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APP_DISP_DATA_ID",length=32,nullable=false,unique=true)
    @GenericGenerator(name="generator",strategy="uuid.hex")
    @GeneratedValue(generator="generator")
	private long appDispDataId;

    @Temporal( TemporalType.DATE)
	@Column(name="DATA_DATE")
	private Date dataDate;

	@Column(name="DATA_KEY")
	private String dataKey;

	@Column(name="DATA_TYPE")
	private String dataType;

	@Column(name="DATA_VALUE")
	private BigDecimal dataValue;

    public AppDispData() {
    }

	public long getAppDispDataId() {
		return this.appDispDataId;
	}

	public void setAppDispDataId(long appDispDataId) {
		this.appDispDataId = appDispDataId;
	}

	public Date getDataDate() {
		return this.dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public BigDecimal getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(BigDecimal dataValue) {
		this.dataValue = dataValue;
	}

}