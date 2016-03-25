package com.imark.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.vo.EasyPager;
import com.imark.common.vo.EasyTree;
import com.imark.system.model.Article;
import com.imark.system.service.h2.ArticleService;
import com.imark.system.service.h2.SysDicService;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private SysDicService sysDicService;
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/ifly")
	public Object ifly(String articleId){
		ModelAndView mv=new ModelAndView("/ifly");
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
	@RequestMapping("/index")
	public Object index(String articleId,HttpServletRequest request){
		
		EasyPager pager=new EasyPager();
		
		String curType=request.getParameter("curType");
		
		//获取要显示的文章类型
		List<EasyTree> typeList=sysDicService.getChildByPCode("WANL");
		
		
		Map param=new HashMap();
		param.put("articleType", "3");
		List list=articleService.getList(pager,param);
		
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("list", list);
		mv.addObject("typeList", typeList);
		//显示所有
		//mv.addObject("curType", curType==null?"":curType);
		//正常逻辑,显示第一类
		mv.addObject("curType", curType==null?typeList.get(0).getId():curType);
		return mv;
	}
	
	
	
	/**
	 * 
	 * 方法描述：显示 
	 * http://localhost:5678/imark/editor/showContent?articleId=40286f8151e8f03e0151eceb203a0003
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/showContent")
	public Object showContent(String articleId){
		
		//获取要显示的文章类型
		List<EasyTree> typeList=sysDicService.getChildByPCode("WANL");
		
		Article article=articleService.getArticle(articleId);
		ModelAndView mv=new ModelAndView("/showContent");
		mv.addObject("article",article);
		mv.addObject("typeList", typeList);
		return mv;
		
	}
	
	
	
	/**
	 * 
	 * 功能 :根据字典编码获取字典信息
	
	 * 开发：wuyechun 2016-3-24
	
	 * @return
	 */
	@RequestMapping("/getArticleListByType")
	@ResponseBody
	public Object getArticleListByType(String articleType){
		EasyPager pager=new EasyPager();
		Map param=new HashMap();
		param.put("articleType", articleType);
		List list=articleService.getList(pager,param);
		return list;
	}
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/nl")
	public Object nl(){
		EasyPager pager=new EasyPager();
		Map param=new HashMap();
		param.put("articleType", "3");
		List list=articleService.getList(pager,param);
		ModelAndView mv=new ModelAndView("/nl");
		mv.addObject("list", list);
		return mv;
	}
	

}
