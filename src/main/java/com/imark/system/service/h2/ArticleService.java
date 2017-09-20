package com.imark.system.service.h2;

import com.imark.common.util.SystemLog;
import com.imark.common.vo.EasyPager;
import com.imark.system.dao.ArticleDao;
import com.imark.system.jpa.ArticleJpaDao;
import com.imark.system.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ArticleService {

	@Autowired
	private ArticleJpaDao articleJpaDao;
	
	@Autowired
	private ArticleDao articleDaoImpl;
	
	/**
	 * 
	 * 方法描述：保存-使用hibernate
	 * @param article 
	 * @exception 
	 * @author wuyechun
	 */
	public void saveArticle(Article article) {
		articleJpaDao.save(article);
	}

	/**
	 * 
	 * 方法描述：获取数量
	 * @param param
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getCount(Map param) {
		return articleDaoImpl.getCount(param);
	}


	/**
	 * 
	 * 方法描述：getList
	 * @param pager
	 * @param param
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	//@SystemLog(module="主页面",methods="")
	public List getList(EasyPager pager, Map param) {
		return articleDaoImpl.getList(pager,param);
	}

	/**
	 * 
	 * 方法描述：getArticle
	 * @param articleId 
	 * @exception 
	 * @author wuyechun
	 */
	public Article getArticle(String articleId) {
		return articleJpaDao.findOne(articleId);
	}

	
	/**
	 * 
	 * 功能 :删除
	
	 * 开发：wuyechun 2016-2-16
	
	 * @param id
	 */
	public void delete(String ids) {
		String[] idArray=ids.split(",");
		for(int i=0;i<idArray.length;i++){
			articleJpaDao.delete(idArray[i]);
		}
	}

}
