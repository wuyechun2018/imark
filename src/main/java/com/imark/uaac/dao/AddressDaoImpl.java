package com.imark.uaac.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.imark.common.util.IUtil;
import com.imark.common.util.JdbcSupportDao;
import com.mysql.jdbc.Connection;

@Component
public class AddressDaoImpl extends JdbcSupportDao implements AddressDao{

	/**
	 * 
	 * @Description：获取子节点
	 *
	 * @date：2015-10-26 上午10:45:04
	 *
	 * @author ：wuyechun
	 */
	public List<Map<String, Object>> getChildList(String pAreaCode) {
		
		//如果上级编码为4位，则下级为区县，则获取方式为SELECT * FROM loc_area s WHERE s.area_type='3' AND SUBSTR(s.area_code,1,4)='3402' ORDER BY s.area_code;
		//如果上级编码为6位，则下级为街道或者服务中心，获取方式为    SELECT * FROM loc_area s WHERE s.area_type='2' AND substr(s.area_code,1,6)='340202' ORDER BY s.id ;
		//如果上级编码为9位，则下级为社区，获取方式为 SELECT * FROM loc_area s WHERE s.area_type='1' AND  substr(s.area_code,1,9)='340202402' ORDER BY s.id ;
		String sql="";
		if(IUtil.isNotBlank(pAreaCode)){
			if(pAreaCode.length()==4){
				sql="SELECT * FROM loc_area s WHERE s.area_type='3' AND SUBSTR(s.area_code,1,4)=? ORDER BY s.area_code";
			}else if(pAreaCode.length()==6){
				sql="SELECT * FROM loc_area s WHERE s.area_type='2' AND substr(s.area_code,1,6)=? ORDER BY s.id ";
			}else{
				sql="SELECT * FROM loc_area s WHERE s.area_type='1' AND  substr(s.area_code,1,9)=? ORDER BY s.id";
			}
			List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{pAreaCode});
			return list;
		}else{
			return null;
		}
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
		//String sql="SELECT * FROM whsg_bzdz_xzq t WHERE t.id=?";
		//String sql="SELECT * FROM loc_area s WHERE s.area_type='4' AND s.area_code=?1";
		String sql="SELECT * FROM loc_area s WHERE  s.area_code=?1";
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
	public Long getChildCount(String pAreaCode) {
		String sql="";
		if(IUtil.isNotBlank(pAreaCode)){
			if(pAreaCode.length()==4){
				sql="SELECT COUNT(1) FROM loc_area s WHERE s.area_type='3' AND SUBSTR(s.area_code,1,4)=?1";
			}else if(pAreaCode.length()==6){
				sql="SELECT COUNT(1) FROM loc_area s WHERE s.area_type='2' AND substr(s.area_code,1,6)=?1";
			}else{
				sql="SELECT COUNT(1) FROM loc_area s WHERE s.area_type='1' AND  substr(s.area_code,1,9)=?1";
			}
			Long total = getJdbcTemplate().queryForObject(sql,new Object[]{pAreaCode}, Long.class);
			return total;
		}else{
			return (long) 0;
		}
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
			"   AREA_CODE,\n" + 
			"   CREATE_TIME,\n" + 
			"   CREATE_USER,\n" + 
			"   UPDATE_TIME,\n" + 
			"   UPDATE_USER,\n" + 
			"   ID)\n" + 
			"VALUES\n" + 
			"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"+
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
								map.get("areaCode"),
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
										map.get("areaCode"),
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
			"   t.AREA_CODE=?,\n" + 
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
								map.get("areaCode"),
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
										map.get("areaCode"),
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
	 * @Description：是否含有基本信息,行政区Code
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

	
	/**
	 * 从公安表中获取行政区ID
	 * @param areaCode
	 * @return
	 */
	public List<Map<String, Object>> getXzqList(String areaCode) {
		String sql="SELECT * FROM whsg_bzdz_xzq t WHERE t.bm =?";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{areaCode});
		return list;
	}

