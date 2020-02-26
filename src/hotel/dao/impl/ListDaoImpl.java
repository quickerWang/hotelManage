/**
 * 账单数据库操作类
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
import hotel.dao.ListDao;
import hotel.entity.consumer;
import hotel.entity.list;

public class ListDaoImpl extends BaseDao implements ListDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	/**(non-Javadoc)
	 * @see hotel.dao.impl.ListDao#updateList(String sql,Object[] param)
	 */
	@Override
	public int updateList(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count=executeSQL(sql, param);
		return count;
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.ListDao#findList()
	 */
	@Override
	public List<list> findList() {
		// TODO Auto-generated method stub
		List<list> liList = new ArrayList<list>();
		try {
			String preparedSql = "select * from list";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				list li = new list();
				li.setListno(rs.getInt("listno"));
				li.setDays(rs.getInt("days"));
				li.setStart(rs.getString("start"));
				li.setEnded(rs.getBoolean("isEnded"));
				li.setId(rs.getString("id"));
				li.setMoney(rs.getInt("money"));
				 liList.add(li);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return liList;
	}

}
