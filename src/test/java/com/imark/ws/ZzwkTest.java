package com.imark.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;

import com.imark.common.util.WebRequest;

/***
 * 
 * 
 * ZzwkTest 证照文库测试
 * 
 * 2015-10-22 上午09:49:10
 * 
 * @version 1.0.0
 * 
 */
public class ZzwkTest {

	public static void main(String[] args) {

		// logon();
		downloadLicenseFile();

	}

	/**
	 * 
	 * @Description：7.1 用户登录
	 * 
	 * @date：2015-10-22 上午09:51:22
	 * 
	 * @author ：wuyechun
	 */
	public static void logon() {
		String url = "http://localhost:8081/zzwk/logon";
		WebRequest webRequest = new WebRequest();
		String result = "";
		String postData = "jsonStr={\"password\":\"123321\",\"userName\":\"admin\",\"reqStr\":{\"bizCode\":\"001\",\"bizName\":\"APPSCAN\"}}";
		try {
			result = webRequest.post(url, postData, null);
			System.out.println(result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description：证照图片下载
	 * 
	 * @date：2015-10-22 上午09:58:25
	 * 
	 * @author ：wuyechun
	 */
	public static void downloadLicenseFile() {
		String url = "http://localhost:8081/zzwk/downloadLicenseFile";
		WebRequest webRequest = new WebRequest();
		String result = "";
		String postData = "jsonStr={\"code\":\"GAJ3402020000000003\",\"contentCode\":\"GAJ340202\",\"reqStr\":{\"bizCode\":\"001\",\"bizName\":\"APPSCAN\"}}";
		try {
			result = webRequest.post(url, postData, null);
			System.out.println(result);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description：将字符串写入指定文件
	 *
	 * @date：2015-10-22 上午10:14:50
	 *
	 * @author ：wuyechun
	 */
	public static boolean string2File(String res, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File distFile = new File(filePath);
			if (!distFile.getParentFile().exists()){
				distFile.getParentFile().mkdirs();
			}
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			// 字符缓冲区
			char buf[] = new char[1024*5]; 
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
			return flag;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @Description：文本文件转换为指定编码的字符串
	 *
	 * @date：2015-10-22 上午10:14:36
	 *
	 * @author ：wuyechun
	 */
	public static String file2String(File file, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding == null || "".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file),
						encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(file));
			}
			// 将输入流写入输出流
			char[] buffer = new char[1024];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return writer.toString();
	}

}
