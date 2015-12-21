package com.imark.ws;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.imark.common.util.Base64Util;
import com.imark.common.util.IFileUtil;
import com.imark.common.util.WebRequest;

/**
 * 证照文库接口测试
 * @author lwzhang
 *
 */
public class ZzwkupTest {
	/**
	 * 主测试方法
	 * @param args
	 */
	public static void main(String args[]){
		// 1.证照类型-查询
		//getAllLicenseinType();
		
		// 2.基本信息-企业或个人查询（测试、生产）
		//getCertificatePorCInfo();
		
		// 3.基本信息-企业或个人查询（测试、生产）
		//getCertificatePandCInfo();
		
		// 4.基本信息-指定类型查询（测试、生产）
		//getCertificateInfoByContentCode();
		
		// 5.基本信息-防伪码查询（测试、生产）
		//getCertificateInfoBySecurityCode();
		
		// 6.指定内容信息查询（测试、生产）
		//getCertificateContentInfoByBySecurityCode();
		
		// 7.PDF格式文件下载（测试、生产）
		//downloadPDFfileByCode();
		
		// 8.IMG压缩下载
		//downloadImageZipFileByCode();
		
		// 9.IMG证照编号下载
		//downloadImagefileByCode();
		
		// 10.IMG身份证或组织机构或证照目录编码下载（生产）
		//downloadImagefileByContentCode();
	}
	
	/**
	 * 证照类型-查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getAllLicenseinType() {
		String postData="jsonStr={\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getAllLicenseinType", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getAllLicenseinType", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 基本信息-企业或个人查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getCertificatePorCInfo() {
		String postData="jsonStr={\"infoOwnerId\":\"110105196708190832\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getCertificatePorCInfo", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getCertificatePorCInfo", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		System.out.println(result);
	}
	
	/**
	 * 基本信息-企业和个人查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getCertificatePandCInfo() {
		String postData="jsonStr={\"infoOwnerIds\":[{\"paramItemsName\":\"infoOwnerId1\",\"paramItemsValue\":\"120102196602150712\"},{\"paramItemsName\":\"infoOwnerId2\",\"paramItemsValue\":\"110105196708190832\"},{\"paramItemsName\":\"infoOwnerId3\",\"paramItemsValue\":\"110107196809210620\"},{\"paramItemsName\":\"infoOwnerId4\",\"paramItemsValue\":\"110108197203118978\"},{\"paramItemsName\":\"infoOwnerId5\",\"paramItemsValue\":\"110227195611120052\"}],\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getCertificatePandCInfo", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getCertificatePandCInfo", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 基本信息-企业和个人查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getCertificateInfoByContentCode() {
		String postData="jsonStr={\"contentCode\":\"SGAJ340202\",\"infoOwnerId\":\"110105196708190832\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getCertificateInfoByContentCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getCertificateInfoByContentCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 基本信息-防伪码查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getCertificateInfoBySecurityCode() {
		String postData="jsonStr={\"md5\":\"33edca7f990be41ab8c8a33da9a9d6f2\",\"code\":\"SGAJ3402020000000453\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getCertificateInfoBySecurityCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getCertificateInfoBySecurityCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * 指定内容信息查询（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void getCertificateContentInfoByBySecurityCode() {
		String postData="jsonStr={\"md5\":\"33edca7f990be41ab8c8a33da9a9d6f2\",\"code\":\"SGAJ3402020000000453\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/getCertificateContentInfoByBySecurityCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/getCertificateContentInfoByBySecurityCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
	}
	
	/**
	 * PDF格式文件下载（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void downloadPDFfileByCode() {
		String postData="jsonStr={\"code\":\"SGAJ3402020000000453\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/downloadPDFfileByCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/downloadPDFfileByCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject jObj = JSONObject.fromObject(result);
		String fileBase64  = jObj.getString("data");
		byte[] decoderBytes = Base64Util.decode(fileBase64);
		try {
			IFileUtil.byteToFile(decoderBytes, "d:/pdfFile.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	/**
	 * IMG压缩下载（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void downloadImageZipFileByCode() {
		String postData="jsonStr={\"code\":\"SGAJ3402020000000453\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/downloadImageZipFileByCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/downloadImageZipFileByCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject jObj = JSONObject.fromObject(result);
		String fileBase64  = jObj.getString("data");
		byte[] decoderBytes = Base64Util.decode(fileBase64);
		try {
			IFileUtil.byteToFile(decoderBytes, "d:/imgZipFile.zip");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	/**
	 * IMG证照编号下载（测试、生产）
	 */
	@SuppressWarnings("static-access")
	public static void downloadImagefileByCode() {
		String postData="jsonStr={\"code\":\"SGAJ3402020000000453\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/downloadImagefileByCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/downloadImagefileByCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONObject jObj = JSONObject.fromObject(result);
		String fileBase64  = jObj.getString("data");
		byte[] decoderBytes = Base64Util.decode(fileBase64);
		try {
			IFileUtil.byteToFile(decoderBytes, "d:/jpgFile.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	/**
	 * IMG身份证或组织机构或证照目录编码下载（测试、生产）
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public static void downloadImagefileByContentCode() {
		String postData="jsonStr={\"contentCode\":\"SMZJ340203\",\"infoOwnerId\":\"120106198102120597\",\"reqStr\":{\"bizCode\":\"\",\"bizName\":\"芜湖市认证中心\"}}";
		WebRequest request=new WebRequest();
		String result = null;
		try {
			// 本地（数据交换平台）
			result=request.post("http://59.203.153.116:8081/zzwkup/downloadImagefileByContentCode", postData, null);
			// 测试(证照文库)
			//result=request.post("http://172.16.10.45:8080/documentBase/interfaceService/downloadImagefileByContentCode", postData, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject jObj = JSONObject.fromObject(result);
		// 获取多条图片信息
		JSONArray fileArrBase64 = jObj.getJSONArray("data");
		// 遍历多条图片信息
		for(Object obj : fileArrBase64.toArray()) {
			JSONObject subJObj = JSONObject.fromObject(obj);
			byte[] decoderBytes = Base64Util.decode(subJObj.getString("fileContent"));
			try {
				IFileUtil.byteToFile(decoderBytes, "d:/jpgFile"+ new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) +".jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
	}
}
