package com.imark.system.dao;

import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;

@Component
public class FileDao extends JdbcSupportDao{
	
	/**
	 * 文件入库状态修改
	 * @param filePath
	 */
	public void updateBizStatus(String bizParam) {
		getJdbcTemplate().update("update sys_mark_logs t set t.biz_status = '1' where biz_param = '" + bizParam + "'");
	}
}
