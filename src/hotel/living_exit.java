/**
 * @author 孙思佳
 * 退房页面
 * 20180713
 */

package hotel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import hotel.entity.BBRoom;
import hotel.entity.CommonRoom;
import hotel.entity.LuxuryRoom;
import hotel.entity.RoomStyle;
import hotel.entity.consumer;
import hotel.entity.room;
import hotel.service.Living;
import hotel.service.impl.LivingImpl;

public class living_exit extends JFrame{
	
	 String[] s={ "房间 号", "价  格", "押  金", "人  数",
				"房间主题", "套房数"};   //表格列名数组
	 JLabel topLabel;            //头顶图片
	 JSplitPane splitpane=new JSplitPane();     //中间分割面板
	 JPanel topPane=new JPanel();               // 中间分割面板左边表格

	 DefaultTableModel lefttablemodel;         //左面表格面板
	
	 Vector<String> foodcolumnNames=new Vector<String>();     //记录房间表格列名
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //记录房间表格信息
	
	 
	 ArrayList<room> a_room=new ArrayList<room>();   //得到存数组信息的ArrayList
	 JTable lefttabel;     //表格对象
	 /**
	  * @author 孙思佳
	  * 20180713
	  *界面的基本属性，如大小的设置
	  */
	 public living_exit() {      
		 setResizable(false);    //设置为不可调节
		 setLocationRelativeTo(null);   //设置页面居中
		 setSize(400,300);       //设置界面大小
		 setLayout(new BorderLayout());    //设置布局为边界布局
     getContentPane().add(topPane,BorderLayout.NORTH);     //将topPane面板加入到界面中北面
	topPane.setLayout(new BorderLayout());                //设置topPane为边界布局
	topPane.add(new JLabel("房间"),BorderLayout.NORTH);    //将房间标签加到topPane的北面
	for(int i=0;i<s.length;i++) {       //表格列名载入
		foodcolumnNames.add(s[i]);
	}
    
	
      
	
	
	
	String sql="select * from room where state=1";   //查找已经住人的room的sql语句
	String []s=new String[0];                        
	LivingImpl living=new LivingImpl();    //得到服务的对象
	a_room=(ArrayList)living.selectroom(sql, s);     //调用selectroom()方法得到已经住人的room集合
	

	Iterator it=a_room.iterator();     //得到ArrayList的迭代器
	while(it.hasNext()) {      //循环读取room数据到表格中
		room r=(room)it.next();   //得到room对象
		
		if(r instanceof BBRoom) {     //如果该房间是大床房
			BBRoom bbroom=(BBRoom)r;   //将房间强制转换成大床房类型
			Vector<Object> v=new Vector<Object>();    //向量装入房间信息
			v.add(bbroom.getNo());      //房间号加入向量中
			v.add(bbroom.getPrice());   //房间价格加入向量
			v.add(bbroom.getMoney());   //房间押金加入向量
			v.add("无");                //没有房间人数
			v.add(bbroom.getStyle().name());   //房间风格加入向量
			v.add("无");                //没有房间数
			foodtablevalues.add(v);     //将该向量放到表格数据中
		}
		if(r instanceof CommonRoom) {   //如果该房间是普通房
			CommonRoom commonroom=(CommonRoom)r;   //将房间强制转换成普通房
			Vector<Object> v=new Vector<Object>();   //建立向量存房间数据
			v.add(commonroom.getNo());     //房间号加入向量
			v.add(commonroom.getPrice());  //房间价格加入向量
			v.add(commonroom.getMoney());  //房间押金加入向量
			v.add(commonroom.getNum());    //房间人数加入向量
			v.add("无");                   //没有房间风格
			v.add("无");                   //没有房间数
			foodtablevalues.add(v);        //将该向量放到表格数据中
		}
		if(r instanceof LuxuryRoom) {    //如果该房间是豪华间
			LuxuryRoom luxuryroom=(LuxuryRoom)r;   //将房间强制转换成豪华房
			Vector<Object> v=new Vector<Object>();  //建立向量存房间数据
			v.add(luxuryroom.getNo());     //房间号加入向量
			v.add(luxuryroom.getPrice());  //房间价格放入向量
			v.add(luxuryroom.getMoney());  //房价押金放入向量
			v.add("无");       //没有房间人数
			v.add("无");       //没有房间风格
			v.add(luxuryroom.getRoom_num());   //房间数加入向量
			foodtablevalues.add(v);     //将该向量放入表格数据中
		}
	}
	lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //利用foodcolumnNames为列名，foodtablevalues为表格数据建立表格模型
	lefttabel=new JTable(lefttablemodel);//利用该表格模型建立表格
	lefttabel.addMouseListener(new MouseAdapter() {   //添加鼠标点击事件
	
		@Override
		public void mouseClicked(MouseEvent e) {    //鼠标点击时发生的事件
			// TODO Auto-generated method stub  
			int selectedRow=lefttabel.getSelectedRow();   //得到选择的表格行数
			int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());  //得到该行房间信息的房间号
			int ya=Integer.parseInt(lefttabel.getValueAt(selectedRow, 2).toString());   //得到该行房间信息的押金
		
			String []s={String.valueOf(room_no)};        //建立包含一个房间号字符串的字符串数组
			LivingImpl living=new LivingImpl();    //得到相应服务对象
			living.roomExit(s);      //调用roomExit函数改变房间状态
			
			String []sh={String.valueOf(ya),String.valueOf(room_no)};   //建立包含房间号字符串，押金字符串的字符串数组
			living.check(sh);        //调用check函数改变消费单状态
			for(int i=0;i<foodtablevalues.size();i++) {   //循环查询表格中数据
				if(foodtablevalues.get(i).get(0)==lefttabel.getValueAt(selectedRow, 0)) {   //从表格中删除刚刚退房的房间信息
					foodtablevalues.remove(i);
					break;   //找到这样的房间信息后，跳出循环
				}
			}
			lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);   //以foodcolumnNames为列名，foodtablevalues为表格数据建立表格模型
			JOptionPane.showMessageDialog(null, "退出成功");  //显示退出成功
		}
	});
	
	JScrollPane scrollpane=new JScrollPane();   //得到JScrollPane
	scrollpane.setViewportView(lefttabel);  //将表格加入JScrollPane中
	topPane.add(scrollpane,BorderLayout.CENTER);  //将JScrollPane加入面板
}
}
