package com.imark.system.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyGrid;
import com.imark.common.vo.EasyPager;
import com.imark.common.vo.JsonMsg;
import com.imark.system.model.Article;
import com.imark.system.service.FileService;
import com.imark.system.service.h2.ArticleService;
import com.imark.system.service.h2.SysLoginUserService;

@Controller
@RequestMapping("/editor")
public class EditorController extends BaseController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private SysLoginUserService sysLoginUserService;
	
	
	
	/**
	 * 
	 * 功能 :上传图片
	
	 * 开发：wuyechun 2016-2-23
	
	 * @return
	 * @throws FileUploadException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage")
	public void uploadImage(MultipartFile upload, HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IllegalStateException, IOException{
		
		 //MultipartHttpServletRequest multiPartRequest = (MultipartHttpServletRequest)request;
		 //MultipartFile multiPartFile = multiPartRequest.getFile("upload");
		 //boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		String fileName="";
		if (upload != null && upload.getSize() > 0) {
			String realPath = request.getSession().getServletContext().getRealPath("/upload/");
			
			fileName = upload.getOriginalFilename();
			String curDate=IUtil.getCurDateStr();
			fileName=fileService.combineFileName(fileName,curDate);
			
			File tarFile = new File(realPath, fileName);
			if (!tarFile.exists()) {
				tarFile.mkdirs();
			}
			
			upload.transferTo(tarFile);
		}
		
		String path=request.getContextPath();
		path=path+"/upload/"+fileName;
		
		String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
        PrintWriter out;
        String s = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+", '"+path+"');</script>";
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        out.print(s);
        out.flush();
	}
	
	
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
		
		String articleId=request.getParameter("articleId");
		String articleTitle=request.getParameter("articleTitle");
		String articleDesc=request.getParameter("articleDesc");
		String keyWord=request.getParameter("keyWord");
		String articleContent=request.getParameter("articleContent");
		String articleType=request.getParameter("articleType");
		
		article.setArticleId(articleId);
		article.setArticleTitle(articleTitle);
		article.setArticleDesc(articleDesc);
		article.setArticleContent(articleContent);
		article.setArticleType(articleType);
		article.setKeyWord(keyWord);
		
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
		ModelAndView mv=new ModelAndView("/showArticle");
		mv.addObject("article",article);
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
	@RequestMapping("/editArticle")
	public Object editArticle(String articleId){
		Article article=articleService.getArticle(articleId);
		ModelAndView mv=new ModelAndView("system/ckeditor");
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
	
	
	/***
	 * 
	 * 功能 :删除登录用户
	
	 * 开发：wuyechun 2016-1-18
	
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(HttpServletRequest request){
		String ids=request.getParameter("ids");
		articleService.delete(ids);
		return new JsonMsg();
	}
	
	
	

}
