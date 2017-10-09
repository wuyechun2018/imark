package com.imark.system.service.h2;

import com.imark.common.vo.EasyPager;
import com.imark.system.dao.SysLoginUserDao;
import com.imark.system.jpa.SysLoginUserJpaDao;
import com.imark.system.model.SysLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SysLoginUserService {

	@Autowired
	private SysLoginUserDao sysLoginUserDaoImpl;
	@Autowired
	private SysLoginUserJpaDao sysLoginUserJpaDao;
	
	

	/**
	 * @author wuyechun
	 * @param loginAccount
	 * @return
	 */
	public List<SysLoginUser> findByLoginAccount(String loginAccount) {
		
		//JdbcTemplate 查询
		return sysLoginUserDaoImpl.findByLoginAccount(loginAccount);
		
		//1、hibernate查询
		//两个单引号表示一个单引号
		//return baseDaoImpl.find(MessageFormat.format("FROM SysLoginUser WHERE loginAccount=''{0}''", loginAccount));
		
	}



	/**
	 * @author wuyechun
	 * @param loginAccount
	 * @return
	 */
	public List<SysLoginUser> findByMobilePhone(String mobilePhone) {

		//JdbcTemplate 查询
		return sysLoginUserJpaDao.findByMobilePhone(mobilePhone);

		//1、hibernate查询
		//两个单引号表示一个单引号
		//return baseDaoImpl.find(MessageFormat.format("FROM SysLoginUser WHERE loginAccount=''{0}''", loginAccount));

	}


	/**
	 * 
	 * 方法描述：获取列表数量
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getCount(Map param) {
		//String sql="SELECT COUNT(1) FROM SYS_LOGIN_USER";
		return sysLoginUserDaoImpl.getCount(param);
	}
	
	/**
	 * 
	 * 方法描述：获取列表数据
	 * @param pager
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public List getList(EasyPager pager,Map param) {
		return sysLoginUserDaoImpl.getList(pager,param);
	}


	/**
	 * 
	 * 方法描述：保存用户
	 * @param sysLoginUser 
	 * @exception 
	 * @author wuyechun
	 */
	public void save(SysLoginUser sysLoginUser) {
		List<SysLoginUser> list=sysLoginUserJpaDao.findByLoginPwd("123");
		sysLoginUserJpaDao.save(sysLoginUser);
	}


	/**
	 * 
	 * 方法描述：删除
	 * @param userId 
	 * @exception 
	 * @author wuyechun
	 */
	public void delete(String userId) {
		sysLoginUserDaoImpl.delete(userId);
		
	}


	
}
