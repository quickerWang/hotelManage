/**
 * 操作数据库房间类型表接口
 * @author 杨晓桐
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.consumer;
import hotel.entity.room_style;

public interface roomstyleDao {
	/**
	 * 更新房间类型信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1:更新成功 0：更新失败
	 */
	int update(String sql, Object[] param);
	
	/**
	 * 查询所有房间类型信息
	 * @return list<room_style>
	 */
	List<room_style> findRoomStyle();
	
	/**
	 * 根据所给条件查询房间类型信息
	 * @param sql
	 * @param param
	 * @return list<room_style>
	 */
	List<room_style> findRoomstyle(String sql, String[] param);
}
