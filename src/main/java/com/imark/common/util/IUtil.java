package com.imark.common.util;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IUtil {
	
	/**
	 * 
	 * @Description：获取当前时间串,精确到毫秒yyyyMMddHHmmssSSS
	 *
	 * @date：2015-9-28 下午03:06:12
	 *
	 * @author ：wuyechun
	 */
	public static String getCurDateStr(){
		Date curDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(curDate);
	}
	
	
	public static String getCurDate(){
		Date curDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(curDate);
	}
	
	
	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true 
	 * StringUtils.isBlank("")        = true 
	 * StringUtils.isBlank(" ")       = true 
	 * StringUtils.isBlank("bob")     = false 
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isBlank(String) to
	 *        isBlank(CharSequence)
	 */
	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(cs.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <p>
	 * Checks if a CharSequence is not empty (""), not null and not whitespace
	 * only.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.isNotBlank(null)      = false 
	 * StringUtils.isNotBlank("")        = false 
	 * StringUtils.isNotBlank(" ")       = false 
	 * StringUtils.isNotBlank("bob")     = true 
	 * StringUtils.isNotBlank("  bob  ") = true
	 * </pre>
	 * 
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is not empty and not null and
	 *         not whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isNotBlank(String) to
	 *        isNotBlank(CharSequence)
	 */
	public static boolean isNotBlank(CharSequence cs) {
		return !isBlank(cs);
	}
	
	/***
	 * 
	 * 功能 :去除换行
	
	 * 开发：ycwu 2014-10-29
	
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\r|\n|\t");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	/**
	 * 
	 * @Description：Inputstream转byte[]
	 *
	 * @date：2015-9-29 下午04:48:41
	 *
	 * @author ：wuyechun
	 */
	public static byte[] toByteArray(InputStream input) throws IOException {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[4096];
	    int n = 0;
	    while (-1 != (n = input.read(buffer))) {
	        output.write(buffer, 0, n);
	    }
	    return output.toByteArray();
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }
	
	
	/**
	 * 
	 * @Description：处理时间串
	 *
	 * @date：2015-10-20 下午04:22:42
	 *
	 * @author ：wuyechun
	 */
	public static String handleDateStr(String src){
		//转换成时间串 如： 20151010121212 == 2015-10-10 12:12:12
		return src.replaceAll("-", "") + "000000";
	}


	/**
	 *
	 * 功能 :获取Ip地址

	 * 开发：wuyechun 2016-3-1

	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
