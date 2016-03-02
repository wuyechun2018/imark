package com.imark.system.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;
import com.imark.system.model.SysMarkLogs;

@Component
public class MarkLogDaoImp extends JdbcSupportDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @Description：保存操作
	 *
	 * @date：2015-9-29 上午10:18:51
	 *
	 * @author ：wuyechun
	 */
	public void save(final SysMarkLogs markLogs) {
		getJdbcTemplate().update(
				"insert into SYS_MARK_LOGS(ID,MARK_TYPE,OP_DATE,BIZ_ID,BIZ_TYPE,BIZ_PARAM,BIZ_DESC,BIZ_STATUS,LOGIC_STATUS,OP_USER) \n" +
				"values(sys_guid(),?,?,?,?,?,?,?,?,?)",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1,markLogs.getMarkType());
						ps.setString(2,markLogs.getOpDate());
						ps.setString(3, markLogs.getBizId());
						ps.setString(4, markLogs.getBizType());
						ps.setString(5, markLogs.getBizParam());
						ps.setString(6,markLogs.getBizDesc());
						ps.setString(7,markLogs.getBizStatus());
						ps.setString(8,markLogs.getLogicStatus());
						ps.setString(9,markLogs.getOpUser());
					}
				});
	}

	/**
	 * 
	 * @Description：列表
	 *
	 * @date：2015-9-29 下午02:58:52
	 *
	 * @author ：wuyechun
	 */
	public List getList(String bizId, String bizType) {
		/**
		String sql="select *\n" +
			"  from SYS_MARK_LOGS t\n" + 
			" WHERE t.mark_type = '1' AND t.logic_status='0'\n" + 
			"   AND t.biz_id =?\n" + 
			"   AND t.biz_type =? ORDER BY t.OP_DATE DESC";
		List<Map<String, Object>> userList = getJdbcTemplate().queryForList(sql,new Object[] {bizId,bizType});
		return userList;
		***/
		
		String sql="SELECT * FROM SYS_MARK_LOGS T ORDER BY t.OP_DATE DESC";
		List<Map<String, Object>> userList = getJdbcTemplate().queryForList(sql);
		return userList;
		
	}

	
}
