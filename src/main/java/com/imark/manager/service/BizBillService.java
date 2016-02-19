package com.imark.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imark.common.vo.EasyPager;
import com.imark.manager.dao.BizBillDao;


@Component
public class BizBillService {
	
	@Autowired
	private BizBillDao bizBillDao;

	/**
	 * 
	 * 功能 :总数
	
	 * 开发：wuyechun 2016-2-2
	
	 * @param param
	 * @return
	 */
	public Long getCount(Map param) {
		return bizBillDao.getCount(param);
	}

	/**
	 * 
	 * 功能 :列表数据
	
	 * 开发：wuyechun 2016-2-2
	
	 * @param pager
	 * @param param
	 * @return
	 */
	public List getList(EasyPager pager, Map param) {
		return bizBillDao.getList(pager,param);
	}

}
