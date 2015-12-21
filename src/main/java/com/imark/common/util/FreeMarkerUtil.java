package com.imark.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {

	/**
	 * Logger for this class
	 */
	//private static Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);

	private static FreeMarkerUtil instance;
	private Configuration config;
	

	String templatePath = "/resources/freeMarker/";

	public static FreeMarkerUtil instance() {
		if (instance == null) {
			instance = new FreeMarkerUtil();
		}
		return instance;
	}

	private void configInstance(HttpServletRequest request) {
		if (this.config == null) {
			this.config = new Configuration();
			this.config.setServletContextForTemplateLoading(request.getSession().getServletContext(),templatePath);
		}
	}

	/**
	 * 
	 * 功能 :通过模板文件返回生成的字符串
	
	 * 开发：ycwu 2014-9-10
	
	 * @param templateFileName
	 * @param propMap
	 * @return
	 */
	public String geneFileStr(HttpServletRequest request,String templateFileName, Map<String, Object> propMap) {
		configInstance(request);
		StringWriter out = new StringWriter();
		Template tmp;
		try {
			//tmp = this.config.getTemplate(templateFileName);
			//解决在Jetty下显示正常,在Tomcat下乱码的情况
			tmp = this.config.getTemplate(templateFileName,"UTF-8");
			tmp.setEncoding("UTF-8");
			tmp.process(propMap, out);
		} catch (IOException e) {
			//logger.error("I/O 错误!", e);
		} catch (TemplateException e) {
			//logger.error("模板错误!", e);
		}
		return out.getBuffer().toString();
	}

}
