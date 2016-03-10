package com.imark.system.dao.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.imark.system.model.SysLoginUser;

public interface SysLoginUserJpaDao extends PagingAndSortingRepository<SysLoginUser, String> {

	List<SysLoginUser> findByLoginPwd(String string);

}
