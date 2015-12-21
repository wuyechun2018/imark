package com.imark.system.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;
import com.imark.system.model.GovernmentState;
import com.imark.system.model.SysMarkLogs;
import com.imark.system.vo.XzcfVo;
import com.imark.system.vo.XzxkVo;

@Component
public class MarkLogDaoImp extends JdbcSupportDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @Description：保存操作
	 *
	 * @date：2015-9-29 上午10:18:51
	 *
	 * @author ：wuyechun
	 */
	public void save(final SysMarkLogs markLogs) {
		getJdbcTemplate().update(
				"insert into SYS_MARK_LOGS(ID,MARK_TYPE,OP_DATE,BIZ_ID,BIZ_TYPE,BIZ_PARAM,BIZ_DESC,BIZ_STATUS,LOGIC_STATUS,OP_USER) \n" +
				"values(sys_guid(),?,?,?,?,?,?,?,?,?)",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setString(1,markLogs.getMarkType());
						ps.setString(2,markLogs.getOpDate());
						ps.setString(3, markLogs.getBizId());
						ps.setString(4, markLogs.getBizType());
						ps.setString(5, markLogs.getBizParam());
						ps.setString(6,markLogs.getBizDesc());
						ps.setString(7,markLogs.getBizStatus());
						ps.setString(8,markLogs.getLogicStatus());
						ps.setString(9,markLogs.getOpUser());
					}
				});
	}

	/**
	 * 
	 * @Description：列表
	 *
	 * @date：2015-9-29 下午02:58:52
	 *
	 * @author ：wuyechun
	 */
	public List getList(String bizId, String bizType) {
		String sql="select *\n" +
			"  from SYS_MARK_LOGS t\n" + 
			" WHERE t.mark_type = '1' AND t.logic_status='0'\n" + 
			"   AND t.biz_id =?\n" + 
			"   AND t.biz_type =? ORDER BY t.OP_DATE DESC";
		List<Map<String, Object>> userList = getJdbcTemplate().queryForList(sql,new Object[] {bizId,bizType});
		return userList;
	}
	/**
	 * 
	 * @Description：报表列表
	 *
	 * @date：2015-10-9 下午02:45:54
	 *
	 * @author ：liuyu
	 */
	public List getStatList() {
		String sql="select *\n" +
			"  from SYS_MARK_LOGS t\n" + 
			" WHERE t.mark_type = '1' AND t.logic_status='0'\n" + 
			" ORDER BY t.OP_DATE DESC";
		List<Map<String, Object>> statList = getJdbcTemplate().queryForList(sql,new Object[] {});
		return statList;
	}
	
	/**
	 * 
	 * @Description：报表列表
	 *
	 * @date：2015-10-9 下午02:45:54
	 *
	 * @author ：liuyu
	 */
	public List getStatList1() {
		String sql="select * from (" +
		" select nvl(m.bmmc,n.bmmc)as BIZ_ID ,m.cfgk as XZCF_GK,m.cfzhgk as XZCF_ZH,m.cfbgk as XZCF_BGK,(m.cfgk+m.cfzhgk+m.cfbgk)as XZCF_HJ ," +
		" m.xkgk as XZXK_GK,m.xkzhgk as XZXK_ZH,m.xkbgk as XZXK_BGK,(m.xkgk+m.xkzhgk+m.xkbgk)as XZXK_HJ,nvl(n.zs,0) as XZKH_ZS,nvl(n.cs,0) as XZKH_CS,nvl((n.zs+n.cs ),0)as XZKH_HJ from" +
		" (select nvl(t1.bmmc,t2.bmmc)as bmmc,nvl(t1.cfgk,0) as cfgk,nvl(t1.cfzhgk,0) as cfzhgk,nvl(t1.cfbgk,0) as cfbgk," +
		" nvl(t2.xkgk,0) as xkgk,nvl(t2.xkzhgk,0) as xkzhgk,nvl(t2.xkbgk,0) as xkbgk" +
		" from(select f.bmmc,sum(case when f.xxfl like'公开%'then 1 else 0 end ) as cfgk," +
		" sum(case when f.xxfl like'暂缓公开%'then 1 else 0 end ) as cfzhgk," +
		" sum(case when f.xxfl like'不公开%'then 1 else 0 end ) as cfbgk" +
		" from XYWH_XZCF f group by f.bmmc) t1 " +
		" full join" +
		" (select k.bmmc,sum(case when k.xxfl like'公开%'then 1 else 0 end ) as xkgk," +
		" sum(case when k.xxfl like'暂缓公开%'then 1 else 0 end ) as xkzhgk, " +
		" sum(case when k.xxfl like'不公开%'then 1 else 0 end ) as xkbgk " +
		" from XYWH_XZXK k group by k.bmmc) t2 " +
		" on  t1.bmmc = t2.bmmc) m " +
		" full join " +
		" (select nvl(t1.bmmc,t2.bmmc)as bmmc，(nvl(t1.cfzs,0)+nvl(t2.xkzs,0))as zs,(nvl(t1.cfcs,0)+nvl(t2.xkcs,0))as cs from" +
		" (select f.bmmc,sum(case when ceil((To_date(f.scsj, 'yyyy-mm-dd') - To_date(f.sxrq, 'yyyy/mm/dd')))< =7 then 1 else 0 end ) as cfzs," +
		" sum(case when ceil((To_date(f.scsj, 'yyyy-mm-dd') - To_date(f.sxrq, 'yyyy/mm/dd'))) >7 then 1 else 0 end ) as cfcs" +
		" from XYWH_XZCF f where f.scsj>'2015/10/25' group by f.bmmc) t1" +
		" full join(select k.bmmc," +
		" sum(case when ceil((To_date(k.scsj, 'yyyy-mm-dd') - To_date(k.TAKEEFFECTDATE, 'yyyy/mm/dd')))< =7 then 1 else 0 end ) as xkzs," +
		" sum(case when ceil((To_date(k.scsj, 'yyyy-mm-dd') - To_date(k.TAKEEFFECTDATE, 'yyyy/mm/dd'))) >7 then 1 else 0 end ) as xkcs" +
		" from XYWH_XZXK k where k.scsj>'2015/10/25' group by k.bmmc) t2 on t1.bmmc=t2.bmmc ) n" +
		" on m.bmmc=n.bmmc)";
		List<Map<String, Object>> statList1 = getJdbcTemplate().queryForList(sql,new Object[] {});
		return statList1;
	}
	
	
	public List<GovernmentState> getGovernmentStateChart() {
		
		// 如果传过来的时间为空，则默认取当前年月
		String sql = "select * from (" +
		" select nvl(m.bmmc,n.bmmc)as BIZ_ID ,m.cfgk as XZCF_GK,m.cfzhgk as XZCF_ZH,m.cfbgk as XZCF_BGK,(m.cfgk+m.cfzhgk+m.cfbgk)as XZCF_HJ ," +
		" m.xkgk as XZXK_GK,m.xkzhgk as XZXK_ZH,m.xkbgk as XZXK_BGK,(m.xkgk+m.xkzhgk+m.xkbgk)as XZXK_HJ,nvl(n.zs,0) as XZKH_ZS,nvl(n.cs,0) as XZKH_CS,nvl((n.zs+n.cs ),0)as XZKH_HJ from" +
		" (select nvl(t1.bmmc,t2.bmmc)as bmmc,nvl(t1.cfgk,0) as cfgk,nvl(t1.cfzhgk,0) as cfzhgk,nvl(t1.cfbgk,0) as cfbgk," +
		" nvl(t2.xkgk,0) as xkgk,nvl(t2.xkzhgk,0) as xkzhgk,nvl(t2.xkbgk,0) as xkbgk" +
		" from(select f.bmmc,sum(case when f.xxfl like'公开%'then 1 else 0 end ) as cfgk," +
		" sum(case when f.xxfl like'暂缓公开%'then 1 else 0 end ) as cfzhgk," +
		" sum(case when f.xxfl like'不公开%'then 1 else 0 end ) as cfbgk" +
		" from XYWH_XZCF f group by f.bmmc) t1 " +
		" full join" +
		" (select k.bmmc,sum(case when k.xxfl like'公开%'then 1 else 0 end ) as xkgk," +
		" sum(case when k.xxfl like'暂缓公开%'then 1 else 0 end ) as xkzhgk, " +
		" sum(case when k.xxfl like'不公开%'then 1 else 0 end ) as xkbgk " +
		" from XYWH_XZXK k group by k.bmmc) t2 " +
		" on  t1.bmmc = t2.bmmc) m " +
		" full join " +
		" (select nvl(t1.bmmc,t2.bmmc)as bmmc，(nvl(t1.cfzs,0)+nvl(t2.xkzs,0))as zs,(nvl(t1.cfcs,0)+nvl(t2.xkcs,0))as cs from" +
		" (select f.bmmc,sum(case when ceil((To_date(f.scsj, 'yyyy-mm-dd') - To_date(f.sxrq, 'yyyy/mm/dd')))< =7 then 1 else 0 end ) as cfzs," +
		" sum(case when ceil((To_date(f.scsj, 'yyyy-mm-dd') - To_date(f.sxrq, 'yyyy/mm/dd'))) >7 then 1 else 0 end ) as cfcs" +
		" from XYWH_XZCF f where f.scsj>'2015/10/25' group by f.bmmc) t1" +
		" full join(select k.bmmc," +
		" sum(case when ceil((To_date(k.scsj, 'yyyy-mm-dd') - To_date(k.TAKEEFFECTDATE, 'yyyy/mm/dd')))< =7 then 1 else 0 end ) as xkzs," +
		" sum(case when ceil((To_date(k.scsj, 'yyyy-mm-dd') - To_date(k.TAKEEFFECTDATE, 'yyyy/mm/dd'))) >7 then 1 else 0 end ) as xkcs" +
		" from XYWH_XZXK k where k.scsj>'2015/10/25' group by k.bmmc) t2 on t1.bmmc=t2.bmmc ) n" +
		" on m.bmmc=n.bmmc)";
		final List<GovernmentState> list = new ArrayList<GovernmentState>();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				GovernmentState vo = new GovernmentState();
				vo.setBIZ_ID(rs.getString("BIZ_ID"));
				vo.setXZXK_GK(rs.getLong("XZXK_GK"));
				vo.setXZXK_ZH(rs.getLong("XZXK_ZH"));
				vo.setXZXK_BGK(rs.getLong("XZXK_BGK"));
				vo.setXZXK_HJ(rs.getLong("XZXK_HJ"));
				vo.setXZCF_GK(rs.getLong("XZCF_GK"));
				vo.setXZCF_ZH(rs.getLong("XZCF_ZH"));
				vo.setXZCF_BGK(rs.getLong("XZCF_BGK"));
				vo.setXZCF_HJ(rs.getLong("XZCF_HJ"));
				vo.setXZKH_ZS(rs.getLong("XZKH_ZS"));
				vo.setXZKH_CS(rs.getLong("XZKH_CS"));
				vo.setXZKH_HJ(rs.getLong("XZKH_HJ"));
				list.add(vo);
			}
		});
		return list;//list  new ArrayList<GovernmentState>()
	}
	
	/**
	 * 获取行政许可处理列表
	 * @return
	 */
	public List<XzxkVo> getXzxkList() {
		String sql = "select t1.biz_id, t2.organ_name, t1.biz_param, t1.op_date from sys_mark_logs t1 join xywh_organ_mapping t2 on t1.biz_id = t2.organ_code and t1.logic_status = '0' and t1.biz_type = 'xzxk' and biz_status = '0'";
		
		List<XzxkVo> voList = getJdbcTemplate().query(sql,new RowMapper<XzxkVo>() {
			@Override
			public XzxkVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				XzxkVo vo = new XzxkVo();
				vo.setBiz_id(rs.getString("BIZ_ID"));
				vo.setBiz_name(rs.getString("ORGAN_NAME"));
				vo.setBiz_param(rs.getString("BIZ_PARAM"));
				String []dateArr = rs.getString("OP_DATE").split(" ");
				vo.setOp_date(dateArr[0].replace("-", "/"));
				
				return vo;
			}
		});
		
		return voList;
	}
	
	/**
	 * 获取行政处罚处理列表
	 * @return
	 */
	public List<XzcfVo> getXzcfList() {
		String sql = "select t1.biz_id, t2.organ_name, t1.biz_param, t1.op_date from sys_mark_logs t1 join xywh_organ_mapping t2 on t1.biz_id = t2.organ_code and t1.logic_status = '0' and t1.biz_type = 'xzcf' and biz_status = '0'";
		
		List<XzcfVo> voList = getJdbcTemplate().query(sql,new RowMapper<XzcfVo>() {
			@Override
			public XzcfVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				XzcfVo vo = new XzcfVo();
				vo.setBiz_id(rs.getString("BIZ_ID"));
				vo.setBiz_name(rs.getString("ORGAN_NAME"));
				vo.setBiz_param(rs.getString("BIZ_PARAM"));
				String []dateArr = rs.getString("OP_DATE").split(" ");
				vo.setOp_date(dateArr[0].replace("-", "/"));
				
				return vo;
			}
		});
		
		return voList;
	} 
	
}
