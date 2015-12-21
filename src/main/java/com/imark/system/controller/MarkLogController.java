package com.imark.system.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.util.ExportExcel;
import com.imark.system.model.GovernmentState;
import com.imark.system.service.MarkLogService;

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
	
	/***
	 * 
	 * @Description：列表统计
	 *
	 * @date：2015-10-9 下午02:41:04
	 *
	 * @author ：liuyu
	 * @return 
	 */
	@RequestMapping("/statList")
	@ResponseBody
	public Map<String, Object> statList(HttpServletRequest request){
		
		//String bizId=request.getParameter("bizId");
		//String bizType=request.getParameter("bizType");
		
		List list=markLogService.getStatList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total",list.size());
		return map;
	}
	/***
	 * 
	 * @Description：数字列表统计
	 *
	 * @date：2015-10-9 下午02:41:04
	 *
	 * @author ：liuyu
	 * @return 
	 */
	@RequestMapping("/statList1")
	@ResponseBody
	public Map<String, Object> statList1(HttpServletRequest request){
		//String bizId=request.getParameter("bizId");
		//String bizType=request.getParameter("bizType");
		
		List list=markLogService.getStatList1();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total",list.size());
		return map;
	}
	
	/**
	 * 导出报表
	 * 
	 * @param model
	 * @param date
	 * @param qxCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/statList2")
	@ResponseBody
	public void getGovernmentStateExport(Model model, String date, String qxCode,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<GovernmentState> list = markLogService.getGovernmentStateChart();
		//model.addAttribute("list", list);

		String filename = "七天双公示考核统计报表";
		String[] headers = { "部门", "行政许可公开", "行政许可暂缓公开", "行政许可不公开", "行政许可合计", "行政处罚公开", "行政处罚暂缓公开", "行政处罚不公开", "行政处罚合计", "行政考核准时", "行政考核超时", "行政考核合计" };

		ExportExcel<GovernmentState> ex = new ExportExcel<GovernmentState>();
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment; filename=\"" + toUtf8String(filename) + ".xls\"");
		OutputStream out = response.getOutputStream();
		ex.exportExcel(headers, list, out);
		out.flush();
		out.close();
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}
