package com.imark.system.controller;

import com.imark.system.service.h2.MarkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 类名: MarkLogController
* 包名: com.imark.system.controller
* 描述: 操作日志
* 创建人: ycwu3
* 创建时间: 2017/9/19 11:43
**/
@Controller
@RequestMapping("/markLog")
public class MarkLogController {

	@Autowired
	private MarkLogService markLogService;


	/***
	 * 操作日志列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request){
		
		String bizId=request.getParameter("bizId");
		String bizType=request.getParameter("bizType");
		
		List list=markLogService.getList(bizId,bizType);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total",list.size());
		return map;
		
	}
	
}
