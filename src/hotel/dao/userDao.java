/**
 * 操作数据库管理员表接口
 * @author 张永彩
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.user;


public interface userDao {
	/**
	 * 查询所有管理员信息
	 * @return list<user>
	 */
	public abstract List<user> getAllUser();

	/**
	 * 更新管理员信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	public abstract int updateUser(String sql, String[] param);

	/**
	 * 根据条件查询管理员信息
	 * @param sql
	 * @param param
	 * @return user
	 */
	public abstract user selectUser(String sql, String[] param);

}
