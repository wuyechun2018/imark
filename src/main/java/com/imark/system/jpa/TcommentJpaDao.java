package com.imark.system.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.system.model.Tcomment;

public interface TcommentJpaDao extends PagingAndSortingRepository<Tcomment, String>{

}
