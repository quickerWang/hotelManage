/**
 * 管理员数据库操作类
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
import hotel.dao.userDao;
import hotel.entity.user;

public class userDaoMYSQLimpl extends BaseDao implements userDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集

	/**(non-Javadoc)
	 * @see hotel.dao.impl.userDao#getAllUser()
	 */
	@Override
	public List<user> getAllUser() {
		List<user> userList = new ArrayList<user>();
		try {
		String preparedSql = "select * from user ";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				user u = new user();
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
				userList.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return userList;
		// TODO Auto-generated method stub
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.userDao#updateUser(String sql,String[] param)
	 */
	@Override
	public int updateUser(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
		// TODO Auto-generated method stub
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.userDao#selectUser(String sql,String[] param)
	 */
	@Override
	public user selectUser(String sql, String[] param) {
		user u = null;
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
				u = new user();
				u.setId(rs.getString(1));
				u.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return u;
		// TODO Auto-generated method stub
	}
	

}
