package com.imark.system.service.h2;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imark.system.dao.SysMenuDao;
import com.imark.system.model.SysMenu;

@Component
@Transactional
public class SysMenuService {
	
	@Autowired
	private SysMenuDao sysMenuDaoImpl;
	
	
	/**
	 * 方法描述：保存目录
	 * @param sysMenu 
	 * @exception 
	 * @author wuyechun
	 */
	public void save(SysMenu sysMenu){
		//sysMenuDaoImpl.saveOrUpdate(sysMenu);
		//sysMenuDaoImpl.save(sysMenu);
	}


	public List getList() {
		//return sysMenuDaoImpl.findBySql("SELECT * FROM SYS_MENU");
		return null;
	}

}
