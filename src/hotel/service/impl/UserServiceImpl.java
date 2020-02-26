/**
 * @author 杨晓桐
 * 20180715
 * 用户服务
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
	 * @author 杨晓桐
	 * 20180715
	 * 确定能否登录
	 */
	public boolean login(String id, String password) {
		// TODO Auto-generated method stub
		boolean b=false;
    	
    	List<user> list=new ArrayList<user>();  //新建存储user的集合
		userDao user=new userDaoMYSQLimpl();  //得到userDao
		list=user.getAllUser();  //调用getAllUser()得到所有user信息
		for(user u:list) {  //遍历集合
		
		String pass_d=u.getPassword();  //得到密码
		String id_d=u.getId();  //得到账号
		if(pass_d.equals(password)&&id_d.equals(id)) {//与想登录的用户信息相符
			b=true;  //返回true
			break;  //跳出循环
		}
		}
		return b;
	}
	
}
