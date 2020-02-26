/**
 * 顾客类
 * @author 范艺蕊
 * 2017-08-13
 */
package hotel.entity;

import hotel.entity.*;

public class consumer {
	String name;//名字
	String id;//身份证号
	public ConsumerSex sex;//性别 枚举
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ConsumerSex getSex() {
		return sex;
	}

	public void setSex(ConsumerSex sex) {
		this.sex = sex;
	}

	
	
	/**
	 * 构造函数无参
	 */
	public consumer() {
		
	}
	
	/**
	 * 构造函数有参
	 * @param name
	 * @param id
	 * @param sex
	 */
	
	public consumer(String name,String id,ConsumerSex sex) {
		this.name=name;
		this.id=id;
		this.sex=sex;
	}

}
