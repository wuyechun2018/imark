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
import com.imark.uaac.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressService addressService;
	
	
	
	
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
		//芜湖市 编码
		String rootId="3402";
		//传入的编码
		String bm=request.getParameter("bm");
		if(!bm.equals("null")&&IUtil.isNotBlank(bm)){
			rootId=bm;
		}
		if(IUtil.isBlank(pid)){
			//编码为空，第一次加载数据
			return addressService.getTreeList(rootId);
		}else{
			logger.info("父节点："+pid);
			return addressService.getChildList(pid);
		}
		//如果上级编码为4位，则获取方式为	SELECT * FROM loc_area s WHERE s.area_type='3' ORDER BY s.area_code;
		//如果上级编码为6位，则获取方式为    SELECT * FROM loc_area s WHERE s.area_type='2' AND substr(s.area_code,1,6)='340202' ORDER BY s.id ;
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
			return addressService.getJlxList(szxzq);
		}else{
			//自然村
			return addressService.getZrcList(szxzq);
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
		return addressService.getXiaoquList(szxzq);
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
		//所在行政区ID
		String szxzq=request.getParameter("szxzq");
		return addressService.getBaseInfo(szxzq);
	} 
	
	
	/**
	 * 
	 * @Description：获取地址基本信息
	 *
	 * @date：2015-10-28 下午03:12:33
	 *
	 * @author ：wuyechun
	 */
	@RequestMapping("/getBaseInfoByAreaCode")
	@ResponseBody
	public Object getBaseInfoByAreaCode(HttpServletRequest request){

		//所在行政区编码
		String areaCode=request.getParameter("areaCode");
		if(IUtil.isNotBlank(areaCode)&&areaCode.length()==9){
			areaCode=areaCode+"000";
		}
		
		return addressService.getBaseInfoByAreaCode(areaCode);
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
		return addressService.getMph(czstlx,czstid,yfstl,yfstid);	
		
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
		//行政编码
		String areaCode=request.getParameter("areaCode");
		
		//新增街路巷或自然村
		String isJlxAdd=request.getParameter("isJlxAdd");
		//新增小区
		String isXqAdd=request.getParameter("isXqAdd");
	
		if(isJlxAdd.equals("true")){
			boolean isJlxExist=addressService.isJlxExist(xzqid,areaCode,addressType,jlxOrZrcQc);
			if(isJlxExist){
				return new JsonMsg(true,"已存在该街路巷或自然村,请重新选择。");
			}else{
				jlxOrZrcId= addressService.saveJlx(xzqid,areaCode,addressType,jlxOrZrcQc);
			}
		}
		
		if(isXqAdd.equals("true")){
			boolean isXqExist=addressService.isXqExist(xzqid,areaCode,xqqc);
			if(isXqExist){
				return new JsonMsg(true,"已存在该小区,请重新选择。");
			}else{
				xqid=addressService.saveXiaoqu(xzqid,areaCode,xqqc);
			}
		}
		
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
		map.put("areaCode", areaCode);
		
		
		
		if(IUtil.isNotBlank(addressId)){
			
			map.put("updateUser", user);
			map.put("updateTime", new Date());
			
			doLog("AddressController-save-更新",map);
			addressService.update(map);
		}else{
			map.put("createUser", user);
			map.put("createTime", new Date());
			doLog("AddressController-save-新增",map);
			addressService.save(map);
		}
		return new JsonMsg();
	}
	
	
	/**
	 * 
	 * 方法描述：街路巷 保存方法
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/jieLuXiangsave")
	@ResponseBody
	public Object jieLuXiangsave(HttpServletRequest request){
		String addressType=request.getParameter("addressType");
		String addressValue=request.getParameter("addressValue");
		String xzqId=request.getParameter("xzqId");
		String xzqCode=request.getParameter("xzqId");
		
		Map map=new HashMap();
		map.put("addressType", addressType);
		map.put("addressValue", addressValue);
		map.put("xzqId", xzqId);
		map.put("xzqCode", xzqCode);
		
		addressService.saveJieluxiang(map);
		
		return new JsonMsg();
	}
	
	
	/**
	 * 
	 * 方法描述：小区 保存方法
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	@RequestMapping("/xiaoQuSave")
	@ResponseBody
	public Object xiaoQuSave(HttpServletRequest request){
		String addressType=request.getParameter("addressType");
		String addressValue=request.getParameter("addressValue");
		String xzqId=request.getParameter("xzqId");
		String xzqCode=request.getParameter("xzqId");
		
		Map map=new HashMap();
		map.put("addressType", addressType);
		map.put("addressValue", addressValue);
		map.put("xzqId", xzqId);
		map.put("xzqCode", xzqCode);
		
		addressService.saveXiaoQu(map);
		
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
