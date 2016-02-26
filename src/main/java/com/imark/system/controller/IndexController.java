package com.imark.system.controller;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
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
	
	private Date serverStartTime = new Date();
	
	/***
	 * @author wuyechun
	 * @return
	 */
	@RequestMapping({"/","/login","/welcome"})
	public String index(){
		return "login";
	}
	
	
	/***
	 * 
	 * 功能 :退出系统
	 * 
	 * 开发：wuyechun 2013-9-24
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginout")
	public String doLoginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.CURRENT_USER);
		session.invalidate();
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
			mv.setViewName("main");
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
	
	
	
	@RequestMapping(value = "/sysinfo")
	public ModelAndView getSysInfo(HttpServletRequest request){
		/*//版本号
		System.out.println(System.getProperty("java.version"));   
        System.out.println(System.getProperty("java.vendor"));   
        System.out.println(System.getProperty("java.vendor.url")); 
        //Java 安装目录  
        System.out.println(System.getProperty("java.home"));   
        System.out.println(System.getProperty("java.vm.specification.version"));   
        System.out.println(System.getProperty("java.vm.specification.vendor"));   
        System.out.println(System.getProperty("java.vm.specification.name"));   
        System.out.println(System.getProperty("java.vm.version"));   
        System.out.println(System.getProperty("java.vm.vendor"));   
        System.out.println(System.getProperty("java.vm.name"));   
        System.out.println(System.getProperty("java.specification.version"));   
        System.out.println(System.getProperty("java.specification.vendor"));   
        System.out.println(System.getProperty("java.specification.name"));   
        System.out.println(System.getProperty("java.class.version"));   
        System.out.println(System.getProperty("java.class.path"));   
        System.out.println(System.getProperty("java.library.path"));   
        System.out.println(System.getProperty("java.io.tmpdir"));   
        System.out.println(System.getProperty("java.compiler"));   
        System.out.println(System.getProperty("java.ext.dirs")); 
        
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.version"));
        //用户的账户名称  
        System.out.println(System.getProperty("user.name"));
        //用户的主目录  
        System.out.println(System.getProperty("user.home"));
        //用户的当前工作目录 
        System.out.println(System.getProperty(" user.dir"));*/
        
        Properties props = System.getProperties();
		long maxMemory = Runtime.getRuntime().maxMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();

		ModelAndView mv = new ModelAndView("/sysinfo");

		mv.addObject("serverUrl", getServerUrl(request));
		mv.addObject("host", getHostName());
		mv.addObject("serverStartTime", getServerStartTime());

		mv.addObject("osName", props.get("os.name"));
		mv.addObject("osVersion", props.get("os.version"));
		mv.addObject("javaHome", props.get("java.home"));
		mv.addObject("javaRuntimeName", props.get("java.runtime.name"));
		mv.addObject("javaVersion", props.get("java.version"));
		mv.addObject("javaVendor", props.get("java.vendor"));
		mv.addObject("javaVmVersion", props.get("java.vm.version"));
		mv.addObject("maxMemory", maxMemory / 1024 / 1024);
		mv.addObject("totalMemory", totalMemory / 1024 / 1024);

		return mv;
        
        
	}
	
	/**
	 * 
	 * 功能 :服务地址
	
	 * 开发：wuyechun 2016-2-25
	
	 * @param request
	 * @return
	 */
	private String getServerUrl(HttpServletRequest request) {
		String schema = request.getScheme();
		String server = request.getServerName();
		int port = request.getServerPort();
		String context = request.getContextPath();

		String serverUrl = schema + "://" + server + (port == 80 ? "" : (":" + port)) + context;
		return serverUrl;
	}
	
	
	/**
	 * 
	 * 功能 :主机名
	
	 * 开发：wuyechun 2016-2-25
	
	 * @return
	 */
	private String getHostName() {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String name = inetAddress.getHostName();
			return name;
		}
		catch (UnknownHostException e) {
			return "";
		}

	}
	
	/**
	 * 
	 * 功能 :系统启动时间
	
	 * 开发：wuyechun 2016-2-25
	
	 * @return
	 */
	private String getServerStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(serverStartTime);
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
