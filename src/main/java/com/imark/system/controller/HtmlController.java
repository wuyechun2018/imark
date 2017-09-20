package com.imark.system.controller;

import com.imark.common.vo.EasyPager;
import com.imark.common.vo.EasyTree;
import com.imark.system.model.Article;
import com.imark.system.service.h2.ArticleService;
import com.imark.system.service.h2.MarkLogService;
import com.imark.system.service.h2.SysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private SysDicService sysDicService;


	@Autowired
	private MarkLogService markLogService;
	
	
	/**
	 * 主页面 http://localhost:5678/imark/html/ifly
	 * 内容页面 http://localhost:5678/imark/html/content  演示了 ztree的使用
	 * 方法描述：跳转到开放平台演示主页面
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
	 * 方法描述：网站主页面，样式参考 "有意思吧"
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/index")
	//@SystemLog(module="主页面",methods="")
	public Object index(String articleId,HttpServletRequest request){

		markLogService.doSomeThing();

		
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
