package com.imark.manager.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.imark.common.util.IUtil;
import com.imark.common.util.JdbcSupportDao;
import com.imark.common.vo.EasyPager;

/*******************************************************************************
 *  功能说明: Imark-业务管理-账单管理-数据访问层-采用JdbcTemplate（复杂查询）
  
 *  2014-10-15 下午3:33:02 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2016-01-18 下午3:33:02 ycwu 创建文件
 * 
 ******************************************************************************/
@Component
public class BizBillDao extends JdbcSupportDao{

	/**
	 * 
	 * 功能 :获取数量
	
	 * 开发：wuyechun 2016-2-2
	
	 * @param param
	 * @return
	 */
	public Long getCount(Map<String, String> param) {
		StringBuffer sql=new StringBuffer("SELECT COUNT(1) FROM BIZ_BILL t WHERE 1=1 \n");
		
		if(IUtil.isNotBlank(param.get("loginAccount"))){
			sql.append(" AND LOGIN_ACCOUNT LIKE '%" + param.get("loginAccount") + "%'");
		}
		
		if(IUtil.isNotBlank(param.get("sex"))){
			sql.append(" AND sex = '" + param.get("sex") + "'");
		}
		return Long.valueOf(getJdbcTemplate().queryForObject(sql.toString(),Integer.class));
	}
	
	
	
	/**
	 * 
	 * 功能 :列表
	
	 * 开发：wuyechun 2016-2-2
	
	 * @param pager
	 * @param param
	 * @return
	 */
	public List getList(EasyPager pager,Map<String, String>  param) {
		StringBuffer sqlBuff=new StringBuffer("SELECT t.*,ROWNUM RN  FROM BIZ_BILL t");
		
		if(IUtil.isNotBlank(param.get("loginAccount"))){
			sqlBuff.append(" AND LOGIN_ACCOUNT LIKE '%" + param.get("loginAccount") + "%'");
		}
		
		String sex=param.get("sex");
		
		if(IUtil.isNotBlank(sex)&&!sex.equals("3")){
			sqlBuff.append(" AND SEX = '" + param.get("sex") + "'");
		}
		
		String sql="SELECT * FROM ("+sqlBuff.toString()+") WHERE ROWNUM>=? AND ROWNUM<?";
		
		List userList =getJdbcTemplate().queryForList(sql,new Object[]{pager.getStart(),pager.getEnd()});
		return userList;
	}


}
