package com.imark.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imark.system.dao.MarkLogDaoImp;
import com.imark.system.model.SysMarkLogs;

@Transactional
@Component
public class MarkLogService {
	@Autowired
	private MarkLogDaoImp markLogDaoImp;

	/**
	 * 
	 * @Description：保存日志
	 * 
	 * @date：2015-9-29 上午10:22:16
	 * 
	 * @author ：wuyechun
	 */
	public void save(SysMarkLogs markLogs) {
		markLogDaoImp.save(markLogs);
	}

	/**
	 * 
	 * @Description：列表
	 *
	 * @date：2015-9-29 下午02:45:54
	 *
	 * @author ：wuyechun
	 */
	 @Transactional (propagation = Propagation.REQUIRED,readOnly=true)
	public List getList(String bizId, String bizType) {
		return markLogDaoImp.getList(bizId,bizType);
	}
	

}
