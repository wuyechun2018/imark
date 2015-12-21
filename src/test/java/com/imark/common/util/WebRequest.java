package com.imark.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class WebRequest {
	private static final Logger LOG = Logger.getLogger(WebRequest.class);
	private static String LINE_SEPERATOR = System.getProperty("line.separator", "\n");
	private Map<String, String> cookies = new HashMap<String, String>();
	
	public String get(String url, Map<String, String> headers) throws MalformedURLException, IOException {
		return fetch(url, StringUtils.EMPTY, "GET", headers == null ? new HashMap<String, String>() : headers);
	}
	
	public String post(String url, String data, Map<String, String> headers) throws MalformedURLException, IOException {
		return fetch(url, data, "POST", headers == null ? new HashMap<String, String>() : headers);
	}

	@SuppressWarnings("unchecked")
	private String fetch(String url, String postData, String method, 
			Map<String, String> headers) throws MalformedURLException, IOException {
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Invoke http request:" + LINE_SEPERATOR + "Url: " + url + LINE_SEPERATOR + "Post data: " + postData);
		}
		
		StringBuilder output = new StringBuilder("");
		OutputStream outputStream = null;
		InputStream inputStream = null;
		
		try {
			URL urlObject = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)urlObject.openConnection();
			conn.setRequestMethod(method);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			// 设置链接读取和访问超时时间
			conn.setReadTimeout(8000);
			conn.setConnectTimeout(8000);
			
			appendHeaders(conn, headers);
			appendCookies(conn, cookies);
			
			if (!StringUtils.isEmpty(postData)) {
				conn.addRequestProperty("Content-Length", Integer.toString(postData.getBytes().length));
			}
			
			if (StringUtils.equalsIgnoreCase(method, "post")) {
				outputStream = conn.getOutputStream();
				String charset = getCharsetFromHeaders(headers);
				IOUtils.write(postData, outputStream, charset);
			}
			
			Map<String, String> responseHeaders = getHeaders(conn);
			cookies = getCookies(responseHeaders, cookies);
			
			String charset = getCharsetFromHeaders(responseHeaders);
			inputStream = conn.getInputStream();
			List<String> lines = IOUtils.readLines(inputStream, charset);
			
			headers.clear();
			headers.putAll(responseHeaders);
			
			for (String line : lines) {
				output.append(line).append(LINE_SEPERATOR);
			}
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("Receive response from server: " + LINE_SEPERATOR + output);
			}
			
			return output.toString();
		}
		finally {
			try { inputStream.close(); } catch (Exception e) { }
			try { outputStream.close(); } catch (Exception e) { }
		}
	}
	
	private Map<String, String> getHeaders(URLConnection connection) {
		Map<String, String> headers = new HashMap<String, String>();
		String key;
		int i = 1;
		while ((key = connection.getHeaderFieldKey(i)) != null) {
			String value = connection.getHeaderField(i); 
			headers.put(key, value);
			
			i++;
		}
		return headers;
	}

	private Map<String, String> getCookies(Map<String, String> headers, Map<String, String> cookies) {
		String key = "Set-Cookie";
		String header = headers.get(key);
		if (StringUtils.isEmpty(header)) {
			header = "";
		}
		StringTokenizer st = new StringTokenizer(header, ",");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			String cookie = s.substring(0, s.indexOf(";"));
			int j = cookie.indexOf("=");
			if (j != -1) {
				String cookieName = cookie.substring(0, j);
				String cookieValue = cookie.substring(j + 1);
				cookies.remove(cookieName);
				cookies.put(cookieName, cookieValue);
			}
		}
		return cookies;
	}

	private void appendHeaders(URLConnection connection, Map<String, String> headers) {
		if (headers != null) {
			for (Entry<String, String> header : headers.entrySet()) {
				connection.setRequestProperty(header.getKey(), header.getValue());
			}
		}
	}

	private void appendCookies(URLConnection connection, Map<String, String> cookies) {
		int i = 0;
		String s = "";
		for (Entry<String, String> entry : cookies.entrySet()) {
			s += entry.getKey() + "=" + entry.getValue();
			if (i < cookies.size() - 1) {
				s += ";";
			}
			i++;
		}
		
		if (!s.equals("")) {
			connection.setRequestProperty("Cookie", s);
		}
	}

	private String getCharsetFromHeaders(Map<String, String> headers) {
		String charset = "utf-8";
		
		if (!headers.containsKey("Content-Type")) {
			return charset;
		}
		
		String contentType = headers.get("Content-Type");
		
		String[] parts = StringUtils.split(contentType, ";");
		for (String part : parts) {
			String[] keyValue = StringUtils.split(part, "=");
			if (keyValue.length > 1) {
				String key = StringUtils.trim(keyValue[0]);
				String value = StringUtils.trim(keyValue[1]);
				if (StringUtils.equals(key, "charset")) {
					charset = value;
					break;
				}
			}
		}
	
		return charset;
	}
	
	
	/***
	 * 发送post请求，返回文件流。
	 * 
	 */
	public static InputStream sendPostFile(String url, String param) {
		InputStream is=null;
		PrintWriter out = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			// 设置链接读取和访问超时时间
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			is= conn.getInputStream();
		} catch (Exception e) {
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			if (out != null) {
				out.close();
			}
		}
		return is;
	}
	
	/**
	 * 访问uucenter接口的POST方法
	 * @param url
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public static String sendPost(String url, String param) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "application/json");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");


			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 设置链接读取和访问超时时间
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw new Exception("接口调用失败！ 原因：" + e.getMessage());
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
