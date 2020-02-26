/**
 * @author ����ͩ
 * 20180715
 * ��Կͻ��ķ���
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
		String sql="update room set clean=0,state=0 where no=?";//sql���
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //�õ�roomDaoMYSQLimpl����
		
		rmdao.updateRoom(sql,param);  //����update()�����ı����ݿ�
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
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();         //�����������ݿ��ѯ�Ķ���
		ArrayList<room> list=(ArrayList)rmdao.selectRoom(sql,param);    //����δ����ɨ�ķ���
		for(int i=0;i<list.size();i++) {              //ѭ���õ�����ĸ�������
			int no=list.get(i).getNo();               //�õ�����ķ����
			double price=list.get(i).getPrice();      //�õ�����ļ۸�
			boolean state=list.get(i).isState();      //�õ������״̬,�Ƿ��Ѿ�ס��
			boolean clean=list.get(i).isClean();      //�õ�����Ĵ�ɨ״̬���Ƿ��Ѿ���ɨ
			int money=list.get(i).getMoney();         //�õ������Ѻ��
			if(list.get(i) instanceof CommonRoom) {         //�����������ͨ��
				int num=((CommonRoom)list.get(i)).getNum();//�õ���������
				room Room=new CommonRoom(no,price,state,clean,money,num);  //�½���ͨ����ֵ��room
				 a_room.add(Room);  //ROOM���뵽������
			}
			else if(list.get(i) instanceof LuxuryRoom) {   //����Ǻ�����
				int room_num=((LuxuryRoom)list.get(i)).getRoom_num();  //�÷�����
				room Room=new LuxuryRoom(no,price,state,clean,money,room_num);  //�½���������ֵ��room
				 a_room.add(Room);//room���뵽������
			}
			else {  //����Ǵ󴲷�
				String style=String.valueOf(((BBRoom)list.get(i)).getStyle());  //�õ���������
				room Room=new BBRoom(no,price,state,clean,money,RoomStyle.valueOf(style));  //�½��󴲷���ֵ��room
				 a_room.add(Room);  //room���뵽������
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
		String sql="update room set clean=1,state=0 where no=?";  //sql���
        roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //�õ� roomDaoMYSQLimpl()����
		
		rmdao.updateRoom(sql,param);  //����updateRoom�����ı����ݿ�
		return 0;
	}

	@Override
	public int check(String[] param) {    //�˷�
		// TODO Auto-generated method stub
		String sql="update list set isEnded=1,money=money-?  where no=? and isEnded=0";  //sql���
		ListDaoImpl list=new ListDaoImpl();  //�õ�ListDaoImpl����
		int count=list.updateList(sql, param);  //����updateList����
		return count;
	}

	@Override
	public int checkconsumer(String[] param, String[] param1) {   //����
		// TODO Auto-generated method stub
		String sql="select * from consumer where id=?";  //sql���
		consumerDao consumerdao=new consumerDaoImpl();  //�½�consumerDaoImpl����
		List<consumer> list=consumerdao.findconsumer(sql,param);//����findconsumer����
		if(list.get(0)==null) {   //���û���ҵ��������û�
			sql="insert into consumer(id,name,sex) values(?,?,?)";  //�����û���Ϣ����	
			consumerdao.updateconsumer(sql,param1);
		}
		return 0;
	}

	@Override
	public int checkroom(String[] param) {
		// TODO Auto-generated method stub
		roomDaoMYSQLimpl rmdao=new roomDaoMYSQLimpl();  //�½�roomDaoMYSQLimpl����
		String sql="update room set state=1 where no=?";  //sql���
		int count=rmdao.updateRoom(sql,param);  //�������ݿ�
		return count;
	}

	@Override
	public int cheaklist(String[] param) {
		// TODO Auto-generated method stub
		String sql="insert into list(id,no,start,days,isEnded,money) values(?,?,?,?,?,?)";  //list�в�������
		ListDao listdao=new ListDaoImpl();  
		int count=listdao.updateList(sql, param);  //list�в�������
		return 0;
	}

}
