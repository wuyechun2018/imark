package com.imark.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.vo.JsonMsg;
import com.imark.system.dao.jpa.SysMenuJpaDao;
import com.imark.system.model.SysMenu;
import com.imark.system.service.h2.SysMenuService;

@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	
	
	/***
	 * 
	 * 功能 :删除登录用户
	
	 * 开发：wuyechun 2016-1-18
	
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request){
		String id=request.getParameter("id");
		sysMenuService.delete(id);
		return new JsonMsg();
	}
	
	/**
	 * 
	 * 功能 :保存
	
	 * 开发：wuyechun 2016-2-29
	
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(SysMenu sysMenu){
		sysMenuService.save(sysMenu);
		//return new ModelAndView("/system/menu");
		//return "redirect:/views/system/menu";
		return new JsonMsg();
	}
	
	
	/**
	 * 
	 * 功能 :获取子菜单
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getChildList")
	@ResponseBody
	public Object getChildList(String pid){
		return sysMenuService.getListByPid(pid);
	}
	

}
