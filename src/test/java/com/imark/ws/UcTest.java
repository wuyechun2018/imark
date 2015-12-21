package com.imark.ws;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;
import com.imark.common.util.WebRequest;

/**
 * UC接口测试
 * @author lwzhang
 *
 */
public class UcTest {
	/**
	 * 主测试方法
	 * @param args
	 */
	public static void main(String args[]){
		//用户自动注册
		//registerAccountPersonal();
		//企业自动注册
		//registerAccountCompany();
		//同步账号
		//accountSync();
		// 房屋鉴定处直接登录接口
		//identityAuthLogin();
	}
	
	/**
	 * 用户自动注册（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void registerAccountPersonal() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("fwfname", "fwfname44");
		paramsMap.put("fcreatedate", "2015-08-27");
		paramsMap.put("faddress", "业务名称44");
		paramsMap.put("fname", "zhangsan");
		paramsMap.put("fPhone", "18096633644");
		paramsMap.put("fidcard", "340223198808231244");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 测试(联创-统一认证中心)
			//result = request.sendPost("http://localhost:8080/uucenter-ws-web/webservice/eho/register/registerAccountPersonal", paramString);
			// 生产(联创-统一认证中心)
			//result = request.sendPost("http://172.16.7.55:85/uucInterface/webservice/eho/register/registerAccountPersonal", paramString);			
			// 测试(数据交换共享平台)
			result = request.sendPost("http://localhost:8081/uucenter/userRegist", paramString);
			// 生产(数据交换共享平台)
			//result = request.sendPost("http://59.203.153.116:8081/uucenter/userRegist", paramString);	
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 企业自动注册（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void registerAccountCompany() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("projectname", "项目");
		paramsMap.put("revdate", "2015-08-27");
		paramsMap.put("sljtdd", "安徽");
		paramsMap.put("sqdwjbrxm", "张三");
		paramsMap.put("sqdwjbrsj", "18096633655");
		paramsMap.put("cardtype", "3");
		paramsMap.put("cardid", "577060112");
		paramsMap.put("sqrtype", "2");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 测试（联创-统一认证中心）
			result = request.sendPost("http://172.16.10.39:8080/uucenter-ws-web/webservice/eho/register/registerAccountCompany", paramString);
			// 生产（联创-统一认证中心）
			//result = request.sendPost("http://172.16.7.55:85/uucInterface/webservice/eho/register/registerAccountCompany", paramString);
			// 测试（数据交换共享平台）
			//result = request.sendPost("http://172.16.10.75:8081/uucenter/bizRegist", paramString);
			// 生产（数据交换共享平台）
			//result = request.sendPost("http://59.203.153.116:8081/uucenter/bizRegist", paramString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 同步账号（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void accountSync() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("accountCode", "lwzhang12");
		paramsMap.put("password", "123456");
		paramsMap.put("mobilePhone", "18096633655");
		paramsMap.put("erpName", "安徽讯飞联创信息科技有限公司");
		paramsMap.put("registNumber", "060100");
		paramsMap.put("organCode", "05162585");
		paramsMap.put("registSource", "101100");
		paramsMap.put("province", "AH");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 测试（联创-统一认证中心）
			//result = request.sendPost("http://172.16.10.39:8080/uucenter-ws-web/webservice/eho/synchronizationAccount/synqiyeAccount", paramString);
			// 生产（联创-统一认证中心）
			//result = request.sendPost("http://172.16.7.55:85/uucInterface/webservice/eho/synchronizationAccount/synqiyeAccount", paramString);
			// 测试（数据交换共享平台）
			//result = request.sendPost("http://172.16.10.75:8081/uucenter/accountSync", paramString);
			// 生产（数据交换共享平台）
			result = request.sendPost("http://59.203.153.116:8081/uucenter/accountSync", paramString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 房屋鉴定处直接登录接口（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void identityAuthLogin() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("userName", "mysj");
		paramsMap.put("password", "123qwe");
		paramsMap.put("resource", "010100");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 测试（联创-统一认证中心）
			//result = request.sendPost("http://172.16.10.39:8080/uucenter-ws-web/webservice/eho/user/identityAuthLogin", paramString);
			// 生产（联创-统一认证中心）
			//result = request.sendPost("http://172.16.7.55:85/uucenter-ws-web/webservice/eho/user/identityAuthLogin", paramString);
			// 测试（数据交换共享平台）
			result = request.sendPost("http://172.16.10.75:8081/uucenter/identityAuthLogin", paramString);
			// 生产（数据交换共享平台）
			//result = request.sendPost("http://59.203.153.116:8081/uucenter/identityAuthLogin", paramString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
}
