package com.imark.system.controller;
import com.imark.common.sysdic.UserStateEnum;
import com.imark.common.util.IUtil;
import com.imark.common.util.UserCredentialsMatcher;
import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.common.vo.JsonMsg;
import com.imark.system.model.SysLoginUser;
import com.imark.system.service.h2.SysLoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************************************************************************
 *  功能说明: Imark-系统维护-用户管理 控制层
  
 *  2014-10-15 下午3:33:02 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2016-01-18 下午3:33:02 ycwu 创建文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysLoginUser")
public class SysLoginUserController extends BaseController{
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	/**
	 * 
	 * 方法描述：list
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request){
		
		//登录名
		String loginAccount=request.getParameter("loginAccount");
		//性别
		String sex=request.getParameter("sex");
		
		Map param=new HashMap();
		param.put("loginAccount",loginAccount);
		param.put("sex",sex);
		
		//获取分页信息
		EasyPager pager=getPager(request);
		Long total = sysLoginUserService.getCount(param);
		List list=sysLoginUserService.getList(pager,param);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}
	
	
	/**
	 * 
	 * 功能 :保存用户
	
	 * 开发：wuyechun 2016-1-18
	
	 * @param sysLoginUser
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(SysLoginUser sysLoginUser){

		//第一次新增操作，默认用户为注册状态
		if(IUtil.isBlank(sysLoginUser.getUserId())){
			sysLoginUser.setUserState(UserStateEnum.REGISTER.getCode()+"");
			//通过页面注册时，登录名为空，昵称有值，默认登录名和昵称保持一致
			if(IUtil.isBlank(sysLoginUser.getLoginAccount())){
				sysLoginUser.setLoginAccount(sysLoginUser.getUserAlias());
			}
		}

		if(IUtil.isBlank(sysLoginUser.getLoginPwd())){
			//默认密码 123
			sysLoginUser.setLoginPwd(UserCredentialsMatcher.GetMD5Str32(UserCredentialsMatcher.GetMD5Str32("123")));
		}else{
			sysLoginUser.setLoginPwd(UserCredentialsMatcher.GetMD5Str32(UserCredentialsMatcher.GetMD5Str32(sysLoginUser.getLoginPwd())));

		}
		sysLoginUserService.save(sysLoginUser);
		return new JsonMsg();
	}
	
	
	/***
	 * 
	 * 功能 :删除登录用户
	
	 * 开发：wuyechun 2016-1-18
	
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request){
		String userId=request.getParameter("userId");
		sysLoginUserService.delete(userId);
		return new JsonMsg();
	}
	
	

}
