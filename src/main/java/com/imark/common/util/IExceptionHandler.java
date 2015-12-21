package com.imark.common.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class IExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(IExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		String exMsg="";
		
		if (ex instanceof MaxUploadSizeExceededException) {
			System.out.println(" -- File Size Exceeds --");
			exMsg="文件太大,请重新上传！";
		}else if(ex.getClass().equals(DataAccessException.class)){
			exMsg="数据库操作失败";
		}else if(ex.getClass().equals(NullPointerException.class)) {
			exMsg = "空指针异常";
		} else if(ex.getClass().equals(IOException.class)) {
			exMsg = "IO异常";
		} else if(ex.getClass().equals(ClassNotFoundException.class)) {
			exMsg = "指定的类不存在";
		} else if (ex.getClass().equals(ArithmeticException.class)) {
			exMsg = "数学运算异常";
		}else if (ex.getClass().equals(IllegalArgumentException.class)) {
			exMsg = "方法的参数错误";
		}else if (ex.getClass().equals(ClassCastException.class)) {
			exMsg = "类型强制转换错误";
		}else if (ex.getClass().equals(SecurityException.class)) {
			exMsg = "违背安全原则异常";
		}else if (ex.getClass().equals(SQLException.class)) {
			exMsg = "SQL异常";
		}else if (ex.getClass().equals(NoSuchMethodError.class)) {
			exMsg = "方法末找到异常";
		}else if (ex.getClass().equals(InternalError.class)) {
			exMsg = "程序内部错误，操作失败";
		}else{
			exMsg=ex.getMessage();
		}
		model.put("ex", ex);
		model.put("exMsg", exMsg);
		logger.error(ex.getClass().getSimpleName()+":"+exMsg);
		return new ModelAndView("error/error", model);
	}

}
