/**
 * 房间类
 * @author 杨晓桐
 * 2018-07-13
 */
package hotel.entity;

public abstract class room {
	private int no;//房间号
	

	private double price;//房间价格
	private boolean state;//房间状态 0：未入住 1：入住
	private boolean clean;//是否打扫 0：已打扫 1：未打扫
	private int money;//押金
	
	public void setNo(int no) {
		this.no = no;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isClean() {
		return clean;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	public int getNo() {
		return no;
	}

	
	/**
	 *构造函数无参
	 */
	public room() {
		
	}
	
	/**
	 * 构造函数有参
	 * @param no
	 * @param price
	 * @param state
	 * @param clean
	 * @param money
	 */
	public room(int no,double price,boolean state,boolean clean,int money) {
		this.no=no;
		this.price=price;
		this.state=state;
		this.clean=clean;
		this.money=money;
		
	}
	
	/**
	 *计算总价
	 */
	public abstract double sum(int days);

}
