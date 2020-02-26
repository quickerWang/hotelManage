/**
 * 操作数据库账单表接口
 * @author 张永彩
 * 2018-07-15
 */
package hotel.dao;

import java.util.List;

import hotel.entity.consumer;
import hotel.entity.list;

public interface ListDao {
	/**
	 * 更新账单信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	public abstract int updateList(String sql, Object[] param);
	
	/**
	 * 查询所有账单信息
	 * @return list<list>
	 */
	public List<list> findList();
}
