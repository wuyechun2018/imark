package com.imark.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.vo.EasyPager;
import com.imark.system.service.h2.ArticleService;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
	@Autowired
	private ArticleService articleService;
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/index")
	public Object index(String articleId){
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}
	
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/content")
	public Object content(String articleId){
		ModelAndView mv=new ModelAndView("/content");
		return mv;
	}
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/nanling")
	public Object nanling(String articleId){
		
		EasyPager pager=new EasyPager();
		
		Map param=new HashMap();
		param.put("articleType", "3");
		
		List list=articleService.getList(pager,param);
		
		ModelAndView mv=new ModelAndView("/nanling");
		mv.addObject("list", list);
		
		return mv;
	}
	

}
