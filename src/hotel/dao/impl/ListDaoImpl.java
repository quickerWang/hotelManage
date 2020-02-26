/**
 * �˵����ݿ������
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
import hotel.dao.ListDao;
import hotel.entity.consumer;
import hotel.entity.list;

public class ListDaoImpl extends BaseDao implements ListDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
