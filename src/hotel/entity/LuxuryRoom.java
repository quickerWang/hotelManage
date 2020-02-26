/**
 * 豪华套房类，继承房间类
 * @author 杨晓桐
 * 2018-07-13
 */
package hotel.entity;

public class LuxuryRoom extends room{
	int room_num;//房间数
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public int getRoom_num() {
		return room_num;
	}
	
	/**
	 * 构造函数无参
	 */
	
	public LuxuryRoom() {
		
	}
	
	/**
	 * 构造函数有参
	 * @param no
	 * @param price
	 * @param state
	 * @param clean
	 * @param money
	 * @param room_num
	 */
	
	public LuxuryRoom(int no,double price,boolean state,boolean clean,int money,int room_num){
		super(no,price,state,clean,money);
		this.room_num=room_num;
	} 

	/**
	 * 计算总价，重写父类抽象函数
	 */
	@Override
	public double sum(int days) {
		// TODO Auto-generated method stub
		return days*getPrice()+100;    //豪华房人工费多100
	}
	

}
