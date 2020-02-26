/**
 * @author 王文萱
 * 20180714
 * 开房界面的实现
 */

package hotel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.cert.PKIXRevocationChecker.Option;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.ToIntBiFunction;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;



import hotel.Login;




import hotel.entity.BBRoom;
import hotel.entity.CommonRoom;
import hotel.entity.LuxuryRoom;
import hotel.entity.RoomStyle;
import hotel.entity.consumer;
import hotel.entity.room;
import hotel.service.impl.LivingImpl;


public class living_start extends JFrame{
	JTextField field_3=new JTextField();      //余额文本框
	
	JTextField field_2=new JTextField();      //收额
	JTextField field_1=new JTextField();     //消费金额文本框
	int days;         //租用天数
	
	 JButton button=new JButton();         //结账按钮

	 
	 String[] s={ "房间 号", "价  格", "押  金", "人  数",   //房间表格的列名
			"房间主题", "套房数"};
	 String[] str= {"姓  名","身份证号","性  别"};     //客人信息表格的列名
	 
	 JLabel topLabel;            //头顶图片
	 JSplitPane splitpane=new JSplitPane();     //中间分割面板
	 JPanel leftPane;               // 中间分割面板左边表格
	 JPanel rightPane;               //中间分割面板右边表格
	 JPanel bottomPane;              //底部面板
	 DefaultTableModel lefttablemodel;         //左面表格面板
	 DefaultTableModel righttablemodel;        //右面表格面板
	 Vector<String> foodcolumnNames=new Vector<String>();     //记录房间表格列名
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //记录房间表格信息
	 JButton button_3=new JButton();       //签单
	 
	 ArrayList<room> a_room=new ArrayList<room>();    //保存房间信息的集合
	 ArrayList<consumer> a_consumer=new ArrayList<consumer>();     //保存客户信息的集合
	 Vector<String> peoplecolumnNames=new Vector<String>();        //客人列名
	 Vector<Vector<Object>> peoplevalues=new Vector<Vector<Object>>();  //客人值
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //姓名文本框
	 JTextField sexfield=new JTextField();   //性别文本框
	 JTextField idfield=new JTextField();   //身份证号文本框
	 JTextField dayfield=new JTextField();  //天数文本框
	
	
	 JTable righttabel;            //右面表格
	 /**
	  * @author 王文萱
	  * 20180714
	  * 界面的基本属性设置
	  */
     public living_start() {
    	 setSize(880,700);    //设置页面大小   
    	 setLocationRelativeTo(null);    //设置页面居中
    	 setResizable(false);     //设置页面无法调节答谢哦
    	 setLayout(new BorderLayout());   //设置页面布局为边界布局
    
    	 getContentPane().add(getTopLabel(),BorderLayout.NORTH);   //在页面中加入面板放在北方          
    	 getContentPane().add(getSplitPane(),BorderLayout.CENTER);  //在页面中加入面板放在中间
    	 getContentPane().add(getBottomPanel(),BorderLayout.SOUTH);  //在页面中加入面板放在南方
    	 
     }

     /**
	  * @author 王文萱
	  * 20180714
	  * 得到底部的面板
	  */
     
