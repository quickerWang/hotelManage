/**
 * @author ����ͩ
 * 20180715
 * �û�����
 */

package hotel.service.impl;
import java.util.ArrayList;
import java.util.List;

import hotel.dao.userDao;
import hotel.dao.impl.userDaoMYSQLimpl;
import hotel.entity.user;
import hotel.service.*;
public class UserServiceImpl implements UserService{

	@Override
	/**
	 * @author ����ͩ
	 * 20180715
	 * ȷ���ܷ��¼
	 */
	public boolean login(String id, String password) {
		// TODO Auto-generated method stub
		boolean b=false;
    	
    	List<user> list=new ArrayList<user>();  //�½��洢user�ļ���
		userDao user=new userDaoMYSQLimpl();  //�õ�userDao
		list=user.getAllUser();  //����getAllUser()�õ�����user��Ϣ
		for(user u:list) {  //��������
		
		String pass_d=u.getPassword();  //�õ�����
		String id_d=u.getId();  //�õ��˺�
		if(pass_d.equals(password)&&id_d.equals(id)) {//�����¼���û���Ϣ���
			b=true;  //����true
			break;  //����ѭ��
		}
		}
		return b;
	}
	
}
