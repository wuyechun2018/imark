package com.imark.system.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.imark.common.util.IUtil;
import com.imark.common.util.JdbcSupportDao;
import com.imark.common.vo.EasyPager;
import com.imark.system.model.SysLoginUser;

@Component
public class SysLoginUserDao extends JdbcSupportDao{
	
	 
	/**
	 * 
	 * 功能 :根据登录账号查询
	
	 * 开发：wueychun 2015-6-5
	
	 * @return
	 */
	public List<SysLoginUser> findByLoginAccount(String loginAccount){
		
		//切换数据源
		//DBContextHolder.setDBType(Constant.DATA_SOURCE_THREE);
		
		String sql="SELECT t.user_id,\n" +
				 "       t.user_name,\n" + 
				 "       t.user_alias,\n" + 
				 "       t.user_code,\n" + 
				 "       t.sex,\n" + 
				 "       t.login_account,\n" + 
				 "       t.login_pwd,\n" + 
				 "       t.user_email,\n" + 
				 "       t.user_state,\n" + 
				 "       t.user_type,\n" + 
				 "       t.user_theme,\n" + 
				 "       t.memo\n" + 
				 "  FROM SYS_LOGIN_USER t WHERE t.login_account=?";
		
		
		List<SysLoginUser> userList =getJdbcTemplate().query(
		        sql,
		        new Object[]{loginAccount},
		        new LoginUserRowMapper());
		return userList;
	}
	
	class LoginUserRowMapper implements RowMapper<SysLoginUser>{
		@Override
		public SysLoginUser mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			SysLoginUser loginUser = new SysLoginUser();
        	loginUser.setUserId(rs.getString(1));
        	loginUser.setUserName(rs.getString(2));
        	loginUser.setUserAlias(rs.getString(3));
        	loginUser.setUserCode(rs.getString(4));
        	loginUser.setSex(rs.getString(5));
        	loginUser.setLoginAccount(rs.getString(6));
        	loginUser.setLoginPwd(rs.getString(7));
        	loginUser.setUserEmail(rs.getString(8));
        	loginUser.setUserState(rs.getString(9));
        	loginUser.setUserType(rs.getString(10));
        	loginUser.setUserTheme(rs.getString(11));
        	loginUser.setMemo(rs.getString(12));
            return loginUser;
		}
	 }

	/**
	 * 
	 * 方法描述：获取用户列表
	 * @param pager
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public List getList(EasyPager pager,Map<String, String>  param) {
		StringBuffer sqlBuff=new StringBuffer("SELECT t.user_id,\n" +
											 "       t.user_name,\n" + 
											 "       t.user_alias,\n" + 
											 "       t.user_code,\n" + 
											 "       t.sex,\n" + 
											 "       t.login_account,\n" + 
											 "       t.login_pwd,\n" + 
											 "       t.user_email,\n" + 
											 "       t.user_state,\n" + 
											 "       t.user_type,\n" + 
											 "       t.user_theme,\n" + 
											 "       t.memo\n" + 
											 "  ,ROWNUM RN FROM SYS_LOGIN_USER t WHERE 1=1 AND t.USER_STATE<>'D' ");
		
		if(IUtil.isNotBlank(param.get("loginAccount"))){
			sqlBuff.append(" AND LOGIN_ACCOUNT LIKE '%" + param.get("loginAccount") + "%'");
		}
		
		String sex=param.get("sex");
		
		if(IUtil.isNotBlank(sex)&&!sex.equals("3")){
			sqlBuff.append(" AND SEX = '" + param.get("sex") + "'");
		}
		
		String sql="SELECT * FROM ("+sqlBuff.toString()+") WHERE RN>=? AND RN<?";
		
		List<SysLoginUser> userList =getJdbcTemplate().query(
		        sql,
		        new Object[]{pager.getStart(),pager.getEnd()},
		        new LoginUserRowMapper());
		return userList;
	}

	/**
	 * 
	 * 方法描述：获取数量
	 * @param param
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getCount(Map<String, String> param) {
		StringBuffer sql=new StringBuffer("SELECT COUNT(1) FROM SYS_LOGIN_USER t WHERE 1=1 AND t.USER_STATE<>'D'\n");
		
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
	 * 方法描述：删除
	 * @param userId 
	 * @exception 
	 * @author wuyechun
	 */
	public void delete(String userId) {
		String sql="UPDATE SYS_LOGIN_USER T SET t.USER_STATE='D' WHERE t.USER_ID=?";
		getJdbcTemplate().update(sql,new Object[]{userId});
	}
	

}
