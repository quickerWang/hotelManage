/**
 * �������ݿ����Ա��ӿ�
 * @author ������
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.user;


public interface userDao {
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * @return list<user>
	 */
	public abstract List<user> getAllUser();

	/**
	 * ���¹���Ա��Ϣ��������ɾ��
	 * @param sql
	 * @param param
	 * @return 1��������� 0������ʧ��
	 */
	public abstract int updateUser(String sql, String[] param);

	/**
	 * ����������ѯ����Ա��Ϣ
	 * @param sql
	 * @param param
	 * @return user
	 */
	public abstract user selectUser(String sql, String[] param);

}
