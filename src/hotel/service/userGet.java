package hotel.service;

import hotel.entity.user;
/**
 * 
* @author ������
 * 20180715
 * �õ�ָ���Ĺ���Ա��Ϣ
 */
public interface userGet {
	public abstract user selectuser(String sql, String[] param);
}
