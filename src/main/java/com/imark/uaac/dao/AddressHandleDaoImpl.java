package com.imark.uaac.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;

@Component
public class AddressHandleDaoImpl extends JdbcSupportDao implements AddressHandleDao{

	/**
	 * 
	 * @Description：获取子节点
	 *
	 * @date：2015-10-26 上午10:45:04
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getChildList(String pid) {
		String sql="SELECT * FROM whsg_bzdz_xzq t WHERE t.szxzq=? order by t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{pid});
		return list;
	}
	
	/**
	 * 
	 * @Description：获取节点
	 *
	 * @date：2015-10-26 上午10:45:04
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getList(String id) {
		String sql="SELECT * FROM whsg_bzdz_xzq t WHERE t.id=?";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{id});
		return list;
	}
	
	
	
	/**
	 * 
	 * @Description：获取子数量
	 *
	 * @date：2015-10-27 下午06:44:57
	 *
	 * @author ：wuyechun
	 */
	public Long getChildCount(String pid) {
		String sql="SELECT COUNT(1) FROM whsg_bzdz_xzq t WHERE t.szxzq=?";
		Long total = getJdbcTemplate().queryForObject(sql,new Object[]{pid}, Long.class);
		return total;
	}

	/**
	 * 
	 * @Description：获取街路巷数据
	 *
	 * @date：2015-10-28 下午02:13:55
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getJlxList(String szxzq) {
		String sql="SELECT * FROM whsg_bzdz_jlx t WHERE t.szxzq=? ORDER BY t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	
	
	
	/**
	 * 
	 * @Description：获取街路巷数据-递归
	 *
	 * @date：2015-10-28 下午02:13:55
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getDgJlxList(String szxzq) {
		String sql="SELECT *  FROM whsg_bzdz_jlx t WHERE t.szxzq IN(\n" +
			"      select t.id from whsg_bzdz_xzq t start with t.id=? connect by prior id = szxzq\n" + 
			") order by t.jc,t.id";
		
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	
	

	/**
	 * 
	 * @Description：获取自然村数据
	 *
	 * @date：2015-10-28 下午02:17:46
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getZrcList(String szxzq) {
		String sql="SELECT * FROM whsg_bzdz_zrc t WHERE t.szxzq=? ORDER BY t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	
	
	/**
	 * 
	 * @Description：获取自然村数据-递归
	 *
	 * @date：2015-10-28 下午02:17:46
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getDgZrcList(String szxzq) {
		String sql="SELECT *  FROM whsg_bzdz_zrc t WHERE t.szxzq IN(\n" +
		"      select t.id from whsg_bzdz_xzq t start with t.id=? connect by prior id = szxzq\n" + 
		") order by t.jc,t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	
	

	/**
	 * 
	 * @Description：获取小区数据
	 *
	 * @date：2015-10-28 下午03:24:17
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getXiaoquList(String szxzq) {
		String sql="SELECT * FROM whsg_bzdz_xq t WHERE t.szxzq=? ORDER BY t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	
	
	/**
	 * 
	 * @Description：获取小区数据-递归
	 *
	 * @date：2015-10-28 下午03:24:17
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getDgXiaoquList(String szxzq) {
		String sql="SELECT *  FROM whsg_bzdz_xq t WHERE t.szxzq IN(\n" +
			"      select t.id from whsg_bzdz_xzq t start with t.id=? connect by prior id = szxzq\n" + 
			") order by t.jc,t.id";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}
	

	/**
	 * 
	 * @Description：获取地址基本信息
	 *
	 * @date：2015-10-28 下午07:02:10
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getBaseInfo(String szxzq) {
		String sql="SELECT * FROM whsg_bzdz_baseinfo t WHERE t.xzqid=?1";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{szxzq});
		return list;
	}

	/**
	 * 
	 * @Description：获取门牌号
	 *
	 * @date：2015-10-29 上午10:19:54
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getMph(String czstlx, String czstid,String yfstl, String yfstid) {
		String sql="SELECT * FROM whsg_bzdz_mph t WHERE t.czstlx=?  AND t.yfstlx=? AND t.yfstid=?";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{czstlx,yfstl,yfstid});
		return list;
	}

	/**
	 * 
	 * @Description：保存操作
	 *
	 * @date：2015-10-30 上午09:47:34
	 *
	 * @author ：wuyechun
	 */
	public void save(Map map) {
		String sql="INSERT INTO WHSG_BZDZ_BASEINFO\n" +
			"  (BZDZ, --标准地址 \n" +   
			"   DZLX, --地址类型\n " + 
			"   XZQID,--行政区ID\n" + 
			"   XZQDM,\n" + 
			"   ADDRESS_TYPE,\n" + 
			"   JLXID,\n" + 
			"   JLXQC,\n" + 
			"   ZRCID,\n" + 
			"   ZRCQC,\n" + 
			"   MPHID,\n" + 
			"   MPHQC,\n" + 
			"   XQID,\n" + 
			"   XQQC,\n" + 
			"   DATA_SOURCE,\n" + 
			"   XXDZ,\n" + 
			"   TELE_GOV,\n" + 
			"   CENSUS_TYPE,\n" + 
			"   CREATE_TIME,\n" + 
			"   CREATE_USER,\n" + 
			"   UPDATE_TIME,\n" + 
			"   UPDATE_USER,\n" + 
			"   ID)\n" + 
			"VALUES\n" + 
			"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"+
			" SEQ_WHSG_BZDZ_BASEINFO.NEXTVAL)";
		
		//根据地址类型,区分保存到街路巷,还是自然村
		String addressType=(String) map.get("addressType");
		//街路巷1,自然村2
		if("1".equals(addressType)){
			getJdbcTemplate().update(sql,   
					new Object[]{map.get("bzdz"),
								map.get("dzlx"),
								map.get("xzqid"),
								map.get("xzqdm"),
								map.get("addressType"),
								map.get("jlxOrZrcId"),
								map.get("jlxOrZrcQc"),
								"",
								"",
								map.get("mphid"),
								map.get("mphqc"),
								map.get("xqid"),
								map.get("xqqc"),
								map.get("dataSource"),
								map.get("xxdz"),
								map.get("telgov"),
								map.get("censusType"),
								map.get("createTime"),
								map.get("createUser"),
								map.get("updateTime"),
								map.get("updateUser")
				});  
		}else{
					getJdbcTemplate().update(sql,   
							new Object[]{map.get("bzdz"),
										map.get("dzlx"),
										map.get("xzqid"),
										map.get("xzqdm"),
										map.get("addressType"),
										"",
										"",
										map.get("jlxOrZrcId"),
										map.get("jlxOrZrcQc"),
										map.get("mphid"),
										map.get("mphqc"),
										map.get("xqid"),
										map.get("xqqc"),
										map.get("dataSource"),
										map.get("xxdz"),
										map.get("telgov"),
										map.get("censusType"),
										map.get("createTime"),
										map.get("createUser"),
										map.get("updateTime"),
										map.get("updateUser")
					});  
		}
		
	}
	
