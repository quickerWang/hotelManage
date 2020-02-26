/**
 * @author 范艺蕊
 * 20180715
 * 系统服务
 */

package hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hotel.dao.roomstyleDao;
import hotel.dao.impl.ListDaoImpl;
import hotel.dao.impl.consumerDaoImpl;
import hotel.dao.impl.roomDaoMYSQLimpl;
import hotel.dao.impl.roomStyleImpl;
import hotel.dao.impl.userDaoMYSQLimpl;
import hotel.entity.consumer;
import hotel.entity.list;
import hotel.entity.room_style;
import hotel.entity.user;
import hotel.service.SystemService;

public class SystemServiceImpl implements SystemService{

	

	@Override
	public double sumday(String[] s) {
		// TODO Auto-generated method stub
		double sum=0;  //日结
		String sql="select * from list";  //得到所有消费单信息
			ListDaoImpl listdao=new ListDaoImpl(); //新建ListDaoImpl对象
			ArrayList<list> list=(ArrayList)listdao.findList();  //找到所有消费但信息
			for(int i=0;i<list.size();i++) {  //循环
				String sh=list.get(i).getStart();  //得到订单中的年月日
				String sh1=sh.substring(0,4);
				String sh2;
				String sh3;
				if(sh.charAt(6)<'0'||sh.charAt(6)>'9') {
				sh2=sh.substring(5,6);
				if(sh.charAt(8)<'0'||sh.charAt(8)>'9') {
					sh3=sh.substring(7,8);
				}else {
					sh3=sh.substring(7,9);
				}
			}else {
				sh2=sh.substring(5,7);
                if(sh.charAt(9)<'0'||sh.charAt(9)>'9') {
                	sh3=sh.substring(8,9);
				}else {
					sh3=sh.substring(8,10);
				}
			}
			
			if(sh2.equals(s[1])&&sh1.equals(s[0])&&sh3.equals(s[2])) {  //和传进来的信息相同时
				sum+=list.get(i).getMoney();  //累加消费额
			}
			}
		return sum;
	}

	@Override
	public double summonth(String[] s) {
		// TODO Auto-generated method stub
		double sum=0;  //月结
		String sql="select * from list";
			ListDaoImpl listdao=new ListDaoImpl();  //新建ListDaoImpl对象
			ArrayList<list> list=(ArrayList)listdao.findList();  //找到所有消费单信息
			for(int i=0;i<list.size();i++) {  //循环
				String sh=list.get(i).getStart();  //得到消费但中的年月日
			String sh1=sh.substring(0, 4);
			String sh2;
			if(sh.charAt(6)<'0'||sh.charAt(6)>'9') {
				sh2=sh.substring(5,6);
			}else {
				sh2=sh.substring(5,7);
			}
		
			if(sh2.equals(s[1])&&sh1.equals(s[0])) {  //与传进来的信息相同
				sum+=list.get(i).getMoney();  //累加消费额
			}
			}
		return sum;
	}

	@Override
	public double sumyear(String[] s) {
		// TODO Auto-generated method stub
		double sum=0;  //年结
		ListDaoImpl listdao=new ListDaoImpl();  //新建ListDaoImpl对象
			ArrayList<list> list=(ArrayList)listdao.findList();  //找到所有消费但信息
			for(int i=0;i<list.size();i++) {  //循环
				String sh=list.get(i).getStart();  //得到年信息
			String sh1=sh.substring(0, 4);
			if(sh1.equals(s[0])) {  //与传进来的信息相符
				sum+=list.get(i).getMoney();  //累加消费额
			}
			}
		return sum;
	}

	@Override
	public ArrayList<room_style> getroomstyle() {
		// TODO Auto-generated method stub
roomStyleImpl roomStyle=new roomStyleImpl();  
		
		ArrayList<room_style> room1=(ArrayList)roomStyle.findRoomStyle();  //得到所有房间风格信息
		return room1;
	}

	@Override
	public ArrayList<list> getlist() {
		// TODO Auto-generated method stub
		ListDaoImpl li=new ListDaoImpl();  
    	ArrayList<list> li_list=new ArrayList<list>();
    	li_list=(ArrayList)li.findList();  //得到所有消费单信息

		return li_list;
	}

