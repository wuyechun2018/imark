package com.imark.ws;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import com.imark.common.util.WebRequest;

public class YxptTest {
	public static void main(String[] args) {
		// 住房公积金单位信息变更审核业务表单数据提交接口
		//zhuFangGjjChangeReporting();
		
		// 住房公积金业务表单数据提交接口
		//zfgjjslspSubmit();
		
		// 办件结果批量查询接口
		caseListQueryService();
		
		// 联动事项网上申报接口
		//onlineReportLinkageNetCase();
	}
	
	/**
	 * 住房公积金单位信息变更审核业务表单数据提交接口
	 */
	public static void zhuFangGjjChangeReporting() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("a", "a");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		String postData = "baseContent=" + paramString + "&zhuFangGjjChangeInfo=" + paramString;
		WebRequest request=new WebRequest();
		String result = null;
		try {
			//result = request.sendPost("http://localhost:8081/yxpt/zhuFangGjjChangeReporting", paramString);
			request.post("http://localhost:8081/yxpt/zhuFangGjjChangeReporting", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 住房公积金业务表单数据提交接口
	 */
	public static void zfgjjslspSubmit() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("a", "a");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		String postData = "baseContent=" + paramString + "&zfGjjZhslSp=" + paramString;
		WebRequest request=new WebRequest();
		String result = null;
		try {
			//result = request.sendPost("http://localhost:8081/yxpt/zhuFangGjjChangeReporting", paramString);
			request.post("http://localhost:8081/yxpt/zfgjjslspSubmit", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 办件结果批量查询接口
	 */
	public static void caseListQueryService() {
		String postData = "caseNoes=123";
		
		WebRequest request=new WebRequest();
		String result = null;
		try {
			//result = request.sendPost("http://localhost:8081/yxpt/zhuFangGjjChangeReporting", paramString);
			result = request.post("http://59.203.153.116:8081/yxpt/caseListQueryService", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 联动事项网上申报接口
	 */
	public static void onlineReportLinkageNetCase() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("a", "a");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		String postData = "reporteContent="+ paramString +"&disCode=123";
		
		WebRequest request=new WebRequest();
		String result = null;
		try {
			//result = request.sendPost("http://localhost:8081/yxpt/zhuFangGjjChangeReporting", paramString);
			result = request.post("http://localhost:8081/yxpt/onlineReportLinkageNetCase", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
}