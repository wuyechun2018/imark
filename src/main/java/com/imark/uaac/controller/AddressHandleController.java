package com.imark.uaac.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyTree;
import com.imark.common.vo.JsonMsg;
import com.imark.uaac.service.AddressHandleService;

@Controller
@RequestMapping("/addressHandle")
public class AddressHandleController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressHandleController.class);
	
	@Autowired
	private AddressHandleService addressHandleService;
	
	
	/**
	 * 
	 * @Description：获取数据
	 *
	 * @date：2015-10-26 上午10:31:31
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getTreeList")
	@ResponseBody
	public List<EasyTree> getTreeList(HttpServletRequest  request){
		String pid=request.getParameter("id");
		String rootId="530";
		//编码
		String bm=request.getParameter("bm");
		if(!bm.equals("null")&&IUtil.isNotBlank(bm)){
			rootId=addressHandleService.getXzqIdByBm(bm);
		}
		
		if(IUtil.isBlank(pid)){
			//return addressService.getTreeList("523");
			//530
			return addressHandleService.getTreeList(rootId);
		}else{
			return addressHandleService.getChildList(pid);
		}
		
	}
	
	/**
	 * 
	 * @Description：获取街路巷或者自然村
	 *
	 * @date：2015-10-28 上午11:41:54
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getJlxOrZrc")
	@ResponseBody
	public List getJlxOrZrc(HttpServletRequest request){
		
		//街路巷(1)、自然村(2)
		String jlx=request.getParameter("jlx");
		//所在行政区编码
		String szxzq=request.getParameter("szxzq");
		
		if(jlx.equals("1")){
			//街路巷
			return addressHandleService.getJlxList(szxzq);
		}else{
			//自然村
			return addressHandleService.getZrcList(szxzq);
		}
		
	}
	
	/**
	 * 
	 * @Description：获取小区数据
	 *
	 * @date：2015-10-28 下午03:12:33
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getXiaoqu")
	@ResponseBody
	public List getXiaoqu(HttpServletRequest request){
		//所在行政区编码
		String szxzq=request.getParameter("szxzq");
		return addressHandleService.getXiaoquList(szxzq);
	}
	
	
	/**
	 * 
	 * @Description：获取地址基本信息
	 *
	 * @date：2015-10-28 下午03:12:33
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getBaseInfo")
	@ResponseBody
	public Object getBaseInfo(HttpServletRequest request){
		//所在行政区编码
		String szxzq=request.getParameter("szxzq");
		return addressHandleService.getBaseInfo(szxzq);
	} 
	
	
	/**
	 * 
	 * @Description：获取门牌号
	 *
	 * @date：2015-10-29 上午09:56:40
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getMph")
	@ResponseBody
	public Object getMph(HttpServletRequest request){
		//参照实体类型  L 街路巷  Z 自然村
	  	String 	czstlx=request.getParameter("czstlx");
		//参照实体ID 参照实体ID
		String czstid=request.getParameter("czstid");
		//依附实体类型  Q小区 ,J建筑物,F房间
		String yfstl=request.getParameter("yfstlx");
		//依附实体ID,即 小区ID
		String yfstid=request.getParameter("yfstid");
		return addressHandleService.getMph(czstlx,czstid,yfstl,yfstid);	
		
	}
	
	
	/**
	 * 
	 * @Description：保存
	 *
	 * @date：2015-10-29 下午07:03:10
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Object save(HttpServletRequest request){
		
		//登录用户
		String user=request.getParameter("user");
		
		if(IUtil.isBlank(user)||user.equals("null")){
			user="sjz1";
		}
		
		//ID
		String addressId=request.getParameter("addressId");
		//标准地址
		String bzdz=request.getParameter("bzdz");
		//地址类型
		String dzlx=request.getParameter("dzlx");
		//行政区ID
		String xzqid=request.getParameter("xzqid");
		//行政区地名
		String xzqdm=request.getParameter("xzqdm");
		//街路巷1,自然村2
	    String addressType=request.getParameter("addressType");
	    //街路巷,自然村ID
	    String jlxOrZrcId=request.getParameter("jlxOrZrcId");
	    //街路巷,自然村全称
	    String jlxOrZrcQc=request.getParameter("jlxOrZrcQc");
	    //门牌号ID
	    String mphid=request.getParameter("mphid");
		//门牌号全称
	    String mphqc=request.getParameter("mphqc");
		//小区ID
	    String xqid=request.getParameter("xqid");
	    //小区全称
	    String xqqc=request.getParameter("xqqc");
	    //数据来源 1,公安,2,芜湖社管
	    String dataSource=request.getParameter("dataSource");
	    //详细地址
	    String xxdz=request.getParameter("xxdz");
	    //农业,非农业
		String censusType=request.getParameter("censusType");
		//联系方式
		String telgov=request.getParameter("telgov");
		
		Map map=new HashMap();
		map.put("bzdz", bzdz);
		map.put("dzlx", dzlx);
		map.put("xzqid", xzqid);
		map.put("xzqdm", xzqdm);
		map.put("addressType",addressType);
		map.put("jlxOrZrcId",jlxOrZrcId);
		map.put("jlxOrZrcQc", jlxOrZrcQc);
		map.put("mphid", mphid);
		map.put("mphqc", mphqc);
		map.put("xqid", xqid);
		map.put("xqqc",xqqc);
		map.put("dataSource", dataSource);
		map.put("xxdz", xxdz);
		map.put("telgov", telgov);
		map.put("censusType",censusType);
		map.put("addressId", addressId);
		
		
		
		if(IUtil.isNotBlank(addressId)){
			
			map.put("updateUser", user);
			map.put("updateTime", new Date());
			
			doLog("AddressController-save-更新",map);
			addressHandleService.update(map);
		}else{
			map.put("createUser", user);
			map.put("createTime", new Date());
			doLog("AddressController-save-新增",map);
			addressHandleService.save(map);
		}
		return new JsonMsg();
	}
	
	
	/**
	 * 
	 * @Description：打印日志信息
	 *
	 * @date：2015-11-2 下午12:59:00
	 *
	 * @author ：wuyechun
	 */
	public void doLog(String info,Map<String, Object> paramMap){
		logger.info("------------------"+info+"--------------------");
		for (Entry<String, Object> entry : paramMap.entrySet()) {
			logger.info(entry.getKey()+":"+entry.getValue());
	   }
		logger.info("--------------------------------------");
	}

}
