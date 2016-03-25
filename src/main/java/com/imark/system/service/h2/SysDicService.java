package com.imark.system.service.h2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imark.common.util.Constant;
import com.imark.common.util.IUtil;
import com.imark.common.vo.EasyTree;
import com.imark.system.dao.SysDicDao;
import com.imark.system.dao.jpa.SysDicJpaDao;
import com.imark.system.model.SysDic;

@Transactional
@Component
public class SysDicService {
	
	@Autowired
	private SysDicDao sysDicDao;
	
	@Autowired
	private SysDicJpaDao sysDicJpaDao;

	/**
	 * 
	 * 功能 :获取子节点
	
	 * 开发：wuyechun 2016-3-15
	
	 * @param pid
	 * @return
	 */
	public List<EasyTree> getListByPid(String pid) {
		
		//字典类别
		//List<Map<String, Object>> list=sysDicDao.getListByPid(pid,Constant.DIC_TYPE_ZDLB);
		List<Map<String, Object>> list=sysDicDao.getListByPid(pid);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		
		
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("ID").toString());
			tree.setText(obj.get("DIC_NAME").toString());
			if(obj.get("ID")!=null&&IUtil.isNotBlank(obj.get("ID").toString())){
				tree.setState(hasChild(obj.get("ID").toString())?"closed":"open");
			}
			Map<String, String> attr=new HashMap<String, String>();
			
			attr.put("pid", obj.get("PID").toString());
			attr.put("isUse", obj.get("IS_USE").toString());
			attr.put("dicType", obj.get("DIC_TYPE").toString());
			attr.put("dicCode", obj.get("DIC_CODE").toString());
			attr.put("dicMemo", obj.get("DIC_MEMO").toString());
			attr.put("disOrder", obj.get("DIS_ORDER").toString());
			tree.setAttributes(attr);
			
			
			childList.add(tree);
		}
		
		return childList;
	}
	
	
	/**
	 * 
	 * 功能 :是否含有子节点
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	public boolean hasChild(String pid){
		List<Map<String, Object>> list=sysDicDao.getListByPid(pid);
		if(list.isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}

	
	/**
	 * 
	 * 功能 :保存操作
	
	 * 开发：wuyechun 2016-3-22
	
	 * @param sysDic
	 */
	public void save(SysDic sysDic) {
		sysDicJpaDao.save(sysDic);
		
	}


	/**
	 * 
	 * 功能 :删除
	
	 * 开发：wuyechun 2016-3-22
	
	 * @param id
	 */
	public void delete(String id) {
		sysDicJpaDao.delete(id);
		
	}


	/**
	 * 
	 * 功能 :根据字典编码获取下级字典项
	
	 * 开发：wuyechun 2016-3-22
	
	 * @param pDicCode
	 * @return
	 */
	public List<EasyTree> getChildByPCode(String pDicCode) {
		List<Map<String, Object>> list=sysDicDao.getChildByPCode(pDicCode);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("ID").toString());
			tree.setText(obj.get("DIC_NAME").toString());
			childList.add(tree);
		}
		
		return childList;
	}


	/**
	 * 
	 * 功能 :根据字典编码获取字典
	
	 * 开发：wuyechun 2016-3-24
	
	 * @param dicCode
	 * @return
	 */
	public Object getDicByCode(String dicCode) {
		return sysDicJpaDao.findByDicCode(dicCode);
	}

}
