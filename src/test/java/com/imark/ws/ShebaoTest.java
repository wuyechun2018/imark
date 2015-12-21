package com.imark.ws;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import com.imark.common.util.WebRequest;

public class ShebaoTest {

	public static void main(String[] args){
		SentSubmitInfo();
		
	}

	private static void SentSubmitInfo() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("prm_projid", "WHSI102000000000000088");
		paramsMap.put("prm_servicecode", "WHSI100006");
		paramsMap.put("prm_is_multi", "0");
		paramsMap.put("prm_multi_id", "0");
		paramsMap.put("prm_apply_cardtype", "1");
		paramsMap.put("prm_apply_cardnumber", "340201199909099999");
		paramsMap.put("prm_applyname", "李四");
		paramsMap.put("prm_applytype", "1");
		paramsMap.put("prm_contactman", "李四");
		paramsMap.put("prm_contactman_cardtype", "1");
		paramsMap.put("prm_contactman_cardnumber", "340201199909099999");
		paramsMap.put("prm_telphone", "13999999999");
		paramsMap.put("prm_address", "芜湖市");
		paramsMap.put("prm_items", "[{'itemNo':'1','itemPath':'fdsf//dasdas.jpg','fileName':' dasdas.jpg'}]");
		paramsMap.put("prm_applyfrom", "3");
		paramsMap.put("prm_aae036", "20151124105823");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			System.out.println(paramString);
			// 本地（数据交换共享平台）
			//result=request.post("http://localhost:8081/shebao/sentSubmitInfo", paramString, null);
			// 测试(数据交换共享平台)
			result=request.post("http://172.16.10.75:8081/shebao/sentSubmitInfo", paramString, null);
			// 生产(数据交换共享平台)
			//result=request.post("http://59.203.153.116:8081/shebao/sentSubmitInfo", paramString, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		System.out.println(result);		
		
	}
	
}
