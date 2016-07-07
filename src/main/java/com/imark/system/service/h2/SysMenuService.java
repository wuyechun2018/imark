package com.imark.system.service.h2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imark.common.vo.EasyTree;
import com.imark.system.dao.SysMenuDao;
import com.imark.system.jpa.SysMenuJpaDao;
import com.imark.system.model.SysMenu;

@Component
@Transactional
public class SysMenuService {
	
	@Autowired
	private SysMenuDao sysMenuDaoImpl;
	
	@Autowired
	private SysMenuJpaDao sysMenuJpaDao;
	
	
	/**
	 * 方法描述：保存目录
	 * @param sysMenu 
	 * @exception 
	 * @author wuyechun
	 */
	public void save(SysMenu sysMenu){
		sysMenuJpaDao.save(sysMenu);
	}


	/**
	 * 
	 * 功能 :获取子节点
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param pid
	 * @return
	 */
	public List<EasyTree> getListByPid(String pid) {
		List<Map<String, Object>> list=sysMenuDaoImpl.getListByPid(pid);
		List<EasyTree> childList=new ArrayList<EasyTree>();
		for (Map<String, Object> obj : list) {
			EasyTree tree=new EasyTree();
			tree.setId(obj.get("ID").toString());
			tree.setText(obj.get("MENU_NAME").toString());
			
			//节点状态，有两个值  'open' or 'closed', 默认为'open'. 当为‘closed’,说明此节点下有子节点否则此节点为叶子节点
			if(obj.get("MENU_TYPE")!=null){
				//目录类型  0：文件夹     1：菜单     2：按钮
				tree.setState(hasChild(obj.get("ID").toString())?"closed":"open");
			}else{
				tree.setState("closed");
			}
			
			if(obj.get("MENU_ICON_URL")!=null){
				tree.setIconCls(obj.get("MENU_ICON_URL").toString());
			}
			
			Map<String, String> attr=new HashMap<String, String>();
			//地址
			attr.put("menuAddr", obj.get("MENU_ADDR").toString());
			attr.put("menuType", obj.get("MENU_TYPE").toString());
			attr.put("memo", obj.get("MEMO").toString());
			attr.put("orderNo", obj.get("ORDER_NO").toString());
			attr.put("menuIconUrl", obj.get("MENU_ICON_URL").toString());
			attr.put("isUse", obj.get("IS_USE").toString());
			attr.put("menuPid", obj.get("MENU_PID").toString());
			
			
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
		List<Map<String, Object>> list=sysMenuDaoImpl.getListByPid(pid);
		//System.out.println(pid+"-------------"+list.size());
		if(list.isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}


	/**
	 * 
	 * 功能 :删除
	
	 * 开发：wuyechun 2016-2-29
	
	 * @param id
	 */
	public void delete(String id) {
		sysMenuJpaDao.delete(id);
	}


	

}
