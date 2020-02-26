/**
 * @author 杨晓桐
 * 20180715
 * 面对客户的服务
 */
package hotel.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import hotel.dao.ListDao;
import hotel.dao.consumerDao;
import hotel.dao.userDao;
import hotel.dao.impl.ListDaoImpl;
import hotel.dao.impl.consumerDaoImpl;
import hotel.dao.impl.roomDaoMYSQLimpl;
import hotel.dao.impl.userDaoMYSQLimpl;
import hotel.entity.BBRoom;
import hotel.entity.CommonRoom;
import hotel.entity.LuxuryRoom;
import hotel.entity.RoomStyle;
import hotel.entity.consumer;
import hotel.entity.room;
import hotel.entity.user;
import hotel.service.Living;

public class LivingImpl implements Living{

	@Override
	public int clean(String []param) {
		String sql="update room set clean=0,state=0 where no=?";//sql语句
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //得到roomDaoMYSQLimpl对象
		
		rmdao.updateRoom(sql,param);  //调用update()函数改变数据库
		// TODO Auto-generated method stub
		return 0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}

	@Override
	public List<room> getRoom() {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<room> selectroom(String sql, String[] param) {
		
		ArrayList<room> a_room=new ArrayList<room>();
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();         //建立房间数据库查询的对象
		ArrayList<room> list=(ArrayList)rmdao.selectRoom(sql,param);    //查找未被打扫的房间
		for(int i=0;i<list.size();i++) {              //循环得到房间的各种属性
			int no=list.get(i).getNo();               //得到房间的房间号
			double price=list.get(i).getPrice();      //得到房间的价格
			boolean state=list.get(i).isState();      //得到房间的状态,是否已经住人
			boolean clean=list.get(i).isClean();      //得到房间的打扫状态，是否已经打扫
			int money=list.get(i).getMoney();         //得到房间的押金
			if(list.get(i) instanceof CommonRoom) {         //如果房间是普通房
				int num=((CommonRoom)list.get(i)).getNum();//得到房间人数
				room Room=new CommonRoom(no,price,state,clean,money,num);  //新建普通房赋值给room
				 a_room.add(Room);  //ROOM加入到集合中
			}
			else if(list.get(i) instanceof LuxuryRoom) {   //如果是豪华房
				int room_num=((LuxuryRoom)list.get(i)).getRoom_num();  //得房间数
				room Room=new LuxuryRoom(no,price,state,clean,money,room_num);  //新建豪华房赋值给room
				 a_room.add(Room);//room加入到集合中
			}
			else {  //如果是大床房
				String style=String.valueOf(((BBRoom)list.get(i)).getStyle());  //得到房间类型
				room Room=new BBRoom(no,price,state,clean,money,RoomStyle.valueOf(style));  //新建大床房赋值给room
				 a_room.add(Room);  //room加入到集合中
			}
		}
		return a_room;
	}

	
	public user selectuser(String sql, String[] param) {
		// TODO Auto-generated method stub
		return null;
	}


	public int roomExit(String[] param) {
		// TODO Auto-generated method stub
		String sql="update room set clean=1,state=0 where no=?";  //sql语句
        roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //得到 roomDaoMYSQLimpl()对象
		
		rmdao.updateRoom(sql,param);  //调用updateRoom函数改变数据库
		return 0;
	}

	@Override
	public int check(String[] param) {    //退房
		// TODO Auto-generated method stub
		String sql="update list set isEnded=1,money=money-?  where no=? and isEnded=0";  //sql语句
		ListDaoImpl list=new ListDaoImpl();  //得到ListDaoImpl对象
		int count=list.updateList(sql, param);  //调用updateList函数
		return count;
	}

	@Override
	public int checkconsumer(String[] param, String[] param1) {   //结账
		// TODO Auto-generated method stub
		String sql="select * from consumer where id=?";  //sql语句
		consumerDao consumerdao=new consumerDaoImpl();  //新建consumerDaoImpl对象
		List<consumer> list=consumerdao.findconsumer(sql,param);//调用findconsumer函数
		if(list.get(0)==null) {   //如果没有找到这样的用户
			sql="insert into consumer(id,name,sex) values(?,?,?)";  //将该用户信息插入	
			consumerdao.updateconsumer(sql,param1);
		}
		return 0;
	}

	@Override
	public int checkroom(String[] param) {
		// TODO Auto-generated method stub
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //新建roomDaoMYSQLimpl对象
		String sql="update room set state=1 where no=?";  //sql语句
		int count=rmdao.updateRoom(sql,param);  //更新数据库
		return count;
	}

	@Override
	public int cheaklist(String[] param) {
		// TODO Auto-generated method stub
		String sql="insert into list(id,no,start,days,isEnded,money) values(?,?,?,?,?,?)";  //list中插入数据
		ListDao listdao=new ListDaoImpl();  
		int count=listdao.updateList(sql, param);  //list中插入数据
		return 0;
	}

}
