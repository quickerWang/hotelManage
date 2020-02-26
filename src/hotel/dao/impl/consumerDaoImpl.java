/**
 * �˿����ݿ������
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
import hotel.dao.consumerDao;
import hotel.entity.ConsumerSex;
import hotel.entity.consumer;
import hotel.entity.user;

public class consumerDaoImpl extends BaseDao implements consumerDao{
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
