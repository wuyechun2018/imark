package com.imark.system.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.system.model.Article;

public interface ArticleJpaDao extends PagingAndSortingRepository<Article, String>{

}