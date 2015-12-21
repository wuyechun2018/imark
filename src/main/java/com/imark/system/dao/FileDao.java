package com.imark.system.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.imark.common.util.JdbcSupportDao;
import com.imark.system.model.Xzcf;
import com.imark.system.model.Xzxk;
import com.imark.system.vo.XzcfVo;
import com.imark.system.vo.XzxkVo;

@Component
public class FileDao extends JdbcSupportDao{
	/**
	 * 行政许可信息的保存
	 * @param xzxk
	 */
	public void saveXzxk(final Xzxk xzxk, final XzxkVo vo) {
		getJdbcTemplate().update("insert into xywh_xzxk(id, bmbh, bmmc, xxfl, xh, jdswh, gwyw, sdyj, xmmc, splb, xydm, takeeffectdate, losteffectdate, cbbm, qtgtspbm, bljg, xkdx, scsj)" +
				"values(sys_guid(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
		new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps)
					throws SQLException {
				ps.setString(1, vo.getBiz_id());
				ps.setString(2, vo.getBiz_name());
				ps.setString(3, xzxk.getXxfl());
				ps.setString(4, xzxk.getXh());
				ps.setString(5, xzxk.getJdswh());
				ps.setString(6, xzxk.getGwyw() == "" ? "无" : xzxk.getGwyw());
				ps.setString(7, xzxk.getSdyj() == "" ? "无" : xzxk.getSdyj());
				ps.setString(8, xzxk.getXmmc());
				ps.setString(9, xzxk.getSplb());
				ps.setString(10, xzxk.getXydm());
				ps.setString(11, xzxk.getTakeEffectDate());
				ps.setString(12, xzxk.getLostEffectDate());
				ps.setString(13, xzxk.getCbbm());
				ps.setString(14, xzxk.getQtgtspbm());
				ps.setString(15, xzxk.getBljg());
				ps.setString(16, xzxk.getXkdx());
				ps.setString(17, vo.getOp_date());
			}
		});
	}
	
	/**
	 * 行政处罚信息的保存
	 * @param xzcf
	 */
	public void saveXzcf(final Xzcf xzcf, final XzcfVo vo) {
		getJdbcTemplate().update("insert into xywh_xzcf (id, bmbh, bmmc, xxfl, xh, jdswh, gwyw, zfyj, ajmc, xydm, cfsy, cfjg, cflxfs, sxrq, cfqx, cfbm, jarq, jjqd, cfdx, scsj)" + 
					"values (sys_guid(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
		new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps)
					throws SQLException {
				ps.setString(1, vo.getBiz_id());
				ps.setString(2, vo.getBiz_name());
				ps.setString(3, xzcf.getXxfl());
				ps.setString(4, xzcf.getXh());
				ps.setString(5, xzcf.getJdswh());
				ps.setString(6, xzcf.getGwyw());
				ps.setString(7, xzcf.getZfyj());
				ps.setString(8, xzcf.getAjmc());
				ps.setString(9, xzcf.getXydm());
				ps.setString(10, xzcf.getCfsy());
				ps.setString(11, xzcf.getCfjg());
				ps.setString(12, xzcf.getCflxfs());
				ps.setString(13, xzcf.getSxrq());
				ps.setString(14, xzcf.getCfqx());
				ps.setString(15, xzcf.getCfbm());
				ps.setString(16, xzcf.getJarq());
				ps.setString(17, xzcf.getJjqd());
				ps.setString(18, xzcf.getCfdx());
				ps.setString(19, vo.getOp_date());
			}
		});
	}
	
	/**
	 * 文件入库状态修改
	 * @param filePath
	 */
	public void updateBizStatus(String bizParam) {
		getJdbcTemplate().update("update sys_mark_logs t set t.biz_status = '1' where biz_param = '" + bizParam + "'");
	}
}
