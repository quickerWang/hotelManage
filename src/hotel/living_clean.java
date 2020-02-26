/**
 * @author 王文萱
 * 20180713
 * 具体功能:房间打扫界面
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
import hotel.service.impl.LivingImpl;

public class living_clean extends JFrame{
	
	 String[] s={ "房间 号", "价  格", "押  金", "人  数",      //表格列名数组
				"房间主题", "套房数"};
	
	
	 JPanel topPane=new JPanel();               // 面板

	 DefaultTableModel lefttablemodel;         //表格模板
	
	 Vector<String> foodcolumnNames=new Vector<String>();     //记录房间表格列名
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //记录房间表格信息
	
	 
	 ArrayList<room> a_room=new ArrayList<room>();    //房间集合
	 JTable lefttabel;   //表格
	 /**
	  * @author 王文萱
	  * 20180713
	  * 具体功能:房间打扫界面的大小等基本设置
	  */
	 public living_clean() {        
		 setResizable(false);           //设置为不可调节
		 setLocationRelativeTo(null);     //界面居中
		 setSize(400,300);             //设置界面大小
		 setLayout(new BorderLayout());      //界面设置为BorderLayout布局
     getContentPane().add(topPane,BorderLayout.NORTH);       //面板加入到界面中
	topPane.setLayout(new BorderLayout());               //面板设置成BorderLayout布局
	topPane.add(new JLabel("房间"),BorderLayout.NORTH);        //将房间label加到面板中
	for(int i=0;i<s.length;i++) {       //表格列名
		foodcolumnNames.add(s[i]);
	}
	LivingImpl living=new LivingImpl();          //建立新的LivingImp对象
	String sql="select * from room where clean=1";        //查找未被打扫的房间的sql语句
	
	String []s=new String[0];
	
	a_room=(ArrayList)living.selectroom(sql, s);       //查找所有的未被打扫的房间

	Iterator it=a_room.iterator();      //得到a_room的迭代器
	while(it.hasNext()) {            //循环得到房间信息
		room r=(room)it.next();      //得到相应房间
		
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
	lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //以foodcolumnNames为列名，以foodtablevalues为表格中数据建立表格模型
	lefttabel=new JTable(lefttablemodel);      //以该表格模型为模型建立表格
	lefttabel.addMouseListener(new MouseAdapter() {   //为该表格加入点击事件
	
		@Override
		public void mouseClicked(MouseEvent e) {    //鼠标点击时的事件
			// TODO Auto-generated method stub
			int selectedRow=lefttabel.getSelectedRow();    //得到鼠标所点击的表格的行数
			int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());  //得到点击的房间信息的房间号
			    
			
				String[] s=new String[1];    
				s[0]=String.valueOf(room_no);    //字符串数组中存入房间号字符串
				LivingImpl living=new LivingImpl();   //得到新的服务对象
				living.clean(s);                   //调用clean()函数改变房间状态
				for(int i=0;i<foodtablevalues.size();i++) {    //循环读取表格中的数据
					if(foodtablevalues.get(i).get(0)==lefttabel.getValueAt(selectedRow, 0)) {   //在表格数据中删除刚刚被打扫的房间数据
						foodtablevalues.remove(i);    
						break;   //如果找到这样的房间数据，推出循环
					}
				}
				lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);   //设置表格的列名和表格数据
				JOptionPane.showMessageDialog(null, "打扫成功");    //显示打扫成功界面
			
				
			
			
		}
	});
	
	JScrollPane scrollpane=new JScrollPane();   //得到JScrollPane
	scrollpane.setViewportView(lefttabel);  //将表格加入JScrollPane中
	topPane.add(scrollpane,BorderLayout.CENTER);  //将JScrollPane加入面板
}
}
