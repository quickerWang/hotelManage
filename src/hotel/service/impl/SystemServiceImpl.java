/**
 * @author ������
 * 20180715
 * ϵͳ����
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
		double sum=0;  //�ս�
		String sql="select * from list";  //�õ��������ѵ���Ϣ
			ListDaoImpl listdao=new ListDaoImpl(); //�½�ListDaoImpl����
			ArrayList<list> list=(ArrayList)listdao.findList();  //�ҵ��������ѵ���Ϣ
			for(int i=0;i<list.size();i++) {  //ѭ��
				String sh=list.get(i).getStart();  //�õ������е�������
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
			
			if(sh2.equals(s[1])&&sh1.equals(s[0])&&sh3.equals(s[2])) {  //�ʹ���������Ϣ��ͬʱ
				sum+=list.get(i).getMoney();  //�ۼ����Ѷ�
			}
			}
		return sum;
	}

	@Override
	public double summonth(String[] s) {
		// TODO Auto-generated method stub
		double sum=0;  //�½�
		String sql="select * from list";
			ListDaoImpl listdao=new ListDaoImpl();  //�½�ListDaoImpl����
			ArrayList<list> list=(ArrayList)listdao.findList();  //�ҵ��������ѵ���Ϣ
			for(int i=0;i<list.size();i++) {  //ѭ��
				String sh=list.get(i).getStart();  //�õ����ѵ��е�������
			String sh1=sh.substring(0, 4);
			String sh2;
			if(sh.charAt(6)<'0'||sh.charAt(6)>'9') {
				sh2=sh.substring(5,6);
			}else {
				sh2=sh.substring(5,7);
			}
		
			if(sh2.equals(s[1])&&sh1.equals(s[0])) {  //�봫��������Ϣ��ͬ
				sum+=list.get(i).getMoney();  //�ۼ����Ѷ�
			}
			}
		return sum;
	}

	@Override
	public double sumyear(String[] s) {
		// TODO Auto-generated method stub
		double sum=0;  //���
		ListDaoImpl listdao=new ListDaoImpl();  //�½�ListDaoImpl����
			ArrayList<list> list=(ArrayList)listdao.findList();  //�ҵ��������ѵ���Ϣ
			for(int i=0;i<list.size();i++) {  //ѭ��
				String sh=list.get(i).getStart();  //�õ�����Ϣ
			String sh1=sh.substring(0, 4);
			if(sh1.equals(s[0])) {  //�봫��������Ϣ���
				sum+=list.get(i).getMoney();  //�ۼ����Ѷ�
			}
			}
		return sum;
	}

	@Override
	public ArrayList<room_style> getroomstyle() {
		// TODO Auto-generated method stub
roomStyleImpl roomStyle=new roomStyleImpl();  
		
		ArrayList<room_style> room1=(ArrayList)roomStyle.findRoomStyle();  //�õ����з�������Ϣ
		return room1;
	}

	@Override
	public ArrayList<list> getlist() {
		// TODO Auto-generated method stub
		ListDaoImpl li=new ListDaoImpl();  
    	ArrayList<list> li_list=new ArrayList<list>();
    	li_list=(ArrayList)li.findList();  //�õ��������ѵ���Ϣ

		return li_list;
	}

	@Override
	public ArrayList<consumer> getconsumer() {
		// TODO Auto-generated method stub
		consumerDaoImpl consumer=new consumerDaoImpl();
   	 
    	ArrayList<consumer> consumer_list=new ArrayList<consumer>();
    	consumer_list=(ArrayList)consumer.findconsumer();  //�õ����п�����Ϣ
		return consumer_list;
	}

	@Override
	public ArrayList<user> getuser() {
		userDaoMYSQLimpl user=new userDaoMYSQLimpl();
    	ArrayList<user> userlist=new ArrayList<user>();
    	userlist=(ArrayList)user.getAllUser(); //�õ������û���Ϣ
		// TODO Auto-generated method stub
		return userlist;
	}

	@Override
	public boolean adduser(String[] s,String[]s2) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s);  //�û�����Ѱ�ҷ���������user��Ϣ
		if(u==null) {  //û���ҵ���������Ϣ
			
			sql="insert into user values(?,?)";
			
			userdao.updateUser(sql,s2);  //������û���Ϣ
			return true;  //����true
		}
		else {
			return false;  //����false
		}
		
	}

	@Override
	public boolean updateuser(String[] s1, String[] s2) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=? and password=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s1);   //���������������û���Ϣ
		if(u!=null) {  //�ҵ��������û�
			sql="update user set password=? where id=?";
			userdao.updateUser(sql,s2);  //���¸��û�������
			return true;  //����true
		}
		else {
			return false;  //����false
		}
		
	}

	@Override
	public boolean deleteuser(String[] s) {
		// TODO Auto-generated method stub
		String sql="select * from user where id=? and password=?";
		userDaoMYSQLimpl userdao=new userDaoMYSQLimpl();
		user u=userdao.selectUser(sql,s);  //���ҷ����������û���Ϣ
		if(u!=null) {  ///�ҵ����������û�
			sql="delete from user where id=? and password=?";
			userdao.updateUser(sql,s);  //ɾ�����û���Ϣ
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void adroom(String[] sh,int no) {
		List<room_style> list=new ArrayList<room_style>();
		roomstyleDao rmdao=new roomStyleImpl();
		String sql="select * from roomstyle where id=?";  //������Ӧ�ķ�����
		
		list=rmdao.findRoomstyle(sql,sh);
		String []s=new String[6];
		roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
		sql="insert into room values(?,?,false,false,?,?,?,?)";  //����Ӧ�ķ������䷿������Ϣ���뷿���
		room_style r=new room_style();
		r=list.get(0);
		s[0]=String.valueOf(no);
		s[1]=String.valueOf(r.getPrice());
		s[2]=String.valueOf(r.getMoney());
		if(r.getRoom_num()==0) {   //���Ǻ�����
			s[3]=null;
		}
		else {
			s[3]=String.valueOf(r.getRoom_num());
		}
		if(r.getStyle()!=null) {  //���Ǵ󴲷�
			s[4]=null;
		}
		else {
			s[4]=r.getStyle();
		}
		if(r.getNum()==0) {  //������ͨ��
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
		//����roomstyle��ķ����Ǯ
		if(index==1||index==2||index==3) {  //��ͨ��
			sql="update room set price=? where num=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=String.valueOf(index);
			rm.updateRoom(sql,s);  //���·�����еļ۸�
		}
		if(index==4||index==5||index==6||index==7) { //�󴲷�
			sql="update room set price=? where style=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=sh[index-4];
			rm.updateRoom(sql,s);//���·�����еļ۸�
		}
		if(index==8||index==9) {  //������
			sql="update room set price=? where room_num=?";
			roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
			s[0]=String.valueOf(p);
			s[1]=String.valueOf(index-5);
			rm.updateRoom(sql,s);//���·�����еļ۸�
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteroom(String[] s) {
		// TODO Auto-generated method stub
		roomDaoMYSQLimpl rm=new roomDaoMYSQLimpl();
		String sql="delete from room where no=?";
		
		int n=rm.updateRoom(sql,s);  //ɾ��������Ϣ�ķ���
		if(n==0) {  //ɾ�����ɹ�
			return false;
		}else {  ///ɾ���ɹ�
			return true;
		}
	}

}
