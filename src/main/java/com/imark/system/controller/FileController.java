package com.imark.system.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imark.common.util.IUtil;
import com.imark.system.model.SysMarkLogs;
import com.imark.system.service.FileService;
import com.imark.system.service.MarkLogService;
import com.imark.system.vo.Iform;
import com.imark.system.vo.IformVo;

@Controller
@RequestMapping("/file")
public class FileController extends BaseController {
	
	@Autowired
	private FileService fileService;
	@Autowired
	private MarkLogService markLogService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public void upload(MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		if (file != null && file.getSize() > 0) {

			// request.getRealPath(""); 这个方法已经不推荐使用了
			// request.getSession().getServletContext().getRealPath(File.separator);得到项目的绝对路径
			
			String dept=request.getParameter("dept");
			String bizType=request.getParameter("bizType");
			
			String fileName = file.getOriginalFilename();
			String curDate=IUtil.getCurDateStr();
			fileName=fileService.combineFileName(fileName,curDate);
			
			
			/** 存储到本地
			String realPath = request.getSession().getServletContext().getRealPath("/updload/");
			File tarFile = new File(realPath, fileName);
			if (!tarFile.exists()) {
				tarFile.mkdirs();
			}**/
			
			String name=getUserInfo(request);

			try {
				//file.transferTo(tarFile);
				String remotePath=fileService.getRemotePath(bizType, dept, fileName);
				fileService.uploadToFTP(file.getInputStream(),remotePath);
				
				//上传后记录日志
				SysMarkLogs markLogs=new SysMarkLogs();
				markLogs.setMarkType("1");
				markLogs.setOpDate(IUtil.getCurDate());
				markLogs.setBizId(dept);
				markLogs.setBizType(bizType);
				markLogs.setBizParam(remotePath);
				markLogs.setBizDesc(fileName);
				markLogs.setOpUser(name);
				//保存至数据库
				markLogService.save(markLogs);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			writeMsg(response,"true","保存成功！");
		} else {
			writeMsg(response,"true","请选择要上传的文件！");
		}
		
		//return "上传成功";

	}
	
	

	/**
	 * 
	 * @Description：文件下载
	 *
	 * @date：2015-9-29 下午04:02:51
	 *
	 * @author ：wuyechun
	 * @throws IOException 
	 */
	@RequestMapping("/download")
	public void download(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String ftpPath=request.getParameter("path");
		String fileName=ftpPath.substring(ftpPath.lastIndexOf("/")+1, ftpPath.length());
		String fileType=ftpPath.substring(ftpPath.lastIndexOf(".")+1, ftpPath.length());
		
		if (("doc".equals(fileType) || "docx".equals(fileType))) {
			// word
			response.setContentType("application/vnd.ms-word;charset=UTF-8");
			//response.setHeader("Content-Disposition", "attachment;filename="+ fileName + "." + fileType);
			//文件名中已包含后缀
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GBK"),"iso-8859-1"));
		} else {
			// excel
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			//文件名中已包含后缀
			//response.setHeader("Content-Disposition", "attachment;filename="+ fileName + "." + fileType);
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GBK"),"iso-8859-1"));
		}
		InputStream is=fileService.download(ftpPath);
		byte[] buff=new byte[is.available()];
		is.read(buff);
		is.close();
		if(is!=null){
			//byte[] data=IUtil.toByteArray(is);
			response.getOutputStream().write(buff);
		}else{
			response.getOutputStream().write("".getBytes());
		}
		
	}
	
	
	/**
	 * 
	 * 方法描述：演示Form提交,多条记录提交
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping(value = "/indexSubmit")
	@ResponseBody
	public String indexSubmit(IformVo IformVo,HttpServletRequest request){
		//JSONArray.fromObject(IformVo);
		//System.out.println(IformVo.getFormList().size());
		for(int i=0;i<IformVo.getFormList().size();i++){
			Iform iform=IformVo.getFormList().get(i);
			System.out.println(iform.getBeizhu());
		}
		return "成功";
	}
	
	/**
	 * 一次编码
	 * http://localhost:5678/imark/file/testParam?keyword=%E6%96%B0%E5%BB%BA
	 * 二次编码
	 * http://localhost:5678/imark/file/testParam?keyword=%25E6%2596%25B0%25E5%25BB%25BA
	 * 测试参数获取
	 * @param request
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/testParam")
	@ResponseBody
	public String testParam(HttpServletRequest request) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("utf-8");
		System.out.println("value1:"+java.net.URLDecoder.decode(request.getParameter("keyword"),"UTF-8"));
		String keyword=new String(request.getParameter("keyword").getBytes("ISO-8859-1"), "utf-8");
		System.out.println("value2:"+keyword);
		return keyword;
	}
	

}
