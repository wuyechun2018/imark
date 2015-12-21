package com.imark.uaac.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.imark.common.util.IUtil;
import com.imark.common.util.JdbcSupportDao;
import com.imark.common.vo.EasyPager;

@Component
public class LogDaoImpl extends JdbcSupportDao implements LogDao {

	/**
	 * 获取安全审计日志列表
	 * 
	 * @param name
	 * @param start
	 * @param end
	 * @return
	 */
	public List getSafeLoges(String name, String startDate, String endDate, Long startPos, Long endPos) {
		StringBuffer sqlBuffer = new StringBuffer("SELECT * FROM "
				   + "(SELECT T.*, ROWNUM RN FROM LOG_OPERATE_DETAIL@DBLINK_UAAC T WHERE 1=1 ");
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			startDate =IUtil.handleDateStr(startDate);
			sqlBuffer.append(" AND OPERATE_TIME >= '" + startDate + "'");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			endDate = IUtil.handleDateStr(endDate);
			sqlBuffer.append(" AND OPERATE_TIME <= '" + endDate + "'");
		}
		
		//用户名
		if(IUtil.isNotBlank(name)) {
			sqlBuffer.append(" AND USER_NAME LIKE '%" + name + "%'");
		}
		sqlBuffer.append(" ORDER BY OPERATE_TIME DESC ) WHERE ROWNUM <= " + endPos + " AND ROWNUM >= " + startPos);
		List<Map<String, Object>> logList = getJdbcTemplate().queryForList(sqlBuffer.toString());
		return logList;
	}
	
	/**
	 * 获取安全审计记录条数
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Long getSafeLogCount(String name, String startDate, String endDate) {
		StringBuffer sqlBuffer = new StringBuffer("SELECT COUNT(*) AS TOTAL FROM LOG_OPERATE_DETAIL@DBLINK_UAAC WHERE 1=1 ");
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			startDate =IUtil.handleDateStr(startDate);
			sqlBuffer.append(" AND OPERATE_TIME >= '" + startDate + "'");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			endDate = IUtil.handleDateStr(endDate);
			sqlBuffer.append(" AND OPERATE_TIME <= '" + endDate + "'");
		}
		
		//用户名
		if(IUtil.isNotBlank(name)) {
			sqlBuffer.append(" AND USER_NAME LIKE '%" + name + "%'");
		}
		//getJdbcTemplate().queryForMap("select * from LOG_OPERATE_DETAIL");
		Long total = getJdbcTemplate().queryForObject(sqlBuffer.toString(), Long.class);
		
		return total;
	}

	/**
	 * 
	 * @Description：单点登录日志记录总数
	 *
	 * @date：2015-10-20 下午04:14:33
	 *
	 * @author ：wuyechun
	 */
	public Long getSsoLogCount(String startDate, String endDate,
			String userName, String organizationName, String operateUrl) {
		
		StringBuffer sqlBuffer = new StringBuffer("SELECT COUNT(1) AS TOTAL FROM LOG_OPERATE_DETAIL@DBLINK_UAAC WHERE 1=1 ");
		
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			startDate =IUtil.handleDateStr(startDate);
			sqlBuffer.append(" AND OPERATE_TIME >= '" + startDate + "'");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			endDate = IUtil.handleDateStr(endDate);
			sqlBuffer.append(" AND OPERATE_TIME <= '" + endDate + "'");
		}
		
		//用户名
		if(IUtil.isNotBlank(userName)) {
			sqlBuffer.append(" AND USER_NAME LIKE '%" + userName + "%'");
		}
		
		//单位名称
		if(IUtil.isNotBlank(organizationName)) {
			sqlBuffer.append(" AND organization_name LIKE '%" + userName + "%'");
		}
		
		//平台地址
		if(IUtil.isNotBlank(operateUrl)) {
			sqlBuffer.append(" AND operate_url LIKE '%" + userName + "%'");
		}
		
		sqlBuffer.append(" AND OPERATE_TYPE IN('0','10')\n");
		
		return getJdbcTemplate().queryForObject(sqlBuffer.toString(), Long.class);
	}

	/**
	 * 
	 * @Description：单点登录日志记录-分页列表
	 *
	 * @date：2015-10-20 下午04:14:51
	 *
	 * @author ：wuyechun
	 */
	public List getSsoLogs(String startDate, String endDate, String userName,
			String organizationName, String operateUrl, EasyPager pager) {
		StringBuffer sqlBuffer = new StringBuffer("SELECT T.*, ROWNUM RN FROM LOG_OPERATE_DETAIL@DBLINK_UAAC T WHERE 1=1");
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			startDate =IUtil.handleDateStr(startDate);
			sqlBuffer.append(" AND OPERATE_TIME >= '" + startDate + "'\n");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			endDate = IUtil.handleDateStr(endDate);
			sqlBuffer.append(" AND OPERATE_TIME <= '" + endDate + "'\n");
		}
		
		//用户名
		if(IUtil.isNotBlank(userName)) {
			sqlBuffer.append(" AND USER_NAME LIKE '%" + userName + "%'\n");
		}
		
		//单位名称
		if(IUtil.isNotBlank(organizationName)) {
			sqlBuffer.append(" AND organization_name LIKE '%" + organizationName + "%'\n");
		}
		
		//平台地址
		if(IUtil.isNotBlank(operateUrl)) {
			sqlBuffer.append(" AND operate_url LIKE '%" + operateUrl + "%'\n");
		}
		
		//sqlBuffer.append(" AND (OPERATE_NAME LIKE '%登录%' OR OPERATE_NAME LIKE '%退出%') ORDER BY OPERATE_TIME DESC\n");
		
		sqlBuffer.append(" AND OPERATE_TYPE IN('0','10')  ORDER BY OPERATE_TIME DESC\n");
		
		String sql="SELECT * FROM ("+sqlBuffer.toString()+") WHERE ROWNUM >= " + pager.getStart() + " AND ROWNUM <= " + pager.getEnd();
		return getJdbcTemplate().queryForList(sql);
	}
	
	/**
	 * 安全审计日志图表数据的抽取
	 * @param startDate
	 * @param endDate
	 * @param pos
	 * @return
	 * @author lwzhang
	 */
	public List<Map<String, Object>> getSafeChart(String startDate, String endDate, int pos) {
		StringBuffer sqlBuffer 
			= new StringBuffer("SELECT SUBSTR(T.OPERATE_TIME, 0, "+ pos +") AS OPDATE, " +
						   "SUM(loginTotal) AS loginTotal, " +
					       "SUM(queryTotal) AS queryTotal, " +
					       "SUM(addTotal) AS addTotal, " +
					       "SUM(updateTotal) AS updateTotal," +
					       "SUM(delTotal) AS delTotal " +
					       "FROM (SELECT OPERATE_TIME, " +
					               "DECODE(OPERATE_TYPE, '0', 1, 0) AS loginTotal, " +
					               "DECODE(OPERATE_TYPE, '1', 1, 0) AS queryTotal, " +
					               "DECODE(OPERATE_TYPE, '2', 1, 0) AS addTotal, " +
					               "DECODE(OPERATE_TYPE, '3', 1, 0) AS updateTotal, " +
					               "DECODE(OPERATE_TYPE, '4', 1, 0) AS delTotal " +
					          "FROM LOG_OPERATE_DETAIL@DBLINK_UAAC WHERE 1=1 ");
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			sqlBuffer.append(" AND SUBSTR(OPERATE_TIME, 0, " + pos + " ) >= '" + startDate.replaceAll("-", "").substring(0,pos) + "'");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			sqlBuffer.append(" AND SUBSTR(OPERATE_TIME, 0, " + pos + " ) <= '" + endDate.replaceAll("-", "").substring(0,pos) + "'");
		}
		sqlBuffer.append(" ) T GROUP BY SUBSTR(T.OPERATE_TIME, 0, " + pos + ")");
		
		List<Map<String, Object>> logList = getJdbcTemplate().queryForList(sqlBuffer.toString());
		
		return logList;
	}

	/**
	 * 
	 * 方法描述：单点登录日志
	 * @param startDate
	 * @param endDate
	 * @param datePos
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public List<Map<String, Object>> getSsoChart(String startDate,
			String endDate, int datePos) {

		StringBuffer sqlBuffer 
			= new StringBuffer("SELECT SUBSTR(T.OPERATE_TIME, 0, "+ datePos +") AS OPDATE, " +
						   "SUM(loginTotal) AS loginTotal, " +
					       "SUM(loginOutTotal) AS loginOutTotal, " +
					       "SUM(delTotal) AS delTotal " +
					       "FROM (SELECT OPERATE_TIME, " +
					               "DECODE(OPERATE_TYPE, '0', 1, 0) AS loginTotal, " +
					               "DECODE(OPERATE_TYPE, '10', 1, 0) AS loginOutTotal, " +
					               "DECODE(OPERATE_TYPE, '4', 1, 0) AS delTotal " +
					          "FROM LOG_OPERATE_DETAIL@DBLINK_UAAC WHERE 1=1 ");
		//开始时间
		if(IUtil.isNotBlank(startDate)) {
			sqlBuffer.append(" AND SUBSTR(OPERATE_TIME, 0, " + datePos + " ) >= '" + startDate.replaceAll("-", "").substring(0,datePos) + "'");
		}
		
		//结束时间
		if(IUtil.isNotBlank(endDate)) {
			sqlBuffer.append(" AND SUBSTR(OPERATE_TIME, 0, " + datePos + " ) <= '" + endDate.replaceAll("-", "").substring(0,datePos) + "'");
		}
		sqlBuffer.append(" ) T GROUP BY SUBSTR(T.OPERATE_TIME, 0, " + datePos + ")");
		
		List<Map<String, Object>> logList = getJdbcTemplate().queryForList(sqlBuffer.toString());
		
		return logList;
	
	}
	
}
