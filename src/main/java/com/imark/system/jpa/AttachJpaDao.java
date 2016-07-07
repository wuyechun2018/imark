package com.imark.system.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.system.model.Attach;

public interface AttachJpaDao extends PagingAndSortingRepository<Attach, String>{

	List<Attach> findByBizId(String bizId);

}
