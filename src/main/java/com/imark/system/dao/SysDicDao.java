package com.imark.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;

@Component
public class SysDicDao extends JdbcSupportDao {

	/**
	 * 
	 * 功能 :查询子类别
	
	 * 开发：wuyechun 2016-3-15
	
	 * @param pid
	 * @param dicType
	 * @return
	 */
	public List<Map<String, Object>> getListByPid(String pid,String dicType) {
		String sql="SELECT * FROM SYS_DIC  T WHERE T.PID=? AND t.DIC_TYPE=? ORDER BY  T.DIS_ORDER";
		return getJdbcTemplate().queryForList(sql, new Object[]{pid,dicType});
	}

	/**
	 * 
	 * 功能 :查询子类别
	
	 * 开发：wuyechun 2016-3-22
	
	 * @param pid
	 * @return
	 */
	public List<Map<String, Object>> getListByPid(String pid) {
		String sql="SELECT * FROM SYS_DIC  T WHERE T.PID=? ORDER BY  T.DIS_ORDER";
		return getJdbcTemplate().queryForList(sql, new Object[]{pid});
	}

	/**
	 * 
	 * 功能 :根据字典编码获取下级字典项
	
	 * 开发：wuyechun 2016-3-22
	
	 * @param pDicCode
	 * @return
	 */
	public List<Map<String, Object>> getChildByPCode(String pDicCode) {
		String sql="SELECT * FROM SYS_DIC t WHERE T.PID IN(SELECT  s.id FROM SYS_DIC s WHERE s.dic_code=?1) ORDER BY T.DIS_ORDER";
		return getJdbcTemplate().queryForList(sql, new Object[]{pDicCode});
	}

}
