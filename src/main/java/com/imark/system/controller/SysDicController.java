package com.imark.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.vo.JsonMsg;
import com.imark.system.model.SysDic;
import com.imark.system.service.h2.SysDicService;

/*******************************************************************************
 *  功能说明: Imark-系统维护-数据字典维护
  
 *  2014-10-15 下午3:33:02 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2016-01-18 下午3:33:02 ycwu 创建文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/sysDic")
public class SysDicController {
	
	@Autowired
	private SysDicService sysDicService;
	
	
	
	
	/***
	 * 
	 * 功能 :删除
	
	 * 开发：wuyechun 2016-1-18
	
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request){
		String id=request.getParameter("id");
		sysDicService.delete(id);
		return new JsonMsg();
	}
	
	
	/**
	 * 
	 * 功能 :保存
	
	 * 开发：wuyechun 2016-2-29
	
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(SysDic sysDic){
		sysDicService.save(sysDic);
		return new JsonMsg();
	}
	
	/**
	 * 
	 * 功能 :获取子菜单
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getChildList")
	@ResponseBody
	public Object getChildList(String pid){
		return sysDicService.getListByPid(pid);
	}
	
	
	/**
	 * 
	 * 功能 :获取子菜单
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getChildByPCode")
	@ResponseBody
	public Object getChildByPCode(String pDicCode){
		return sysDicService.getChildByPCode(pDicCode);
	}
	
	
	/**
	 * 
	 * 功能 :根据字典编码获取字典信息
	
	 * 开发：wuyechun 2016-3-24
	
	 * @return
	 */
	@RequestMapping("/getDicByCode")
	@ResponseBody
	public Object getDicByCode(String dicCode){
		return sysDicService.getDicByCode(dicCode);
	}
	
	

}
