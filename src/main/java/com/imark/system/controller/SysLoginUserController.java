package com.imark.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.util.UserCredentialsMatcher;
import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.common.vo.JsonMsg;
import com.imark.system.model.SysLoginUser;
import com.imark.system.service.h2.SysLoginUserService;

@Controller
@RequestMapping("/sysLoginUser")
public class SysLoginUserController extends BaseController{
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	/**
	 * 
	 * 方法描述：list
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request){
		
		//登录名
		String loginAccount=request.getParameter("loginAccount");
		//性别
		String sex=request.getParameter("sex");
		
		Map param=new HashMap();
		param.put("loginAccount",loginAccount);
		param.put("sex",sex);
		
		//获取分页信息
		EasyPager pager=getPager(request);
		Long total = sysLoginUserService.getCount(param);
		List list=sysLoginUserService.getList(pager,param);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}
	
	/**
	 * 
	 * 方法描述：保存用户
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(SysLoginUser sysLoginUser){
		if(sysLoginUser.getLoginPwd()==null){
			//默认密码 123456
			sysLoginUser.setLoginPwd(UserCredentialsMatcher.GetMD5Str32(UserCredentialsMatcher.GetMD5Str32("123")));
		}
		sysLoginUserService.save(sysLoginUser);
		return new JsonMsg();
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request){
		String userId=request.getParameter("userId");
		sysLoginUserService.delete(userId);
		return new JsonMsg();
	}
	
	

}
