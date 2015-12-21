package com.imark.system.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.system.model.SysLoginUser;

public interface SysLoginUserJpaDao extends PagingAndSortingRepository<SysLoginUser, String> {

}
