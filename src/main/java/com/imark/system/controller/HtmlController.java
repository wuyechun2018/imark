package com.imark.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imark.system.model.Article;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/index")
	public Object showArticle(String articleId){
		ModelAndView mv=new ModelAndView("/index");
		return mv;
	}

}