	/**
	 * 
	 * @Description：保存操作
	 *
	 * @date：2015-10-30 上午09:47:34
	 *
	 * @author ：wuyechun
	 */
	public void update(Map map) {
		String sql="UPDATE WHSG_BZDZ_BASEINFO t\n" +
			"   SET  t.BZDZ=?, --标准地址 \n" +   
			"   t.DZLX=?, --地址类型\n " + 
			"   t.XZQID=?,--行政区ID\n" + 
			"   t.XZQDM=?,\n" + 
			"   t.ADDRESS_TYPE=?,\n" + 
			"   t.JLXID=?,\n" + 
			"   t.JLXQC=?,\n" + 
			"   t.ZRCID=?,\n" + 
			"   t.ZRCQC=?,\n" + 
			"   t.MPHID=?,\n" + 
			"   t.MPHQC=?,\n" + 
			"   t.XQID=?,\n" + 
			"   t.XQQC=?,\n" + 
			"   t.DATA_SOURCE=?,\n" + 
			"   t.XXDZ=?,\n" + 
			"   t.TELE_GOV=?,\n" + 
			"   t.CENSUS_TYPE=?,\n" + 
			"   t.CREATE_TIME=?,\n" + 
			"   t.CREATE_USER=?,\n" + 
			"   t.UPDATE_TIME=?,\n" + 
			"   t.UPDATE_USER=? WHERE t.ID=?\n";
		
		
		//根据地址类型,区分保存到街路巷,还是自然村
		String addressType=(String) map.get("addressType");
		//街路巷1,自然村2
		if("1".equals(addressType)){
			getJdbcTemplate().update(sql,   
					new Object[]{map.get("bzdz"),
								map.get("dzlx"),
								map.get("xzqid"),
								map.get("xzqdm"),
								map.get("addressType"),
								map.get("jlxOrZrcId"),
								map.get("jlxOrZrcQc"),
								"",
								"",
								map.get("mphid"),
								map.get("mphqc"),
								map.get("xqid"),
								map.get("xqqc"),
								map.get("dataSource"),
								map.get("xxdz"),
								map.get("telgov"),
								map.get("censusType"),
								map.get("createTime"),
								map.get("createUser"),
								map.get("updateTime"),
								map.get("updateUser"),
								map.get("addressId")
				});  
		
			
			
		}else{
					getJdbcTemplate().update(sql,   
							new Object[]{map.get("bzdz"),
										map.get("dzlx"),
										map.get("xzqid"),
										map.get("xzqdm"),
										map.get("addressType"),
										"",
										"",
										map.get("jlxOrZrcId"),
										map.get("jlxOrZrcQc"),
										map.get("mphid"),
										map.get("mphqc"),
										map.get("xqid"),
										map.get("xqqc"),
										map.get("dataSource"),
										map.get("xxdz"),
										map.get("telgov"),
										map.get("censusType"),
										map.get("createTime"),
										map.get("createUser"),
										map.get("updateTime"),
										map.get("updateUser"),
										map.get("addressId")
					});  
		}
		
	}

	/**
	 * 根据行政区编码查找ID
	 * @param bm
	 * @return
	 */
	public String getXzqIdByBm(String bm) {
		String sql="SELECT max(t.id) FROM whsg_bzdz_xzq t where t.bm=?";
		String id = getJdbcTemplate().queryForObject(sql,new Object[]{bm}, String.class);
		return id;
	}

	/**
	 * 
	 * @Description：是否含有基本信息,行政区ID
	 *
	 * @date：2015-11-2 上午10:58:26
	 *
	 * @author ：wuyechun
	 */
	public Long isHasBaseInfo(String xzqid) {
		String sql="SELECT COUNT(1) FROM whsg_bzdz_baseinfo t WHERE t.xzqid=?1";
		Long total = getJdbcTemplate().queryForObject(sql,new Object[]{xzqid}, Long.class);
		return total;
	}
	
	

}
