package com.imark.common.util;

/**
 * 
 * 
 * DBContextHolder
 * 
 * 2015-9-28 下午10:42:05
 * 
 * @version 1.0.0
 *
 */
public class DBContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setDBType(String dbType) {
        contextHolder.set(dbType);
    }
    public static String getDBType() {
        return (String) contextHolder.get();
    }
    public static void clearDBType() {
        contextHolder.remove();
    }

}
