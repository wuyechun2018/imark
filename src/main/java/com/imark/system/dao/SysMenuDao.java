package com.imark.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;

@Component
public class SysMenuDao  extends JdbcSupportDao{

	/**
	 * 
	 * 功能 :获取子节点信息
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	public List<Map<String, Object>> getListByPid(String pid) {
		//String sql="SELECT * FROM SYS_MENU  T WHERE T.MENU_PID=?  AND T.IS_USE='Y'  ORDER BY  T.ORDER_NO";
		String sql="SELECT * FROM SYS_MENU  T WHERE T.MENU_PID=? ORDER BY  T.ORDER_NO";
		return getJdbcTemplate().queryForList(sql, new Object[]{pid});
	}

}
