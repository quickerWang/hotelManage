/**
 * 操作数据库房间表接口
 * @author 杨晓桐
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.room;


public interface roomDao {
	/**
	 * 查询所有房间信息
	 * @return list<room>
	 */
	public abstract List<room> getAllRoom();

	/**
	 * 根据所给条件查询房间信息
	 * @param sql
	 * @param param
	 * @return list<room>
	 */
	public abstract List<room> selectRoom(String sql, String[] param);

	/**
	 * 更新房间信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	public abstract int updateRoom(String sql, Object[] param);
	
}
