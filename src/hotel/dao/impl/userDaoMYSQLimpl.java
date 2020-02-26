/**
 * ����Ա���ݿ������
 * @author ������
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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/**(non-Javadoc)
	 * @see hotel.dao.impl.userDao#getAllUser()
	 */
	@Override
	public List<user> getAllUser() {
		List<user> userList = new ArrayList<user>();
		try {
		String preparedSql = "select * from user ";
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
		rs = pstmt.executeQuery(); // ִ��SQL���
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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
