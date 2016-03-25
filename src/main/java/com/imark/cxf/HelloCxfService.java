package com.imark.cxf;

import java.util.ArrayList;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.imark.system.model.SysLoginUser;

@WebService
@SOAPBinding(style = Style.RPC)
public class HelloCxfService implements IHelloCxfService{

	@Override
	public String sum(int a, int b) {
		return String.valueOf(a+b);
	}
	
	
	@Override
	public String toUpper(String srcStr){
		return srcStr.toUpperCase();
	}
	
	@Override
	public String toLower(String srcStr){
		return srcStr.toLowerCase();
	}
	
	@Override
	public SysLoginUserList getUserList(){
		
		SysLoginUserList userList=new SysLoginUserList();
		ArrayList list=new ArrayList<SysLoginUser>();
		for(int i=0;i<5;i++){
			SysLoginUser user=new SysLoginUser();
			user.setLoginAccount("zhangsan"+i);
			user.setMemo("这是第"+i+"测试账号");
			user.setUserEmail("zhangsan"+i+"@163.com");
			list.add(user);
		}
		userList.setUserList(list);
		return userList;
	}

}
