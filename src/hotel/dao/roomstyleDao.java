/**
 * �������ݿⷿ�����ͱ�ӿ�
 * @author ����ͩ
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.consumer;
import hotel.entity.room_style;

public interface roomstyleDao {
	/**
	 * ���·���������Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1:���³ɹ� 0������ʧ��
	 */
	int update(String sql, Object[] param);
	
	/**
	 * ��ѯ���з���������Ϣ
	 * @return list<room_style>
	 */
	List<room_style> findRoomStyle();
	
	/**
	 * ��������������ѯ����������Ϣ
	 * @param sql
	 * @param param
	 * @return list<room_style>
	 */
	List<room_style> findRoomstyle(String sql, String[] param);
}
