package com.imark.system.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyPager;

public class BaseController {
	

	public static void writeMsg(HttpServletResponse response,String success,String msg) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		Writer writer = response.getWriter();
		writer.write("{\"success\": \""+success+"\",\"msg\":\'"+msg+"\'}");
	}
	
	public static void writeResultMsg(HttpServletResponse response,String success,String msg,Long result) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		Writer writer = response.getWriter();
		writer.write("{\"success\": \""+success+"\",\"msg\":\'"+msg+"\',\"result\":\'"+result+"\'}");
	}
	
	/**
	 * 日期格式化处理
	 * @param binder
	 */
	@InitBinder  
    public void initBinder(WebDataBinder binder) {  
       DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
       binder.registerCustomEditor(Date.class,new CustomDateEditor(format, true)); 
   }
	
	
	/**
	 * 
	 * @Description：获取当前登录人信息
	 *
	 * @date：2015-10-8 上午10:58:25
	 *
	 * @author ：wuyechun
	 */
    public String getUserInfo(HttpServletRequest request){
    	String name=(String) request.getSession().getAttribute("cas.login.user");
    	return name;
    }
    
    
    
    /**
     * 
     * @Description：获取EasyUI分页信息
     *
     * @date：2015-10-20 下午04:08:37
     *
     * @author ：wuyechun
     */
    public EasyPager getPager(HttpServletRequest request){
    	EasyPager pager=new EasyPager();
    	if(IUtil.isNotBlank(request.getParameter("rows"))){
    		pager.setPage(Integer.valueOf(request.getParameter("page")));
    	}
    	if(IUtil.isNotBlank(request.getParameter("rows"))){
    		pager.setRows(Integer.valueOf(request.getParameter("rows")));
    	}
    	return pager;
    }
    
    
    /**
     * 
     * 方法描述：打印参数
     * @param request 
     * @exception 
     * @author wuyechun
     */
    public void showParam(HttpServletRequest request){
    	Map map = new HashMap();
	    Enumeration paramNames = request.getParameterNames();
	    while (paramNames.hasMoreElements()) {
	      String paramName = (String) paramNames.nextElement();
	      String[] paramValues = request.getParameterValues(paramName);
	      if (paramValues.length == 1) {
	        String paramValue = paramValues[0];
	        System.out.println("参数：" + paramName );
	        System.out.println("值：" + paramValue);
	        
	        /**
	        if (paramValue.length() != 0) {
		          System.out.println("参数：" + paramName + "  值：" + paramValue);
		          map.put(paramName, paramValue);
		        }**/
	        
	      }
	    }
    }
	
	
	
}
