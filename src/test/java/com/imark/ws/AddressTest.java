package com.imark.ws;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import com.imark.common.util.WebRequest;

public class AddressTest {
	
	public static void main(String[] args) throws MalformedURLException, IOException{
		//address();
		//queryAuthServiceList();
		bszncx();
	}
	
	
	/**
	 * 
	 * 方法描述：办事指南查询
	 * @throws MalformedURLException
	 * @throws IOException 
	 * @exception 
	 * @author wuyechun
	 */
	private static void bszncx() throws MalformedURLException, IOException {
		WebRequest request=new WebRequest();
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("key", "72444ec6bd66d7e44806a59239b2fa74");
		paramsMap.put("serviceName", "公积金");
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		
		String result=request.post("http://localhost:8081/bsx/bszncx", paramString, null);
		System.out.println(result);
	}


	public static void address() throws MalformedURLException, IOException{
			WebRequest webRequest = new WebRequest();
			String url="http://59.203.153.116:8081/standard/address?dm=340202402001";
			String result = webRequest.get(url, null);
			System.out.println(result);
	}
	
	
	/**
	 * 
	 * 方法描述：queryAuthServiceList
	 * @throws MalformedURLException
	 * @throws IOException 
	 * @exception 
	 * @author wuyechun
	 */
	public static void queryAuthServiceList() throws MalformedURLException, IOException{
		WebRequest webRequest = new WebRequest();
		String url="http://172.16.10.75:8081/cos/queryAuthServiceList?loginName=xsc1&keyword=&limit=10";
		String result = webRequest.get(url, null);
		System.out.println(result);
	}
	
	

}
