package com.imark.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

import com.imark.common.util.IUtil;

/*******************************************************************************
 *  功能说明: 系统登权限实体类
  
 *  2014-1-23 下午5:35:37 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2014-1-23 下午5:35:37 ycwu 修改文件
 * 
 ******************************************************************************/
@Entity
@Table(name = "SYS_MENU")
public class SysMenu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	// Fields
	private String menuId;   		//主键
	private String menuPid;   	//父主键
	private String menuName;    //目录名称
	private String menuAddr;    //地址
	private String menuIconUrl; //url
	private String menuType;	//目录类型  0：文件夹     1：菜单
	private String isUse;		//是否在用
	private String memo;        //说明
	private Long orderNo;		//排序
	private String menuPath;    //路径  系统管理->角色管理

	// Constructors

	/** default constructor */
	public SysMenu() {
	}

	/** minimal constructor */
	public SysMenu(String menuId, String menuPid, String menuName) {
		this.menuId = menuId;
		this.menuPid = menuPid;
		this.menuName = menuName;
	}

	/** full constructor */
	public SysMenu(String menuId, String menuPid, String menuName,
			String menuIconUrl, String menuType, String isUse, String memo,
			Long orderNo) {
		this.menuId = menuId;
		this.menuPid = menuPid;
		this.menuName = menuName;
		this.menuIconUrl = menuIconUrl;
		this.menuType = menuType;
		this.isUse = isUse;
		this.memo = memo;
		this.orderNo = orderNo;
	}

	// Property accessors
	//@GeneratedValue(strategy = GenerationType.TABLE,generator="SysMenu")
	//@TableGenerator(name="SysMenu",table="PK_GENERERATE_SEQ",pkColumnName="gen_key",valueColumnName="gen_value",pkColumnValue="SYS_MENU",allocationSize = 1)
	
	@Id
	@GenericGenerator(name="systemUUID",strategy="uuid")
	@GeneratedValue(generator="systemUUID")
	@Column(name = "ID")
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "MENU_PID")
	public String getMenuPid() {
		//System.out.println("========================="+this.menuPid);
		return this.menuPid;
	}

	public void setMenuPid(String menuPid) {
		this.menuPid = menuPid;
	}

	@Column(name = "MENU_NAME", nullable = false, length = 20)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	@Column(name = "MENU_ADDR", nullable = true, length = 100)
	public String getMenuAddr() {
		return menuAddr;
	}

	public void setMenuAddr(String menuAddr) {
		this.menuAddr = menuAddr;
	}
	

	@Column(name = "MENU_ICON_URL", length = 20)
	public String getMenuIconUrl() {
		return this.menuIconUrl;
	}

	public void setMenuIconUrl(String menuIconUrl) {
		this.menuIconUrl = menuIconUrl;
	}

	@Column(name = "MENU_TYPE", length = 1)
	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	@Column(name = "IS_USE", length = 1)
	public String getIsUse() {
		return this.isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	@Column(name = "MEMO", length = 500)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "ORDER_NO", precision = 10, scale = 0)
	public Long getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "MENU_PATH", length = 100)
	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	
	

}