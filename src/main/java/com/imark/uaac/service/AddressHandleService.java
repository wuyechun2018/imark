package com.imark.uaac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyCombobox;
import com.imark.common.vo.EasyTree;
import com.imark.uaac.dao.AddressDaoImpl;
import com.imark.uaac.dao.AddressHandleDaoImpl;

@Transactional
@Component
public class AddressHandleService {
	
	@Autowired
	private AddressHandleDaoImpl addressHandleDaoImpl;

	
	/**
	 * 
	 * @Description：获取树节点
	 *
	 * @date：2015-10-27 下午04:39:02
	 *
	 * @author ：wuyechun
	 */
	public List<EasyTree> getTreeList(String id) {
		List<Map<String, Object>> list=addressHandleDaoImpl.getList(id);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("ID").toString());
			tree.setText(obj.get("JC").toString());
			tree.setState("closed");
			childList.add(tree);
		}
		return childList;
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
		List<Map<String, Object>> list=addressHandleDaoImpl.getChildList(pid);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("ID").toString());
			tree.setText(obj.get("JC").toString());
			tree.setState(getFolderState(obj.get("ID").toString()));
			
			boolean isHasBaseInfo=isHasBaseInfo(obj.get("ID").toString());
			
			//区县图标不做处理
			if(!isQuOrXian(obj.get("ID").toString())){
				if(isHasBaseInfo){
					tree.setIconCls("itree-accept");
				}else{
					tree.setIconCls("itree-cancel");
				}
			}
			
			Map attr=new HashMap();
			attr.put("QC", obj.get("QC").toString());
			
			tree.setAttributes(attr);
			
			
			childList.add(tree);
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
		Long count=addressHandleDaoImpl.getChildCount(pid);
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
	public boolean isHasBaseInfo(String pid){
		boolean hasChild=false;
		Long count=addressHandleDaoImpl.isHasBaseInfo(pid);
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
	public String getFolderState(String pid){
		boolean hasChild=isHasChild(pid);
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
			list=addressHandleDaoImpl.getJlxList(szxzq);
		}else{
			//递归数据
			list=addressHandleDaoImpl.getDgJlxList(szxzq);
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
			list=addressHandleDaoImpl.getZrcList(szxzq);
		}else{
			//递归数据
			list=addressHandleDaoImpl.getDgZrcList(szxzq);
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
			list=addressHandleDaoImpl.getXiaoquList(szxzq);
		}else{
			//递归数据
			list=addressHandleDaoImpl.getDgXiaoquList(szxzq);
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
		List<Map<String, Object>> list=addressHandleDaoImpl.getBaseInfo(szxzq);
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
		List<Map<String, Object>> list=addressHandleDaoImpl.getMph(czstlx,czstid,yfstl,yfstid);
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
		addressHandleDaoImpl.save(map);
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
		addressHandleDaoImpl.update(map);
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
		
		
		return addressHandleDaoImpl.getXzqIdByBm(bm);
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
		Map<String, String> mp=new HashMap<String, String>();
		mp.put("531", "340202");
		mp.put("532", "340203");
		mp.put("533", "340207");
		mp.put("534", "340208");
		mp.put("535", "340223");
		mp.put("536", "340222");
		mp.put("537", "340225");
		mp.put("591", "340221");
		return mp.containsKey(xzqid);
	}
	
	
	

}
