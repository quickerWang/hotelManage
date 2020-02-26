/**
 * 操作数据库顾客表接口
 * @author 张永彩
 * 2018-07-15
 */
package hotel.dao;


import java.util.List;


import hotel.entity.consumer;
import hotel.entity.user;

public interface consumerDao {
	/**
	 * 更新顾客信息，包括增删改
	 * @param sql
	 * @param param
	 * @return 1：更新完成 0：更新失败
	 */
	int updateconsumer(String sql, Object[] param);
	
	/**
	 * 查询所有顾客信息
	 * @return list<consumer>
	 */
	public List<consumer> findconsumer();
	
	/**
	 * 根据所给条件查询顾客信息
	 * @param sql
	 * @param param
	 * @return list<consumer>
	 */
	public List<consumer> findconsumer(String sql, String[] param);
}
