/**
 * �������ݿ�˿ͱ�ӿ�
 * @author ������
 * 2018-07-15
 */
package hotel.dao;


import java.util.List;


import hotel.entity.consumer;
import hotel.entity.user;

public interface consumerDao {
	/**
	 * ���¹˿���Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	int updateconsumer(String sql, Object[] param);
	
	/**
	 * ��ѯ���й˿���Ϣ
	 * @return list<consumer>
	 */
	public List<consumer> findconsumer();
	
	/**
	 * ��������������ѯ�˿���Ϣ
	 * @param sql
	 * @param param
	 * @return list<consumer>
	 */
	public List<consumer> findconsumer(String sql, String[] param);
}
