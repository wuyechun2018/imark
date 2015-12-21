package com.imark.uaac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyCombobox;
import com.imark.common.vo.EasyTree;
import com.imark.uaac.controller.AddressController;
import com.imark.uaac.dao.AddressDaoImpl;

@Transactional
@Component
public class AddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	private AddressDaoImpl addressDaoImpl;

	
	/**
	 * 
	 * @Description：获取树节点
	 *
	 * @date：2015-10-27 下午04:39:02
	 *
	 * @author ：wuyechun
	 */
	public List<EasyTree> getTreeList(String id) {
		List<Map<String, Object>> list=addressDaoImpl.getList(id);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("AREA_CODE").toString());
			tree.setText(obj.get("AREA_NAME").toString());
			tree.setState("closed");
			
			//获取行政区ID
			Map attr=new HashMap();
			attr.put("XZQID", getXzqId(obj.get("AREA_CODE").toString()));
			tree.setAttributes(attr);
			childList.add(tree);
		}
		return childList;
	}
	
	
	/**
	 * 从公安表中获取行政区ID
	 * @return
	 */
	public String getXzqId(String areaCode){
		//logger.info("src:"+areaCode);
		if(IUtil.isNotBlank(areaCode)){
			if(areaCode.length()==4){
				areaCode=areaCode+"00";
			}else if(areaCode.length()==9){
				areaCode=areaCode+"000";
			}
		}else{
			areaCode= "340200";
		}
		//logger.info("convert:"+areaCode);
		
		List<Map<String, Object>> list=addressDaoImpl.getXzqList(areaCode);
		if(!list.isEmpty()){
			//logger.info("tar:"+list.get(0).get("ID")+"");
			return list.get(0).get("ID")+"";
		}else{
			return "";
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @Description：获取子节点
	 *
	 * @date：2015-10-27 下午04:38:34
	 *
	 * @author ：wuyechun
	 */
	public List<EasyTree> getChildList(String pid) {
		List<Map<String, Object>> list=addressDaoImpl.getChildList(pid);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("AREA_CODE").toString());
			tree.setText(obj.get("AREA_NAME").toString());
			tree.setState(getFolderState(obj.get("AREA_CODE").toString()));
			
			//获取行政区ID
			String xzqId=getXzqId(obj.get("AREA_CODE").toString());
			Map attr=new HashMap();
			attr.put("XZQID",xzqId);
			tree.setAttributes(attr);
			childList.add(tree);
			
			boolean isHasBaseInfo=isHasBaseInfo(xzqId);
			//区县图标不做处理
			if(!isQuOrXian(obj.get("AREA_CODE").toString())){
				if(isHasBaseInfo){
					tree.setIconCls("itree-accept");
				}else{
					tree.setIconCls("itree-cancel");
				}
			}
			
			
		}
		return childList;
	}
	
	
	
	/**
	 * 
	 * @Description：是否含有子节点
	 *
	 * @date：2015-10-27 下午06:47:15
	 *
	 * @author ：wuyechun
	 */
	public boolean isHasChild(String pid){
		boolean hasChild=false;
		Long count=addressDaoImpl.getChildCount(pid);
		if(count>0){
			hasChild=true;
		}
		return hasChild;
	}
	
	
	/**
	 * 
	 * @Description：是否含有基本信息
	 *
	 * @date：2015-10-27 下午06:47:15
	 *
	 * @author ：wuyechun
	 */
	public boolean isHasBaseInfo(String xzqid){
		boolean hasChild=false;
		Long count=addressDaoImpl.isHasBaseInfo(xzqid);
		if(count>0){
			hasChild=true;
		}
		return hasChild;
	}
	
	
	/**
	 * 
	 * @Description：
	 *
	 * @date：2015-10-27 下午06:49:22
	 *
	 * @author ：wuyechun
	 */
	public String getFolderState(String areaCode){
		boolean hasChild=isHasChild(areaCode);
		if(hasChild){
			return "closed";
		}else{
			return "open";
		}
	}

	
	/***
	 * 
	 * @Description：获取街路巷数据
	 *
	 * @date：2015-10-28 下午01:58:22
	 *
	 * @author ：wuyechun
	 */
	public List<EasyCombobox> getJlxList(String szxzq) {
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		if(isQuOrXian(szxzq)){
			list=addressDaoImpl.getJlxList(szxzq);
		}else{
			//递归数据
			list=addressDaoImpl.getDgJlxList(szxzq);
			//去重复
			list=quChongFu(list);
		}
		List<EasyCombobox> jlxList=new ArrayList<EasyCombobox>();
		for (Map<String, Object> obj : list) {
			EasyCombobox combo=new EasyCombobox();
			combo.setId(obj.get("ID").toString());
			combo.setText(obj.get("JC").toString());
			jlxList.add(combo);
		}
		return jlxList;
		
	}

	/**
	 * 
	 * 方法描述：去除重复 
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public List<Map<String, Object>> quChongFu(List<Map<String, Object>> srcList){
		List<Map<String, Object>> tarList=new ArrayList<Map<String, Object>>();
		String preText="";
		for(Map<String, Object> obj : srcList){
			if(obj.get("JC")!=null){
				String text=obj.get("JC").toString();
				if(IUtil.isNotBlank(text)&&preText.equals(text)){
					continue;
				}else{
					tarList.add(obj);
				}
				preText=text;
			}
			
		}
		return tarList;
	}
	
	
	/**
	 * 
	 * @Description：获取自然村数据
	 *
	 * @date：2015-10-28 下午01:59:45
	 *
	 * @author ：wuyechun
	 */
	public List<EasyCombobox> getZrcList(String szxzq) {
		List<EasyCombobox> zrcList=new ArrayList<EasyCombobox>();
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		if(isQuOrXian(szxzq)){
			list=addressDaoImpl.getZrcList(szxzq);
		}else{
			//递归数据
			list=addressDaoImpl.getDgZrcList(szxzq);
			//去重复
			list=quChongFu(list);
		}
		for (Map<String, Object> obj : list) {
			EasyCombobox combo=new EasyCombobox();
			combo.setId(obj.get("ID").toString());
			combo.setText(obj.get("JC").toString());
			zrcList.add(combo);
		}
		return zrcList;
	}

	/**
	 * 
	 * @Description：获取小区数据
	 *
	 * @date：2015-10-28 下午03:15:16
	 *
	 * @author ：wuyechun
	 */
	public List getXiaoquList(String szxzq) {
		//List<Map<String, Object>> list=addressDaoImpl.getXiaoquList(szxzq);
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		if(isQuOrXian(szxzq)){
			list=addressDaoImpl.getXiaoquList(szxzq);
		}else{
			//递归数据
			list=addressDaoImpl.getDgXiaoquList(szxzq);
			//去重复
			list=quChongFu(list);
		}
		List<EasyCombobox> resultList=new ArrayList<EasyCombobox>();
		for (Map<String, Object> obj : list) {
			EasyCombobox combo=new EasyCombobox();
			if(obj.get("JC")!=null){
				combo.setId(obj.get("ID").toString());
				combo.setText(obj.get("JC").toString());
				resultList.add(combo);
			}else{
				//System.out.println(szxzq+":"+obj.get("ID").toString());
			}
		}
		return resultList;
	}

	/**
	 * 
	 * @Description：获取地址基本信息
	 *
	 * @date：2015-10-28 下午06:52:59
	 *
	 * @author ：wuyechun
	 */
	public Object getBaseInfo(String szxzq) {
		List<Map<String, Object>> list=addressDaoImpl.getBaseInfo(szxzq);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return new HashMap();
		}
		
	}
	
	
	/**
	 * 
	 * @Description：获取地址基本信息
	 *
	 * @date：2015-10-28 下午06:52:59
	 *
	 * @author ：wuyechun
	 */
	public Object getBaseInfoByAreaCode(String areaCode) {
		List<Map<String, Object>> list=addressDaoImpl.getBaseInfoByAreaCode(areaCode);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return new HashMap();
		}
		
	}
	

	/**
	 * 
	 * @Description：获取门牌号
	 *
	 * @date：2015-10-29 上午10:13:08
	 *
	 * @author ：wuyechun
	 */
	public Object getMph(String czstlx, String czstid, String yfstl,String yfstid) {
		List<Map<String, Object>> list=addressDaoImpl.getMph(czstlx,czstid,yfstl,yfstid);
		if(!list.isEmpty()){
			return list.get(0);
		}else{
			return new HashMap();
		}
	}

	/**
	 * 
	 * @Description：保存操作
	 *
	 * @date：2015-10-30 上午09:46:43
	 *
	 * @author ：wuyechun
	 */
	public void save(Map map) {
		addressDaoImpl.save(map);
	}

	/**
	 * 
	 * @Description：更新
	 *
	 * @date：2015-10-30 下午04:55:49
	 *
	 * @author ：wuyechun
	 */
	public void update(Map map) {
		addressDaoImpl.update(map);
	}

	/**
	 * 根据行政区编码查找ID
	 * @param bm
	 * @return
	 */
	public String getXzqIdByBm(String bm) {
		
		/**
		Map<String, String> mp=new HashMap<String, String>();
		mp.put("340202", "531");
		mp.put("340203", "532");
		mp.put("340207", "533");
		mp.put("340208", "534");
		mp.put("340223", "535");
		mp.put("340208", "536");
		mp.put("340225", "537");
		mp.put("340221", "591");
		String id=mp.get(bm);**/
		
		
		return addressDaoImpl.getXzqIdByBm(bm);
	}
	
	/**
	 * 
	 * 方法描述：isQuOrXian
	 * @param xzqid 行政区ID
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public boolean isQuOrXian(String xzqid){
		//logger.info("-------isQuOrXian:"+xzqid);
		Map<String, String> mp=new HashMap<String, String>();
		//镜湖区
		mp.put("340202", "531");
		//弋江区
		mp.put("340203", "532");
		//鸠江区
		mp.put("340207", "533");
		//三山区
		mp.put("340208", "534");
		//芜湖县
		mp.put("340221", "591");
		//繁昌县
		mp.put("340222", "536");
		//南陵县
		mp.put("340223", "535");
		//无为县
		mp.put("340225", "537");
		//经开区
		mp.put("340209", "");
		//江北集中区
		mp.put("340210", "");
		//长江大桥开发区
		mp.put("340211","");
		
		mp.put("340217", "0");
		
		return mp.containsKey(xzqid);
	}


	/**
	 * 
	 * 方法描述：街路巷保存
	 * @param map 
	 * @exception 
	 * @author wuyechun
	 */
	public void saveJieluxiang(Map map) {
		addressDaoImpl.saveJieluxiang(map);
		
	}

	/**
	 * 
	 * 方法描述：小区保存
	 * @param map 
	 * @exception 
	 * @author wuyechun
	 */
	public void saveXiaoQu(Map map) {
		addressDaoImpl.saveXiaoQu(map);
		
	}


	/**
	 * 
	 * 方法描述：街路巷或自然村是否存在
	 * @param xzqid
	 * @param areaCode
	 * @param addressType
	 * @param jlxOrZrcQc
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public boolean isJlxExist(String xzqid, String areaCode,
			String addressType, String jlxOrZrcQc) {
		boolean isExist=false;
		Long count=addressDaoImpl.getJlxCount(xzqid,areaCode,addressType,jlxOrZrcQc);
		if(count>0){
			isExist=true;
		}
		return isExist;
	}
	
	/**
	 * 
	 * 方法描述：小区是否存在
	 * @param xzqid
	 * @param areaCode
	 * @param addressType
	 * @param jlxOrZrcQc
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public boolean isXqExist(String xzqid, String areaCode,String xqqc) {
		boolean isExist=false;
		Long count=addressDaoImpl.getXqCount(xzqid,areaCode,xqqc);
		if(count>0){
			isExist=true;
		}
		return isExist;
	}

	


	/***
	 * 
	 * 方法描述：保存街路巷或自然村,返回ID
	 * @param xzqid  所在行政区ID
	 * @param areaCode 所在行政区编码
	 * @param addressType 地址类型,1,街路巷 2,自然村
	 * @param jlxOrZrcQc  街路巷或者自然村全称
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public String saveJlx(String xzqid, String areaCode, String addressType,
			String jlxOrZrcQc) {
		return addressDaoImpl.saveJlx(xzqid,areaCode,addressType,jlxOrZrcQc);
	}


	/**
	 * 
	 * 方法描述：保存小区信息,返回ID
	 * @param xzqid    所在行政区ID
	 * @param areaCode 所在行政区编码
	 * @param xqqc 小区全称
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public String saveXiaoqu(String xzqid, String areaCode, String xqqc) {
		return addressDaoImpl.saveXiaoqu(xzqid,areaCode,xqqc);
	}




	
	
	
	

}
