package com.imark.system.service.h2;

import com.imark.common.util.SystemLog;
import com.imark.system.dao.MarkLogDaoImp;
import com.imark.system.model.SysMarkLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


	/**
	 * 记录用户访问主页面的日志，是访问日志，而非登录日志
	 * 这里什么也不做，只是为了在切面中记录日志
	 */
	@SystemLog(module="主页面",methods="")
	public void doSomeThing() {
	}
}
