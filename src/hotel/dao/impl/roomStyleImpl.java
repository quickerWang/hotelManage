/**
 * �����������ݿ������
 * @author ����ͩ
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
import hotel.dao.roomstyleDao;
import hotel.entity.room_style;

public class roomStyleImpl extends BaseDao implements roomstyleDao{
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����

	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomstyleDao#update(String sql,Object[] param)
	 */
	public int update(String sql, Object[] param) {
		// TODO Auto-generated method stub
		int count=executeSQL(sql, param);
		return count;
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomstyleDao#findRoomStyle()
	 */
	@Override
	public List<room_style> findRoomStyle() {
		// TODO Auto-generated method stub
		List<room_style> roomstyleList = new ArrayList<room_style>();
		try {
			String preparedSql = "select * from roomstyle ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {

				room_style room = new room_style();
				
				room.setPrice(rs.getDouble(1));
				room.setMoney(rs.getInt(2));
				room.setRoom_num(rs.getInt("room_num"));
				room.setStyle(rs.getString("style"));
				room.setNum(rs.getInt("num"));
				room.setId(rs.getInt("id"));
				
				roomstyleList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return roomstyleList;
		
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomstyleDao#findRoomstyle(String sql,String[]param)
	 */
	@Override
	public List<room_style> findRoomstyle(String sql, String[] param) {
		// TODO Auto-generated method stub
		List<room_style> roomstyleList = new ArrayList<room_style>();
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
				room_style room = new room_style();
				room.setPrice(rs.getDouble(1));
				room.setMoney(rs.getInt(2));
				room.setRoom_num(rs.getInt("room_num"));
				room.setStyle(rs.getString("style"));
				room.setNum(rs.getInt("num"));
				room.setId(rs.getInt("id"));
				roomstyleList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return roomstyleList;
	}

	
		
}
