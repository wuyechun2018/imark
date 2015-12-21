package com.imark.system.dao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.imark.common.util.JdbcSupportDao;
import com.imark.common.vo.EasyPager;


@Component
public class ArticleDao extends JdbcSupportDao{

	/**
	 * 
	 * 方法描述：获取总数
	 * @param param
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getCount(Map param) {
		String sql="SELECT COUNT(1) FROM ARTICLE";
		return Long.valueOf(getJdbcTemplate().queryForObject(sql.toString(),Integer.class));
	}
	
	
	/**
	 * 
	 * 方法描述：获取列表
	 * @param pager
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public List getList(EasyPager pager,Map<String, String>  param) {
		StringBuffer sqlBuff=new StringBuffer("SELECT t.* ,ROWNUM RN FROM ARTICLE t WHERE 1=1");
		String sql="SELECT * FROM ("+sqlBuff.toString()+") WHERE ROWNUM>=? AND ROWNUM<=?";
		
		List<Map<String, Object>> userList =getJdbcTemplate().queryForList(
		        sql,new Object[]{pager.getStart(),pager.getEnd()});
		return userList;
	}
	
	

}
