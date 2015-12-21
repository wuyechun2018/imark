package com.imark.ws;

import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;
import com.imark.common.util.WebRequest;

/**
 * 住建委接口的封装
 * @author lwzhang
 *
 */
public class ZjwupTest {
	public static void main(String[] args) {
		// 1.文件的更新或保存
		//fileFsInsertOrUpdate();
		// 2.文件的删除
		//fileFsDelete();
		// 3.文件的查询
		//fileFsDataSet();
		// 4.文件的查询（范围）
		//fileFsRecord();
		
		// 5.住建委-线上预受理信息的更新或插入
		onlineApplyInsertOrUpdate();
		// 6.住建委-线上预受理信息的删除
		//onlineApplyDelete();
		// 7.住建委-线上预受理信息的查询
		onlineApplyDataSet();
		// 8.住建委-线上预受理信息的查询（范围）
		//onlineApplyRecord();
		
		// 9.住建委-申请人信息的更新或插入
		//proposerFsInsertOrUpdate();
		// 10.住建委-申请人信息的删除
		//proposerFsDelete();
		// 11.住建委-申请人信息的查询
		//proposerFsDataSet();
		// 12.住建委-申请人信息的查询（范围）
		//proposerFsRecord();
		
		// 13.证书的更新或保存
		//realtycerfsInsertOrUpdate();
		// 14.证书的删除
		//realtycerfsDelete();
		// 15.证书的查询
		//realtycerfsDataSet();
		// 16.证书的查询（范围）
		//realtycerfsRecord();
	}
	
