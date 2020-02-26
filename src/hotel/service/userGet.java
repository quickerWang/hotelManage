package hotel.service;

import hotel.entity.user;
/**
 * 
* @author 范艺蕊
 * 20180715
 * 得到指定的管理员信息
 */
public interface userGet {
	public abstract user selectuser(String sql, String[] param);
}
