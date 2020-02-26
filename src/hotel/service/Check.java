package hotel.service;
/**
 * 继承Check_list,Check_consumer接口
 * @author 杨晓桐
 * 20180715
 * 结账时操作
 */
public interface Check extends Check_list,Check_Consumer{
	public int checkroom(String []param);      //结账时更改room表数据
}
