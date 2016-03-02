package com.imark.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.system.service.h2.MarkLogService;

@Controller
@RequestMapping("/markLog")
public class MarkLogController {

	@Autowired
	private MarkLogService markLogService;
	
	/***
	 * 
	 * @Description：列表查询
	 *
	 * @date：2015-9-29 下午02:41:04
	 *
	 * @author ：wuyechun
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
