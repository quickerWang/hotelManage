/**
 * 大床房类，继承房间类
 * @author 杨晓桐
 * 2018-07-13
 */
package hotel.entity;

import hotel.entity.RoomStyle;

public class BBRoom extends room{
	public RoomStyle style;//房间类型，枚举
	
	public void setStyle(RoomStyle style) {
		this.style = style;
	}

	public RoomStyle getStyle() {
		return style;
	}

	/**
	 * 构造函数无参
	 */
	public BBRoom() {
		
	}
	
	/**
	 * 构造函数有参
	 * @param no
	 * @param price
	 * @param state
	 * @param clean
	 * @param money
	 * @param style
	 */
	
	public BBRoom(int no,double price,boolean state,boolean clean,int money,RoomStyle style) {
		super(no,price,state,clean,money);
		this.style=style;
	}

	/**
	 * 计算总价，重写父类抽象函数
	 */
	
	@Override
	public double sum(int days) {
		// TODO Auto-generated method stub
		return days*getPrice();
	}}
