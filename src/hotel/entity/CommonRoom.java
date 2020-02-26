/**
 * 普通房类，继承房间类
 * @author 杨晓桐
 * 2018-07-13
 */
package hotel.entity;

public class CommonRoom extends room{
	private int num;//容纳人数
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}


	/**
	 * 构造函数无参
	 */
	public CommonRoom() {
		
	}
	
	/**
	 * 构造函数有参
	 * @param no
	 * @param price
	 * @param state
	 * @param clean
	 * @param money
	 * @param num
	 */

	public CommonRoom(int no,double price,boolean state,boolean clean,int money,int num) {
		super(no,price,state,clean,money);
		this.num=num;
	}
	
	/**
	 * 计算总价，重写父类抽象函数
	 */

	@Override
	public double sum(int days) {
		return days*getPrice();
		
		// TODO Auto-generated method stub
		
	}
	

}
