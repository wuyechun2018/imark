package com.imark.system.service.h2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imark.system.jpa.AttachJpaDao;
import com.imark.system.model.Attach;

@Component
public class AttachService {
	
	@Autowired
	private AttachJpaDao attachJpaDao;
	
	
	/**
	 * 
	 * 功能 :保存附件
	
	 * 开发：wuyechun 2016-2-23
	
	 * @param attach
	 */
	public void save(Attach attach){
		attachJpaDao.save(attach);
	}


	public List<Attach> findByBizId(String bizId) {
		return attachJpaDao.findByBizId(bizId);
	}


	
	public Attach findById(String id) {
		return attachJpaDao.findOne(id);
	}

}