	private JPanel getBottomPanel(){
		// TODO Auto-generated method stub
		
		bottomPane=new JPanel();       //得到面板的对象
		bottomPane.setLayout(new BorderLayout());    //设置该面板的布局为边界布局
		JPanel uppanel=new JPanel();    //得到面板
		bottomPane.add(uppanel,BorderLayout.NORTH);   //将该面板放在底部面板的北部
		uppanel.setLayout(new GridLayout(1, 4));   //设置该面板的布局为网格布局
		
		uppanel.add(dayfield);         //将天数文本框加入该面板
		JLabel day=new JLabel("天数");     //天数标签  
		uppanel.add(day);               //天数标签加入该面板

		uppanel.add(namefield);        //名字文本框加入面板
		JLabel table_number=new JLabel("姓名");  //姓名标签
		uppanel.add(table_number);   //姓名标签加入该面板
		
		  
		uppanel.add(sexfield);    //性别文本框加入面板
		JLabel name=new JLabel("性别"); //性别标签
		uppanel.add(name);      //性别标签加入该面板
		
	
		uppanel.add(idfield);   //身份证号文本框加入面板
		JLabel number=new JLabel("身份证号"); //身份证号标签
		uppanel.add(number);   //身份证号标签加入该面板
		
			
		
		
		JPanel downpanel=new JPanel();   //得到面板
		downpanel.setLayout(new GridLayout(1,3));    //设置该面板的布局为网格布局
		bottomPane.add(downpanel,BorderLayout.CENTER);    //将该面板加到底部面板的中间
		
		JPanel leftpanel=new JPanel(new GridLayout(4, 1));     //得到布局为绝对布局的面板leftpanel
		JPanel panel_1=new JPanel(new GridLayout(1, 2));      //得到布局为绝对布局的面板panel_1
		JLabel label_1=new JLabel("消费金额");     //消费金额label;
		
		panel_1.add(field_1);      //将消费金额文本框加入panel_1
		panel_1.add(label_1);      //将消费金额标签加入panel_1
		leftpanel.add(panel_1);    //将panel_1加入到leftpanel
		
		JPanel panel_2=new JPanel(new GridLayout(1, 2));  //得到布局为网格布局的面板panel_2
		JLabel label_2=new JLabel("实付金额");   //得到实付金额标签
		panel_2.add(field_2);          //将实付金额文本框加入panel_2
		panel_2.add(label_2);      //将实付金额标签加入panel_2
		leftpanel.add(panel_2);    //panel_2加入到leftpanel
		
		JPanel panel_3=new JPanel(new GridLayout(1, 2));     //布局为网格布局的面板panel_3
		JLabel label_3=new JLabel("找零"); //找零标签
		
		panel_3.add(field_3);   //将找零文本框加入到panel_3中
		panel_3.add(label_3);   //将找零标签加入到panel_3中
		leftpanel.add(panel_3);   //将panel_3加入到leftpanel中
	
		leftpanel.add(get_calculate());    //将结账按钮加入到lefpanel中
		downpanel.add(leftpanel);  //将leftpanel面板加入到downpanel中
		
		
		JPanel centerpanel=new JPanel();    //得到面板centerpanel
		centerpanel.setLayout(null);    //设置centerpanel布局为绝对布局
		centerpanel.add(start_paper());   //将加人按钮加入centerpanel

		downpanel.add(centerpanel);    //将centerpanel加入到downpanel中
		
		
		
		
		
		Login.label_time_1.setBounds(100,25,250,20);   //设置label_time_1的大小位置
		Login.label_time_1.setFont(new Font("华文新魏",Font.BOLD, 18));   //设置label字体
		
	
		Login.label_time_2.setBounds(100,50,250,20);  //设置label_time_2的大小位置
		Login.label_time_2.setFont(new Font("华文新魏",Font.BOLD, 18));  //设置label字体
		
		JLabel label_user=new JLabel(Login.user);   //label_user文本为Login.user
		label_user.setBounds(100,75,250,20);    //设置label_user的大小和位置
		label_user.setFont(new Font("华文新魏",Font.BOLD, 18));   //设置label字体
		
		
		JPanel rightpanel=new JPanel();    //得到面板rightpanel
		rightpanel.add(Login.label_time_1);   //Login.label_time_1加入到rightpanel中
		rightpanel.add(Login.label_time_2);   //Login.label_time_2加入到rightpanel中
		rightpanel.add(label_user);       //label_user加入rightpanel
		rightpanel.setLayout(null);   //设置rightpanel布局为绝对布局
		downpanel.add(rightpanel);   //rightpanel加入到downpanel中
		return bottomPane;
	}
//----------------------------------------------------------------
	private JButton get_calculate(){         //结账
		button.setText("结账");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = lefttabel.getSelectedRow();
						float expenditure = Float.valueOf(field_1
								.getText());// 获得消费金额
						float realWages = Float.valueOf(field_2
								.getText());// 获得实收金额
						if (realWages < expenditure) {// 如果实收金额小于消费金额，则弹出提示
							if (realWages == 0.0f)
								JOptionPane
										.showMessageDialog(null, "请输入实收金额！",
												"友情提示",
												JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,
										"实收金额不能小于消费金额！", "友情提示",
										JOptionPane.INFORMATION_MESSAGE);
							field_2.requestFocus();// 并令“实收金额”文本框获得焦点
						} else {
							field_3.setText(realWages - expenditure
									+ "0");// 计算并设置“找零金额”
							
						
							int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());
		                
							int rowCount=righttabel.getRowCount();
							for (int i = 0; i < rowCount; i++) {// 通过循环获得各个消费项目的信息
								
								String people_id=righttabel.getValueAt(i, 1).toString();
								String start=Login.time_1+Login.time_2;       //获得系统当前时间
								
								
								//向list中插入数据
							
								LivingImpl living=new LivingImpl();
								String[] s=new String[6];
								s[0]=people_id;
								s[1]=String.valueOf(room_no);
								s[2]=start;
								s[3]=String.valueOf(days);
								s[4]=String.valueOf(0);
								s[5]=String.valueOf(String.valueOf(Double.parseDouble(field_1.getText())));
								living.cheaklist(s);
								
								
								String[] sh=new String[1];
								sh[0]=String.valueOf(people_id);
								String[] s3=new String[3];
							
								s3[0]=String.valueOf(people_id);
								s3[1]=righttabel.getValueAt(i,0).toString();
								s3[2]=righttabel.getValueAt(i,2).toString();
								//向consumer中加入数据
								living.checkconsumer(sh, s3);
									
					
							
							String[] s4=new String[1];
							s4[0]=String.valueOf(room_no);
							//更改room数据
							living.checkroom(s4);
							
							
							JOptionPane.showMessageDialog(null, 
									 " 结账完成！", "友情提示",
									JOptionPane.INFORMATION_MESSAGE);// 弹出结账完成提示

							field_2.setText("0.00");// 清空“实收金额”文本框
							field_3.setText("0.00");// 清空“找零金额”文本框
						
						}
					}
			}
			
		});
		return button;
	}

	/**
	  * @author 王文萱
	  * 20180714
	  * 得到顶部面板
	  */

	private JLabel getTopLabel() {
		//TODO Auto-generated method stub
		topLabel=new JLabel();//得到topLabel
		topLabel.setBounds(0,0,880,128);   //设置label的大小，位置
		topLabel.setIcon(new ImageIcon("image/4-0.png"));  //设置label的图片
		return topLabel;
	}
	public JPanel getLeftPane() {
		leftPane=new JPanel();   //得到leftPane
		leftPane.setLayout(new BorderLayout());   //设置leftpane布局为leftPane
		leftPane.add(new JLabel("房间"),BorderLayout.NORTH);   //将房间label加入到leftpane的北面
		for(int i=0;i<s.length;i++) {       //表格列名
			foodcolumnNames.add(s[i]);
		}
		LivingImpl living=new LivingImpl();    //ded服务对象
		String sql="select * from room where state=0 and clean=0";        //查找已被打扫的房间的sql语句
		
		String []s=new String[0];
		
		a_room=(ArrayList)living.selectroom(sql, s);   //查找到已被打扫的房间
		
		
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
		
		lefttabel.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {   //表格点击事件
				// TODO Auto-generated method stub
				int select=lefttabel.getSelectedRow();  //得到被选择的表格行
				
			
				double m_1 = 0;          //房间租金
				
				try{if(dayfield.getText().length()==0) {     //day文本框为空
					throw new Exception("请先填写住宿天数");   //丢异常
				}
				else {	
				for(int i=0;i<dayfield.getText().length();i++) {   //day文本中不是数字
					if(!Character.isDigit(dayfield.getText().charAt(i))) {
						throw new Exception("住宿天数必须添数字");   //丢异常
				}
				}
				days=Integer.parseInt(dayfield.getText());   //得到day文本框数字
				if(!lefttabel.getValueAt(select, 3).toString().equals("无")) {     //该房间为普通房
					CommonRoom r=new CommonRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),Integer.parseInt(lefttabel.getValueAt(select, 3).toString())); //建立普通房对象
					m_1=r.sum(days);  //得到房间价格

				}
				if(!lefttabel.getValueAt(select, 4).toString().equals("无")) {  //该房间为大床房
					BBRoom r=new BBRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),RoomStyle.valueOf(lefttabel.getValueAt(select, 4).toString())); //建立大床房对象
					m_1=r.sum(days); //得到房间价格
				}
				if(!lefttabel.getValueAt(select, 5).toString().equals("无")) {   //该房间为豪华房
					LuxuryRoom r=new LuxuryRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),Integer.parseInt(lefttabel.getValueAt(select, 5).toString())); //建立豪华房对象
					m_1=r.sum(days); //得到房间价格
				}
				double m=Double.parseDouble(lefttabel.getValueAt(select,2).toString()); //得到房间押金
				field_1.setText(String.valueOf(m+m_1));   //设置应付金额
				}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());  //显示异常信息
				}
			}
		});
		JScrollPane scrollpane=new JScrollPane();    //得到scrollpane对象
		scrollpane.setViewportView(lefttabel);   //将lefttable加入scrollpane
		leftPane.add(scrollpane);   //scrollpane加入leftpane
		return leftPane;
	
	}
	/**
	  * @author 王文萱
	  * 20180714
	  * 得到右侧面板
	  */
	public JPanel getRightPane() {
		rightPane=new JPanel();  //得到rightPane面板
		rightPane.setLayout(new BorderLayout());  //设置布局为边界布局
		rightPane.add(new JLabel("客人"),BorderLayout.NORTH);  //客人标签加到rightpane的北面
		for(int i=0;i<str.length;i++) {  //载入客人列名
			peoplecolumnNames.add(str[i]);  
		}
	    
		righttablemodel=new DefaultTableModel(peoplevalues,peoplecolumnNames); //利用peoplecolumnNames和peoplevalues的都表格模板
		righttabel=new JTable(righttablemodel);  //利用该表格模板建立表格
	
		JScrollPane scrollpane=new JScrollPane();    //得到scrollpane对象
		scrollpane.setViewportView(righttabel);  //及将righttabel加入到scrollpane
		rightPane.add(scrollpane);   //scrollpane加入rightpane
		return rightPane;
	}
	public JSplitPane getSplitPane(){
		splitpane=new JSplitPane();   //新建分割面板
		splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //水平分割
		splitpane.setDividerLocation(700);// 设置面版默认的分割位置
		splitpane.setDividerSize(10);// 设置分割条的宽度
		splitpane.setLeftComponent(getLeftPane());   //左面面板
		splitpane.setRightComponent(getRightPane());//右面面板
		return splitpane;
	}  
  
    
	/**
	  * @author 王文萱
	  * 20180714
	  * 得到加入按钮
	  */
    public JButton start_paper() {
   	 JButton button_1=new JButton("加人");  //加人按钮
   	 button_1.setBounds(50,30,80,60);   //设置按钮大小位置
   	 button_1.addActionListener(new ActionListener() {   //添加鼠标点击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				String input_name = namefield.getText().trim();// 获得输入内容
				String input_sex=sexfield.getText().trim(); // 获得输入内容
				String input_id=idfield.getText().trim(); // 获得输入内容
				try{
					 if (input_name.length()==0||input_id.length()==0||input_sex.length()==0) {    //输入内容不全
						 throw new Exception("信息不全，请重新输入");   //抛出异常
					 }
					 if("Male".equals(sexfield.getText().trim())||"Female".equals(sexfield.getText().trim()))   //性别输入正确
					 {input_sex=sexfield.getText().trim();}
					 else  //性别输入正确
						 throw new Exception("性别必须是Male or Female!");  //抛出异常

					if(idfield.getText().trim().length()==18) {    //身份证号正确
			        input_id=idfield.getText().trim();}
				else              //身份证号错误
					{
						throw new Exception("身份证号必须18位！");   //抛出异常
					}
				 
										Vector<Object> v=new Vector<Object>	();   //向量
										v.add(input_name);     //加入姓名
										v.add(input_id);     //加入id
										v.add(input_sex);   //加入性别
										peoplevalues.add(v);    //该顾客加入到表格数据中
										righttablemodel.setDataVector(peoplevalues, peoplecolumnNames);  //利用peoplecolumnNames和peoplevalues建立表格模型
								
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, (ex.getMessage()));  //显示异常信息
				}finally {
					namefield.setText(null);  //姓名文本框置空
					idfield.setText(null);  //身份证文本框置空
					sexfield.setText(null);   //性别文本框置空
					dayfield.setText(null);  //天数文本框置空
					
				}
			}
		});
   	 return button_1;
    }
}

