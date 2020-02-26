package hotel.service;

import java.util.List;

import hotel.entity.room;
/**
 * 
* @author 范艺蕊
 * 20180715
 * 得到指定的room信息
 */
public interface RoomGet {
	public abstract List<room> getRoom();
	public abstract List<room> selectroom(String sql, String[] param);
}
