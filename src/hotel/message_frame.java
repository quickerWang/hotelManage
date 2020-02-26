/**
 * @author 王文萱
 * 20180715
 * 信息界面
 */

package hotel;

import hotel.entity.*;
import hotel.service.SystemService;
import hotel.service.impl.LivingImpl;
import hotel.service.impl.SystemServiceImpl;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;




public class message_frame extends JFrame{
	  
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH); //选项卡
	  
	    private JPanel  user_panel;  //用户信息面板
		SystemServiceImpl system=new SystemServiceImpl();
		/**
		 * @author 王文萱
		 * 20180715
		 * 界面基本属性设置
		 */
		public message_frame() {
        	setTitle("信息查询");  //title
            setSize(500,500);  //大小
       	    setLocationRelativeTo(null);  //是否居中
       	    setResizable(false);  //能否调节
  //加入一系列的面板到选项卡中
       	tabbedpane.add("管理员",get_user());
        tabbedpane.add("消费者",get_consumer());
       	tabbedpane.add("住宿消费单",get_list());
       	tabbedpane.add("房间",get_room());
       	add(tabbedpane,BorderLayout.CENTER);
       	
        }
		/**
		 * @author 王文萱
		 * 20180715
		 * 消费者面板
		 */
        private JPanel get_consumer() {
            JPanel consumer_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	name.add("身份证号");
        	name.add("姓名");
        	name.add("性别");   //表格列名
        
   
        
        	 
        	ArrayList<consumer> consumer_list=new ArrayList<consumer>();
        
        	consumer_list=system.getconsumer();
        	for(int i=0;i<consumer_list.size();i++) {   //读取数据库信息到表格
        		Vector<Object> v=new Vector<Object>();
        		v.add(consumer_list.get(i).getId());
        		v.add(consumer_list.get(i).getName());
        		v.add(consumer_list.get(i).getSex());
        		value.add(v);
        	}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //建立表格
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //scrolllpane加表格
			pane.setViewportView(table);
			consumer_panel.add(pane,BorderLayout.CENTER);   //scrollpane加入面板
        	return consumer_panel;
        }
        /**
		 * @author 王文萱
		 * 20180715
		 * 房间面板
		 */
        private JPanel get_room() {
            JPanel room_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>(); //表格列名
        	name.add("编号");
        	name.add("单价");
        	name.add("是否住人");
        	name.add("是否打扫");
        	name.add("押金");
        	name.add("房间数");
        	name.add("风格");
        	name.add("可住人数");
        	
			
        	ArrayList<room> a_room= new ArrayList<room>();
        	LivingImpl living=new LivingImpl();
        	String sql="select * from room";        //查找未被打扫的房间的sql语句
        	
        	String []s=new String[0];         //读取数据库信息到表格中
        	
        	a_room=(ArrayList)living.selectroom(sql, s);
     
    		
    		Iterator it=a_room.iterator();    //???????????
    		while(it.hasNext()) {
    			room r=(room)it.next();
    			
    			if(r instanceof BBRoom) {
    				BBRoom bbroom=(BBRoom)r;
    				Vector<Object> v=new Vector<Object>();
    				v.add(bbroom.getNo());
    				v.add(bbroom.getPrice());
    				v.add(bbroom.isState());
    				v.add(bbroom.isClean());
    				v.add(bbroom.getMoney());
    				v.add("无");
    				v.add(bbroom.getStyle().name());
    				v.add("无");
    				value.add(v);
    			}
    			if(r instanceof CommonRoom) {
    				CommonRoom commonroom=(CommonRoom)r;
    				Vector<Object> v=new Vector<Object>();
    				v.add(commonroom.getNo());
    				v.add(commonroom.getPrice());
    				v.add(commonroom.isState());
    				v.add(commonroom.isClean());
    				v.add(commonroom.getMoney());
    				v.add(commonroom.getNum());
    				v.add("无");
    				v.add("无");
    				value.add(v);
    			}
    			if(r instanceof LuxuryRoom) {
    				LuxuryRoom luxuryroom=(LuxuryRoom)r;
    				Vector<Object> v=new Vector<Object>();
    				v.add(luxuryroom.getNo());
    				v.add(luxuryroom.getPrice());
    				v.add(luxuryroom.isState());
    				v.add(luxuryroom.isClean());
    				v.add(luxuryroom.getMoney());
    				v.add("无");
    				v.add("无");
    				v.add(luxuryroom.getRoom_num());
    				value.add(v);
    			}
    		}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //建立表格模板
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //建立scrollpane加入表格
			pane.setViewportView(table);
			room_panel.add(pane,BorderLayout.CENTER);  //scrollpane加入面板
        	return room_panel;
        }
        /**
		 * @author 王文萱
		 * 20180715
		 * 消费单面板
		 */
        private JPanel get_list() {
            JPanel list_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();  //list列名
        	name.add("编号");
        	name.add("顾客身份证");
        	name.add("房间号");
        	name.add("开房时间");
        	name.add("开房天数");
        	name.add("客人是否离开");
        	name.add("消费总额");
        	
        	
        	ArrayList<list> li_list=new ArrayList<list>();
        	li_list=system.getlist();  //数据库信息读到表格
        	for(int i=0;i<li_list.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(li_list.get(i).getListno());
        		v.add(li_list.get(i).getId());
        		v.add(li_list.get(i).getNo());
        		v.add(li_list.get(i).getStart());
        		v.add(li_list.get(i).getDays());
        		v.add(li_list.get(i).isEnded());
        		v.add(li_list.get(i).getMoney());
        		value.add(v);
        	}
        	
      
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //表格建立
			JScrollPane pane=new JScrollPane();  
			pane.setViewportView(table);
			list_panel.add(pane,BorderLayout.CENTER);
        	return list_panel;
        }
        /**
		 * @author 王文萱
		 * 20180715
		 * 用户面板
		 */
        private JPanel get_user() {
        	user_panel=new JPanel();
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	
        	name.add("用户名");  //表格列名
        	name.add("密码");
        	
        
        	ArrayList<user> userlist=new ArrayList<user>();
        	userlist=system.getuser();  //数据库信息读到表格
        	for(int i=0;i<userlist.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(userlist.get(i).getId());
        		v.add(userlist.get(i).getPassword());
        		
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //表格建立
			JScrollPane pane=new JScrollPane();
			pane.setViewportView(table);
			user_panel.add(pane,BorderLayout.CENTER);
        	return user_panel;
        }
       
}
