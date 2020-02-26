/**
 * 顾客数据库操作类
 * @author 张永彩
 * 2018-07-16
 */
package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.BaseDao;
import hotel.dao.consumerDao;
import hotel.entity.ConsumerSex;
import hotel.entity.consumer;
import hotel.entity.user;

public class consumerDaoImpl extends BaseDao implements consumerDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	/**(non-Javadoc)
	 * @see hotel.dao.impl.consumerDao#updateconsumer(String sql,Object[] param)
	 */
	@Override
	public int updateconsumer(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count = executeSQL(sql, param);
		return count;
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.consumerDao#findconsumer(String sql,String[] param)
	 */
	@Override
	public List<consumer> findconsumer(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<consumer> consumerList = new ArrayList<consumer>();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				consumer consume = new consumer();
				consume.setId(rs.getString(1));
				consume.setName(rs.getString(2));
				consume.setSex(ConsumerSex.valueOf(rs.getString(3)));
				
				consumerList.add(consume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return consumerList;

	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.consumerDao#findconsumer()
	 */
	@Override
	public List<consumer> findconsumer() {
		// TODO Auto-generated method stub
		List<consumer> consumerList = new ArrayList<consumer>();
		try {
			String preparedSql = "select * from consumer ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
				consumer consume = new consumer();
				consume.setId(rs.getString(1));
				consume.setName(rs.getString(2));
				consume.setSex(ConsumerSex.valueOf(rs.getString(3)));
				
				consumerList.add(consume);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return consumerList;
		
	}
}
