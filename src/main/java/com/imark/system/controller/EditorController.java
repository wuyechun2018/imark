package com.imark.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.common.vo.JsonMsg;
import com.imark.system.model.Article;
import com.imark.system.service.h2.ArticleService;
import com.imark.system.service.h2.SysLoginUserService;

@Controller
@RequestMapping("/editor")
public class EditorController extends BaseController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	
	/**
	 * 
	 * 方法描述：保存文章
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/saveArticle")
	public String saveArticle(HttpServletRequest request){
		showParam(request);
		Article article=new Article();
		String articleTitle=request.getParameter("articleTitle");
		String articleDesc=request.getParameter("articleDesc");
		String keyWord=request.getParameter("keyWord");
		String articleContent=request.getParameter("articleContent");
		String articleType=request.getParameter("articleType");
		
		article.setArticleTitle(articleTitle);
		article.setArticleContent(articleContent);
		article.setArticleType(articleType);
		
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		
		articleService.saveArticle(article);
		return "redirect:/views/system/article";
	}
	
	
	/**
	 * 
	 * 方法描述：显示
	 * @param articleId
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/showArticle")
	public Object showArticle(String articleId){
		Article article=articleService.getArticle(articleId);
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("article",article);
		return mv;
	}
	
	

	/**
	 * 
	 * 方法描述：list
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request){
		Map param=new HashMap();
		
		//获取分页信息
		EasyPager pager=getPager(request);
		Long total = articleService.getCount(param);
		List list=articleService.getList(pager,param);
		
		EasyGrid grid = new EasyGrid();
		grid.setTotal(total);
		grid.setRows(list);
		return grid;
	}
	
	
	

}
