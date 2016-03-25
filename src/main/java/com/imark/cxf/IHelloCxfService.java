package com.imark.cxf;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.imark.system.model.SysLoginUser;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IHelloCxfService {
	
	
	public String sum(int a,int b);

	public String toUpper(String srcStr);

	public String toLower(String srcStr);

	public SysLoginUserList getUserList();
	
	
	
	

}
