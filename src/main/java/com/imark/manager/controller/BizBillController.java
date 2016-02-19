package com.imark.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.manager.service.BizBillService;
import com.imark.system.controller.BaseController;


/*******************************************************************************
 *  功能说明: Imark-业务管理-账单管理
  
 *  2014-10-15 下午3:33:02 ycwu 创建文件
 * 
 *  修改说明: 创建文件

 *  2016-01-18 下午3:33:02 ycwu 创建文件
 * 
 ******************************************************************************/
@Controller
@RequestMapping("/bizBill")
public class BizBillController extends BaseController{
	
	@Autowired
	private BizBillService bizBillService;
	
	
	/**
	 * 
	 * 功能 :查询列表
	
	 * 开发：wuyechun 2016-2-2
	
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request){
		
		Map param=new HashMap();
		//获取分页信息
		EasyPager pager=getPager(request);
		Long total = bizBillService.getCount(param);
		List list=bizBillService.getList(pager,param);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}

}