	/**
	 * 
	 * 方法描述：保存街路巷
	 * @param map 
	 * @exception 
	 * @author wuyechun
	 */
	public void saveJieluxiang(Map map) {
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
		"   AREA_CODE,\n" + 
		"   CREATE_TIME,\n" + 
		"   CREATE_USER,\n" + 
		"   UPDATE_TIME,\n" + 
		"   UPDATE_USER,\n" + 
		"   ID)\n" + 
		"VALUES\n" + 
		"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"+
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
								map.get("areaCode"),
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
										map.get("areaCode"),
										map.get("createTime"),
										map.get("createUser"),
										map.get("updateTime"),
										map.get("updateUser")
					});  
			}
			
		}
		
	

	/**
	 * 
	 * 方法描述：保存小区
	 * @param map 
	 * @exception 
	 * @author wuyechun
	 */
	public void saveXiaoQu(Map map) {
		// TODO Auto-generated method stub
		
	}
	

	/**
	 * 根据行政编码加载基本信息
	 * @param areaCode
	 * @return
	 */
	public List<Map<String, Object>> getBaseInfoByAreaCode(String areaCode){
		String sql="SELECT * FROM whsg_bzdz_baseinfo t WHERE t.area_code=?1";
		List<Map<String, Object>> list= getJdbcTemplate().queryForList(sql, new Object[]{areaCode});
		return list;
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
		if("1".equals(addressType)){
				String sqlJlx = "INSERT INTO whsg_bzdz_jlx(ID,JC,QC,SZXZQ,ZT,DATA_SOURCE,AREA_CODE)\n"
						+ "VALUES(?,?,?,?,?,?,?)";
				Long jlxId = getSequenceId("SEQ_WHSG_BZDZ_JLX");
				getJdbcTemplate().update(sqlJlx,
						new Object[] { jlxId, jlxOrZrcQc, jlxOrZrcQc, xzqid, "1", "2",areaCode });
				return jlxId + "";
		}else{
				String sqlZrc = "INSERT INTO whsg_bzdz_zrc(ID,JC,QC,SZXZQ,ZT,DATA_SOURCE,AREA_CODE)\n"
						+ "VALUES(?,?,?,?,?,?,?)";
				Long zrcId = getSequenceId("SEQ_WHSG_BZDZ_ZRC");
				getJdbcTemplate().update(sqlZrc,new Object[] { zrcId, jlxOrZrcQc, jlxOrZrcQc, xzqid, "1", "2",areaCode });
				return zrcId + "";
		}
	}

	
	
	
	/**
	 * 
	 * 方法描述：获取序列ID
	 * @param seqName
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getSequenceId(String seqName){
		String sql="SELECT "+seqName+".NEXTVAL FROM DUAL";
		List list=getJdbcTemplate().queryForList(sql);
		if(!list.isEmpty()){
			Map map=(Map) list.get(0);
			return Long.valueOf(String.valueOf(map.get("NEXTVAL"))).longValue();
		}else{
			return 0L;
		}
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
		String sqlZrc = "INSERT INTO whsg_bzdz_xq(ID,JC,QC,SZXZQ,ZT,DATA_SOURCE,AREA_CODE)\n"
			+ "VALUES(?,?,?,?,?,?,?)";
		Long xiaoquId = getSequenceId("SEQ_WHSG_BZDZ_XQ");
		getJdbcTemplate().update(sqlZrc,new Object[] { xiaoquId, xqqc, xqqc, xzqid, "1", "2",areaCode});
		return xiaoquId + "";
	}

	
	/**
	 * 
	 * 方法描述：获取街路巷数
	 * @param xzqid
	 * @param areaCode
	 * @param addressType
	 * @param jlxOrZrcQc
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getJlxCount(String xzqid, String areaCode, String addressType,
			String jlxOrZrcQc) {
		if("1".equals(addressType)){
			String sql="SELECT COUNT(1) FROM whsg_bzdz_jlx t WHERE t.szxzq=?1 AND t.qc=?2";
			Long total = getJdbcTemplate().queryForObject(sql,new Object[]{xzqid,jlxOrZrcQc}, Long.class);
			return total;
		}else{
			String sql="SELECT COUNT(1) FROM whsg_bzdz_zrc t WHERE t.szxzq=?1 AND t.qc=?2";
			Long total = getJdbcTemplate().queryForObject(sql,new Object[]{xzqid,jlxOrZrcQc}, Long.class);
			return total;
		}
	}

	/**
	 * 
	 * 方法描述：获取小区数
	 * @param xzqid
	 * @param areaCode
	 * @param xqqc
	 * @return 
	 * @exception 
	 * @author wuyechun
	 */
	public Long getXqCount(String xzqid, String areaCode, String xqqc) {
		String sql="SELECT COUNT(1) FROM whsg_bzdz_xq t WHERE t.szxzq=?1 AND t.qc=?2";
		Long total = getJdbcTemplate().queryForObject(sql,new Object[]{xzqid,xqqc}, Long.class);
		return total;
	}

}
