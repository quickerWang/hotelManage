package hotel.service;

import java.util.List;

import hotel.entity.room;
/**
 * 
* @author ������
 * 20180715
 * �õ�ָ����room��Ϣ
 */
public interface RoomGet {
	public abstract List<room> getRoom();
	public abstract List<room> selectroom(String sql, String[] param);
}
