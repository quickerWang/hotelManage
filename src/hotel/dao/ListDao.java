/**
 * �������ݿ��˵���ӿ�
 * @author ������
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.consumer;
import hotel.entity.list;

public interface ListDao {
	/**
	 * �����˵���Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	public abstract int updateList(String sql, Object[] param);
	
	/**
	 * ��ѯ�����˵���Ϣ
	 * @return list<list>
	 */
	public List<list> findList();
}