	/**
	 * 住建委-文件的更新或插入（测试、生产）
	 */
	public static void fileFsInsertOrUpdate() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("UNID", "061");
		paramsMap.put("PROJID", "006");
		paramsMap.put("FILE_TYPE", "006");
		paramsMap.put("FILE_NAME", "FILE_NAME006");
		paramsMap.put("DATUM_NAME", "DATUM_NAME006");
		paramsMap.put("DATUM_ID", "DATUM_ID006");
		paramsMap.put("FILE_PATH", "FILE_PATH006");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result=request.post("http://localhost:8081/zjwup/fileFsInsertOrUpdate", paramString, null);
			// 测试(数据交换共享平台)
			//result=request.post("http://172.16.10.75:8081/zjwup/fileFsInsertOrUpdate", paramString, null);
			// 生产(数据交换共享平台)
			//result=request.post("http://59.203.153.116:8081/zjwup/fileFsInsertOrUpdate", paramString, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-文件的删除（测试、生产）
	 */
	public static void fileFsDelete() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("PROJID", "002");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://localhost:8081/zjwup/fileFsDelete", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/fileFsDelete", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/fileFsDelete", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-文件的查询（测试、生产）
	 */
	public static void fileFsDataSet() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where UNID = '061'");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://localhost:8081/zjwup/fileFsDataSet", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/fileFsDataSet", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/fileFsDataSet", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-文件的查询-范围（测试、生产）
	 */
	public static void fileFsRecord() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where 1=1");
		paramsMap.put("startRecord", "0");
		paramsMap.put("maxRecords", "2");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		System.out.println(paramString);
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/fileFsRecord", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/fileFsRecord", paramsMap);
			// 生产(数据交换共享平台)
			result = request.get("http://59.203.153.116:8081/zjwup/fileFsRecord", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-线上预受理信息的更新或插入（测试、生产）
	 */
	public static void onlineApplyInsertOrUpdate() {
		System.out.println("住建委-线上预受理信息的更新或插入");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("UNID", "211");
		paramsMap.put("PROJID", "211");
		paramsMap.put("OPERATION_TYPE", "211");
		paramsMap.put("OPERATION_DATE", "2012-03-15 14:00:00");
		paramsMap.put("OPERATION_NAME", "211");
		paramsMap.put("OPERATION_DESC", "211");
		paramsMap.put("APPROVAL_NAME", "211");
		paramsMap.put("APPROVAL_STRARDATE", "2012-03-15 14:00:00");
		paramsMap.put("APPROVAL_STAFFDATE", "2012-03-15 14:00:00");
		paramsMap.put("APPROVAL_STATUS", "1");
		paramsMap.put("APPROVAL_DESC", "211");
		paramsMap.put("APPROVAL_ENDDATE", "2012-03-15 14:00:00");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		System.out.println(paramString);
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result=request.post("http://localhost:8081/zjwup/onlineApplyInsertOrUpdate", paramString, null);
			// 测试(数据交换共享平台)
			result=request.post("http://172.16.10.75:8081/zjwup/onlineApplyInsertOrUpdate", paramString, null);
			// 生产(数据交换共享平台)
			//result=request.post("http://59.203.153.116:8081/zjwup/onlineApplyInsertOrUpdate", paramString, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-线上预受理信息的删除（测试、生产）
	 */
	public static void onlineApplyDelete() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("UNID", "211");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/onlineApplyDelete", paramsMap);
			// 测试(数据交换共享平台)
			result = request.get("http://172.16.10.75:8081/zjwup/onlineApplyDelete", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/onlineApplyDelete", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-线上预受理信息的查询（测试、生产）
	 */
	public static void onlineApplyDataSet() {
		System.out.println("线上预受理信息的查询");
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where PROJID = '099'");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://172.16.10.75:8081/zjwup/onlineApplyDataSet", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/onlineApplyDataSet", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/onlineApplyDataSet", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-线上预受理信息的查询-范围（测试、生产）
	 */
	public static void onlineApplyRecord() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where 1=1");
		paramsMap.put("startRecord", "0");
		paramsMap.put("maxRecords", "2");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/onlineApplyRecord", paramsMap);
			// 测试(数据交换共享平台)
			result = request.get("http://172.16.10.75:8081/zjwup/onlineApplyRecord", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/onlineApplyRecord", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-申请人信息的更新或插入（测试、生产）
	 */
	public static void proposerFsInsertOrUpdate() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("UNID", "056");
		paramsMap.put("PROJID", "056");
		paramsMap.put("APPLYPROPERTY", "056");
		paramsMap.put("APPLYNAME", "test1");
		paramsMap.put("APPLYTYPE", "1");
		paramsMap.put("APPLY_CARDTYPE", "056");
		paramsMap.put("APPLY_CARDNUMBER", "056");
		paramsMap.put("TELPHONE", "18099998888");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result=request.post("http://localhost:8081/zjwup/proposerFsInsertOrUpdate", paramString, null);
			// 测试(数据交换共享平台)
			//result=request.post("http://172.16.10.75:8081/zjwup/proposerFsInsertOrUpdate", paramString, null);
			// 生产(数据交换共享平台)
			//result=request.post("http://59.203.153.116:8081/zjwup/proposerFsInsertOrUpdate", paramString, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-申请人信息的删除（测试、生产）
	 */
	public static void proposerFsDelete() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("PROJID", "056");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://localhost:8081/zjwup/proposerFsDelete", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/proposerFsDelete", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/proposerFsDelete", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-申请人信息的查询（测试、生产）
	 */
	public static void proposerFsDataSet() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where UNID = '056'");
		//paramsMap.put("whereSqlString", "where 1=1");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/proposerFsDataSet", paramsMap);
			// 测试(数据交换共享平台)
			result = request.get("http://172.16.10.75:8081/zjwup/proposerFsDataSet", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/proposerFsDataSet", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-申请人信息的查询-范围（测试、生产）
	 */
	public static void proposerFsRecord() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where 1=1");
		paramsMap.put("startRecord", "0");
		paramsMap.put("maxRecords", "2");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/proposerFsRecord", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/proposerFsRecord", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/proposerFsRecord", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-证书的更新或插入（测试、生产）
	 */
	public static void realtycerfsInsertOrUpdate() {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("UNID", "066");
		paramsMap.put("PROJID", "066");
		paramsMap.put("CERTTYPE", "1");
		paramsMap.put("CERTCODE", "001");
		
		String paramString = JSONArray.fromObject(paramsMap).getString(0).toString(); 
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result=request.post("http://localhost:8081/zjwup/realtycerfsInsertOrUpdate", paramString, null);
			// 测试(数据交换共享平台)
			//result=request.post("http://172.16.10.75:8081/zjwup/realtycerfsInsertOrUpdate", paramString, null);
			// 生产(数据交换共享平台)
			//result=request.post("http://59.203.153.116:8081/zjwup/realtycerfsInsertOrUpdate", paramString, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-证书的删除（测试、生产）
	 */
	public static void realtycerfsDelete() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("PROJID", "11");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			//result = request.get("http://localhost:8081/zjwup/realtycerfsDelete", paramsMap);
			// 测试(数据交换共享平台)
			result = request.get("http://172.16.10.75:8081/zjwup/realtycerfsDelete", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/realtycerfsDelete", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-证书的查询（测试、生产）
	 */
	public static void realtycerfsDataSet() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where UNID = '056'");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://localhost:8081/zjwup/realtycerfsDataSet", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/realtycerfsDataSet", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/realtycerfsDataSet", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 住建委-证书的查询-范围（测试、生产）
	 */
	public static void realtycerfsRecord() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("whereSqlString", "where 1=1");
		paramsMap.put("startRecord", "0");
		paramsMap.put("maxRecords", "2");
		
		WebRequest request=new WebRequest();
		Object result = null;
		try {
			// 本地（数据交换共享平台）
			result = request.get("http://localhost:8081/zjwup/realtycerfsRecord", paramsMap);
			// 测试(数据交换共享平台)
			//result = request.get("http://172.16.10.75:8081/zjwup/realtycerfsRecord", paramsMap);
			// 生产(数据交换共享平台)
			//result = request.get("http://59.203.153.116:8081/zjwup/realtycerfsRecord", paramsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
}
