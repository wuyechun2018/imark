package com.imark.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.vo.JsonMsg;
import com.imark.system.model.SysMenu;
import com.imark.system.service.h2.SysMenuService;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	
	/**
	 * 方法描述：save
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(){
		//DBContextHolder.setDBType(Constant.DATA_SOURCE_THREE);
		SysMenu sysMenu=new SysMenu();
		//menu.setMenuId(menuId);
		sysMenu.setMenuName("我的年轮");
		sysMenu.setIsUse("1");
		sysMenu.setMenuAddr("menuAddr");
		sysMenu.setMemo("memo");
		sysMenu.setMenuIconUrl("menuIconUrl");
		sysMenu.setMenuPath("menuPath");
		sysMenu.setMenuPid("1");
		sysMenu.setMenuType("1");
		sysMenu.setOrderNo(1L);
		//sysMenu.setMenuId("402881f051196c6d0151196fc4f20001");
		sysMenuService.save(sysMenu);
		
		List list=sysMenuService.getList();
		System.out.println("size...."+list.size());
		
		return new JsonMsg();
		
	}
	

}