	@Override
	public ArrayList<consumer> getconsumer() {
		// TODO Auto-generated method stub
		consumerDaoImpl consumer=new consumerDaoImpl();
   	 
    	ArrayList<consumer> consumer_list=new ArrayList<consumer>();
    	consumer_list=(ArrayList)consumer.findconsumer();  //得到所有客人信息
		return consumer_list;
	}

	@Override
	public ArrayList<user> getuser() {
		userDaoMYSQLimpl user=new userDaoMYSQLimpl();
    	ArrayList<user> userlist=new ArrayList<user>();
    	userlist=(ArrayList)user.getAllUser(); //得到所有用户信息
		// TODO Auto-generated method stub
		return userlist;
	}

	@Override
	public boolean adduser(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s);  //用户表中寻找符合条件的user信息
		if(u==null) {  //没有找到这样的信息
			
			sql="insert into user values(?,?)";
			
			userdao.updateUser(sql,s2);  //插入该用户信息
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}
		
	}

	@Override
	public boolean updateuser(String[] s1, String[] s2) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=? and password=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s1);   //朝朝符合条件的用户信息
		if(u!=null) {  //找到这样的用户
			sql="update user set password=? where id=?";
			userdao.updateUser(sql,s2);  //更新该用户的密码
			return true;  //返回true
		}
		else {
			return false;  //返回false
		}
		
	}

	@Override
	public boolean deleteuser(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=? and password=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s);  //查找符合条件的用户信息
		if(u!=null) {  ///找到了这样的用户
			sql="delete from user where id=? and password=?";
			userdao.updateUser(sql,s);  //删除该用户信息
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void adroom(String[] sh,int no) {
		List<room_style> list=new ArrayList<room_style>();
		roomstyleDao rmdao=new roomStyleImpl();
		String sql="select * from roomstyle where id=?";  //查找相应的房间风格
		
		list=rmdao.findRoomstyle(sql,sh);
		String []s=new String[6];
		roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
		sql="insert into room values(?,?,false,false,?,?,?,?)";  //将相应的房间结合其房间风格信息插入房间表
		room_style r=new room_style();
		r=list.get(0);
		s[0]=String.valueOf(no);
		s[1]=String.valueOf(r.getPrice());
		s[2]=String.valueOf(r.getMoney());
		if(r.getRoom_num()==0) {   //不是豪华房
			s[3]=null;
		}
		else {
			s[3]=String.valueOf(r.getRoom_num());
		}
		if(r.getStyle()!=null) {  //不是大床房
			s[4]=null;
		}
		else {
			s[4]=r.getStyle();
		}
		if(r.getNum()==0) {  //不是普通房
			s[5]=null;
		}
		else {
			s[5]=String.valueOf(r.getNum());
		}
		rm.updateRoom(sql,s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateroom(String []sh,String[] s, int no, double p,int index) {
		String sql="update roomstyle set price=? where id=?";
		roomstyleDao rmdao=new roomStyleImpl();
		rmdao.update(sql,s);     
		//更新roomstyle表的房间价钱
		if(index==1||index==2||index==3) {  //普通房
			sql="update room set price=? where num=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=String.valueOf(index);
			rm.updateRoom(sql,s);  //更新房间表中的价格
		}
		if(index==4||index==5||index==6||index==7) { //大床房
			sql="update room set price=? where style=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=sh[index-4];
			rm.updateRoom(sql,s);//更新房间表中的价格
		}
		if(index==8||index==9) {  //豪华房
			sql="update room set price=? where room_num=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=String.valueOf(index-5);
			rm.updateRoom(sql,s);//更新房间表中的价格
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteroom(String[] s) {
		// TODO Auto-generated method stub
		roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
		String sql="delete from room where no=?";
		
		int n=rm.updateRoom(sql,s);  //删除符合信息的房间
		if(n==0) {  //删除不成功
			return false;
		}else {  ///删除成功
			return true;
		}
	}

}
