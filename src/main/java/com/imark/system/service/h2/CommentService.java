package com.imark.system.service.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imark.system.jpa.TcommentJpaDao;
import com.imark.system.model.Tcomment;

@Component
public class CommentService {
	
	@Autowired
	private TcommentJpaDao commentJpaDao;
	
	public void save(Tcomment tcomment){
		commentJpaDao.save(tcomment);
	}
	

}
