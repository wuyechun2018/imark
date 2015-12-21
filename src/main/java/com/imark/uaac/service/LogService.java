package com.imark.uaac.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imark.common.util.FreeMarkerUtil;
import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyPager;
import com.imark.uaac.dao.LogDaoImpl;
import com.imark.uaac.vo.ChartSeries;

@Component
public class LogService {
	
	@Autowired
	private LogDaoImpl logDaoImpl;
	
	/**
	 * 获取安全审计日志列表
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	public List getSafeLoges(String name, String startDate, String endDate, Long startPos, Long endPos) {
		return logDaoImpl.getSafeLoges(name, startDate, endDate, startPos, endPos);
	}
	
	/**
	 * 获取安全审计日志条数
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Long getSafeLogCount(String name, String startDate, String endDate) {
		return logDaoImpl.getSafeLogCount(name, startDate, endDate);
	}

	/***
	 * 
	 * @Description：获取chart展示数据
	 *
	 * @date：2015-10-20 下午01:05:40
	 *
	 * @author ：wuyechun
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getSafeChart(String startDate, String endDate, int pos, HttpServletRequest request) {
		Map<String, Object> propMap = new HashMap<String, Object>();
		// 获取日志统计数据
		List<Map<String, Object>> datas = logDaoImpl.getSafeChart(startDate, endDate, pos);
		// 横坐标
		List<String> xAxis = new ArrayList<String>();
		// 登录日志统计列表
		List loginTotalList = new ArrayList();
		// 查询日志统计列表
		List queryTotalList = new ArrayList();
		// 新增日志统计列表
		List addTotalList = new ArrayList();
		// 编辑日志统计列表
		List updateTotalList = new ArrayList();
		// 删除日志统计列表
		List delTotalList = new ArrayList();
		
		// 日志统计总计
		List<ChartSeries> seriesList = new ArrayList();
		for(Map map : datas) {
			xAxis.add("" + map.get("OPDATE").toString() + "");
			loginTotalList.add(map.get("loginTotal"));
			queryTotalList.add(map.get("queryTotal"));
			addTotalList.add(map.get("addTotal"));
			updateTotalList.add(map.get("updateTotal"));
			delTotalList.add(map.get("delTotal"));
		}
		
		// 日志统计数据的封装
		ChartSeries series1 = new ChartSeries();
		series1.setName("登录");
		series1.setData(loginTotalList.toString());
		seriesList.add(series1);
		ChartSeries series2 = new ChartSeries();
		series2.setName("查询");
		series2.setData(queryTotalList.toString());
		seriesList.add(series2);
		ChartSeries series3 = new ChartSeries();
		series3.setName("增加");
		series3.setData(addTotalList.toString());
		seriesList.add(series3);
		ChartSeries series4 = new ChartSeries();
		series4.setName("编辑");
		series4.setData(updateTotalList.toString());
		seriesList.add(series4);
		ChartSeries series5 = new ChartSeries();
		series5.setName("删除");
		series5.setData(delTotalList.toString());
		seriesList.add(series5);
		
		// 图表标题
		propMap.put("title_text", "安全审计日志分析");
		// 图表横坐标
		Collections.sort(xAxis);
		propMap.put("xAxis_data", xAxis.toString());
		// 图表显示数据
		propMap.put("seriesList", seriesList);
		String seriesData = FreeMarkerUtil.instance().geneFileStr(request,"safechart.ftl", propMap);
		return IUtil.replaceBlank(seriesData);
	}

	/**
	 * 
	 * @Description：单点登录日志记录总数
	 *
	 * @date：2015-10-20 下午04:14:33
	 *
	 * @author ：wuyechun
	 */
	public Long getSsoLogCount(String startDate, String endDate,
			String userName, String organizationName, String operateUrl) {
		return logDaoImpl.getSsoLogCount(startDate,endDate,userName,organizationName,operateUrl);
	}

	/**
	 * 
	 * @Description：单点登录日志记录-分页列表
	 *
	 * @date：2015-10-20 下午04:14:51
	 *
	 * @author ：wuyechun
	 */
	public List getSsoLogs(String startDate, String endDate, String userName,
			String organizationName, String operateUrl, EasyPager pager) {
		return logDaoImpl.getSsoLogs(startDate,endDate,userName,organizationName,operateUrl,pager);
	}

	/***
	 * 
	 * @Description：获取单点登录图表数据
	 *
	 * @date：2015-10-21 上午08:57:02
	 *
	 * @author ：wuyechun
	 */
	public String getSsoChart(HttpServletRequest request) {
		
		// 日期格式显示类型   1：年 、 2：月  、  3：周
		String showType=request.getParameter("showType");
		// 开始日期
		String startDate=request.getParameter("startDate");
		// 结束日期
		String endDate=request.getParameter("endDate");
		
		// 日期字符串截取位数，默认为 8 位，精确到 日
		int datePos=8;
		if(showType != null && showType.equals("1")) {
			datePos=8;
		} 
		if(showType != null && showType.equals("2")) {
			datePos=6;
		}
		if(showType != null && showType.equals("3")) {
			datePos=4;
		}
		
		Map<String, Object> propMap = new HashMap<String, Object>();
		// 获取日志统计数据
		List<Map<String, Object>> datas = logDaoImpl.getSsoChart(startDate, endDate, datePos);
		// 横坐标
		List<String> xAxis = new ArrayList<String>();
		
		// 登录日志统计列表
		List loginTotalList = new ArrayList();
		// 查询日志统计列表
		List queryTotalList = new ArrayList();
		// 新增日志统计列表
		List addTotalList = new ArrayList();
		// 编辑日志统计列表
		List updateTotalList = new ArrayList();
		// 删除日志统计列表
		List delTotalList = new ArrayList();
		
		List<ChartSeries> seriesList = new ArrayList();
		for(Map map : datas) {
			xAxis.add("" + map.get("OPDATE").toString() + "");
			loginTotalList.add(map.get("loginTotal"));
			queryTotalList.add(map.get("loginOutTotal"));
		}
		
		// 日志统计数据的封装
		ChartSeries series1 = new ChartSeries();
		series1.setName("登录");
		series1.setData(loginTotalList.toString());
		seriesList.add(series1);
		ChartSeries series2 = new ChartSeries();
		series2.setName("退出");
		series2.setData(queryTotalList.toString());
		seriesList.add(series2);
		
		// 图表标题
		propMap.put("title_text", "单点登录日志分析");
		// 图表横坐标
		Collections.sort(xAxis);
		propMap.put("xAxis_data", xAxis.toString());
		// 图表显示数据
		propMap.put("seriesList", seriesList);
		String seriesData = FreeMarkerUtil.instance().geneFileStr(request,"safechart.ftl", propMap);
		return IUtil.replaceBlank(seriesData);
	}
}
