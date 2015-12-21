package com.imark.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imark.system.dao.MarkLogDaoImp;
import com.imark.system.model.SysMarkLogs;
import com.imark.system.vo.XzcfVo;
import com.imark.system.vo.XzxkVo;

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
	 * 获取行政许可处理信息
	 * @return
	 */
	public List<XzxkVo> getXzxkList() {
		return markLogDaoImp.getXzxkList();
	}
	
	/**
	 * 获取行政处罚处理信息
	 * @return
	 */
	public List<XzcfVo> getXzcfList() {
		return markLogDaoImp.getXzcfList();
	}
	
	/***
	 * 
	 * @Description：列表统计
	 *
	 * @date：2015-10-9 下午02:41:04
	 *
	 * @author ：liuyu
	 * @return 
	 */
	public List getStatList() {
		return markLogDaoImp.getStatList();
	}
	
	/***
	 * 
	 * @Description：数字列表统计
	 *
	 * @date：2015-10-9 下午02:41:04
	 *
	 * @author ：liuyu
	 * @return 
	 */
	public List getStatList1() {
		return markLogDaoImp.getStatList1();
	}
	
	/**
	 * 导出报表
	 * 
	 * @param model
	 * @param date
	 * @param qxCode
	 * @return
	 * @throws Exception
	 */
	public List getGovernmentStateChart() {
		return markLogDaoImp.getGovernmentStateChart();
	}

}
