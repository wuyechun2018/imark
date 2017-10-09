package com.imark.system.jpa;

import com.imark.system.model.SysLoginUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SysLoginUserJpaDao extends PagingAndSortingRepository<SysLoginUser, String> {

	List<SysLoginUser> findByLoginPwd(String string);


	List<SysLoginUser> findByMobilePhone(String mobilePhone);
}
