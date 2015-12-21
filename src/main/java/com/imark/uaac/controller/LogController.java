package com.imark.uaac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.system.controller.BaseController;
import com.imark.uaac.service.LogService;

/**
 * 日志管理
 *
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {
	
	@Autowired
	private LogService logService;
	
	/**
	 * 获取安全审计日志列表
	 * @param userName
	 * @param page
	 * @param rows
	 * @param startDate
	 * @param endDate
	 * @param response
	 * @param request
	 * @return
	 * @author lwzhang
	 */
	@RequestMapping("/getSafeLogs")
	@ResponseBody
	public EasyGrid getSafeLoges(String userName, Integer page, Integer rows, String startDate, String endDate,
			HttpServletResponse response, HttpServletRequest request) {
		// 获取安全审计条数
		Long total = logService.getSafeLogCount(userName, startDate, endDate);
		// 获取安全审计列表
		List list=logService.getSafeLoges(userName, startDate, endDate, (page-1)*rows*1L, page*rows*1L);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}
	
	/**
	 * 
	 * @Description：获取单点登录日志
	 *
	 * @date：2015-10-20 下午03:44:19
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getSsoLogs")
	@ResponseBody
	public Object getSsoLogs(HttpServletResponse response, HttpServletRequest request) {
		
		//获取分页信息
		EasyPager pager=getPager(request);
		
		//开始时间
		String startDate=request.getParameter("startDate");
		//结束时间
		String endDate=request.getParameter("endDate");
		//用户名
		String userName=request.getParameter("userName");
		//组织机构 名称
		String organizationName=request.getParameter("organizationName");
		//平台地址
		String operateUrl=request.getParameter("operateUrl");
		
		// 获取单点登录日志条数
		Long total = logService.getSsoLogCount(startDate, endDate,userName,organizationName,operateUrl);
		// 获取单点登录日志列表
		List list=logService.getSsoLogs(startDate, endDate,userName,organizationName,operateUrl,pager);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}
	
	
	
	/***
	 * 
	 * 功能 :获取用于安全审计展示的数据
	
	 * 开发：lwzhang 2014-10-29
	 */
	@RequestMapping(value = "/getSafeChart")
	@ResponseBody
	public String getSafeChart(String startDate, String endDate, String showType, HttpServletRequest request){
		// 日期字符串截取位数，默认为 8 位，精确到 日
		int pos = 8;
		// 日期格式显示类型   1：年 、 2：月  、  3：周
		if(showType != null && showType.equals("1")) {
			pos=8;
		}
		if(showType != null && showType.equals("2")) {
			pos=6;
		}
		if(showType != null && showType.equals("3")) {
			pos=4;
		}
		return logService.getSafeChart(startDate, endDate, pos, request);
	}
	
	
	/**
	 * 
	 * @Description：获取单点登录图表数据
	 *
	 * @date：2015-10-21 上午08:56:02
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping(value = "/getSsoChart")
	@ResponseBody
	public String getSsoChart(HttpServletRequest request){
		return logService.getSsoChart(request);
	}
	
	
	
}
