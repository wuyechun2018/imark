package com.imark.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String servletPath = request.getServletPath();

		String[] needFilter = new String[] { "/views/file/upload"};

		for (String url : needFilter) {
			// 需要过滤
			if (servletPath.indexOf(url) > -1) {
				if (!isLogin(request)){
					//request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
					//request.sendRedirect("/imark/login");
					response.sendRedirect("http://www.baidu.com");
					return;
				}
				break;
			}
		}
		chain.doFilter(request, response);
	}
		
		
		

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * 
	 * @Description：是否登录
	 *
	 * @date：2015-10-7 下午08:48:09
	 *
	 * @author ：wuyechun
	 */
	public  boolean isLogin(HttpServletRequest request){
		String name=(String) request.getSession().getAttribute("cas.login.user");
		
		boolean isLogin=false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (IUtil.equalsIgnoreCase("cas_cookie_auth_id", cookie.getName())) {
					String authId = cookie.getValue();
					isLogin= true;
				}
			}
		}
		return isLogin;
	}
	

}
