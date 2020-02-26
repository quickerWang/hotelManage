/**
 * 房间类型类
 * @author 杨晓桐
 * 2018-07-13
 */
package hotel.entity;

public class room_style {
	double price;//房间价格
	int money;//押金
	int room_num;//豪华套房房间数
	String style;//房间类型，普通房or大床房or豪华套房
	int num;//容纳人数
	int id;//房间号
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
