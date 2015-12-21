package com.imark.system.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.util.Constant;
import com.imark.common.util.UserCredentialsMatcher;
import com.imark.system.model.SysLoginUser;
import com.imark.system.service.h2.SysLoginUserService;


@Controller
public class IndexController {
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	/***
	 * @author wuyechun
	 * @return
	 */
	@RequestMapping({"/","/login","/welcome"})
	public String index(){
		return "login";
	}
	
	
	/**
	 * 
	 * @Description：用户登录
	 *
	 * @date：2015-9-23 下午08:03:26
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping(value = "/doLogin")
	public ModelAndView doLogin(String loginAccount,String loginPwd,HttpSession session){
		
		boolean isValid=false;
		ModelAndView mv=new ModelAndView();
		List<SysLoginUser> list=sysLoginUserService.findByLoginAccount(loginAccount);
		SysLoginUser sysLoginUser=null;
		if(list!=null&&!list.isEmpty()){
			sysLoginUser=list.get(0);
			if(sysLoginUser!=null){
				//两次MD5加密
				loginPwd=UserCredentialsMatcher.GetMD5Str32(UserCredentialsMatcher.GetMD5Str32(loginPwd));
				if(loginPwd.equals(sysLoginUser.getLoginPwd())&&!"D".equals(sysLoginUser.getUserState())){
					//将系统用户存入session
					session.setAttribute(Constant.CURRENT_USER, sysLoginUser);
					isValid=true;
				}
			}
		}
		if(isValid){
			mv.addObject(Constant.CURRENT_USER, sysLoginUser);
			mv.setViewName("welcome");
		}else{
			mv.addObject(Constant.ERROR_MSG, "用户名或密码错误！");
			mv.setViewName("login");
		}
		return mv;
	}
	
	/**
	 * 
	 * @Description：主页面
	 *
	 * @date：2015-9-24 下午04:46:09
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping(value = "/main")
	public String main(){
		return "main";
	}
	
	
	/**
	 * 
	 * @Description：web示例页面
	 *
	 * @date：2015-9-24 下午04:46:03
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping(value = "/webDemo")
	public String webDemo(){
		return "webDemo";
	}
	
	/**
	 * 
	 * 功能 :系统跳转页面公用方法
	
	 * 开发：wuyechun 2013-9-3
	
	 * @param module
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "views/{module}/{page}")
	public String getDefinedPage(@PathVariable("module") String module,@PathVariable("page") String page) {
		return module+"/"+page;
	}
	
	
	
}
