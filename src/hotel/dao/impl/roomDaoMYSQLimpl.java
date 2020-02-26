/**
 * 房间数据库操作类
 * @author 杨晓桐
 * 2018-08-16
 */
package hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.BaseDao;
import hotel.dao.roomDao;
import hotel.entity.RoomStyle;
import hotel.entity.BBRoom;
import hotel.entity.CommonRoom;
import hotel.entity.LuxuryRoom;
import hotel.entity.room;

public class roomDaoMYSQLimpl extends BaseDao implements roomDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集


	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomDao#getAllRoom()
	 */
	@Override
	public List<room> getAllRoom() {
		List<room> roomList = new ArrayList<room>();
		try {
			String preparedSql = "select * from room ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {
                if(rs.getInt("num")!=0) {
                	CommonRoom r = new CommonRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setNum(rs.getInt("num"));
				    roomList.add(r);
                }
                if(rs.getString("style")!=null) {
                	BBRoom r=new BBRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setStyle(RoomStyle.valueOf((rs.getString("style"))));
				    roomList.add(r);
                }
                if(rs.getInt("Room_num")!=0) {
                	LuxuryRoom r=new LuxuryRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setRoom_num(rs.getInt("Room_num"));
				    roomList.add(r);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return roomList;
		// TODO Auto-generated method stub
	}


	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomDao#selectRoom(String sql,String[] param)
	 */
	@Override
	public List<room> selectRoom(String sql, String[] param) {
		List<room> roomList = new ArrayList<room>();
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1,param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				if(rs.getInt("num")!=0) {
                	CommonRoom r = new CommonRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setNum(rs.getInt("num"));
				    roomList.add(r);
                }
                if(rs.getString("style")!=null) {
                	BBRoom r=new BBRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setStyle(RoomStyle.valueOf((rs.getString("style"))));
				    roomList.add(r);
                }
                if(rs.getInt("Room_num")!=0) {
                	LuxuryRoom r=new LuxuryRoom();
                	r.setNo(rs.getInt(1));
				    r.setPrice(rs.getInt(2));
				    r.setState(rs.getBoolean(3));
				    r.setClean(rs.getBoolean(4));
				    r.setMoney(rs.getInt(5));
				    r.setRoom_num(rs.getInt("Room_num"));
				    roomList.add(r);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return roomList;
		// TODO Auto-generated method stub
	}

	/**(non-Javadoc)
	 * @see hotel.dao.impl.roomDao#updateRoom(String sql,Object[] param)
	 */
	@Override
	public int updateRoom(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
		// TODO Auto-generated method stub
	}

	

}
