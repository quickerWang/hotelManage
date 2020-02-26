/**
 * @author 王文萱
 * 20180713
 * 实现住房界面
 */

package hotel;

import java.awt.Component;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hotel.LoginPanel;


import hotel.entity.room_style;
import hotel.service.SystemService;
import hotel.service.impl.SystemServiceImpl;

public class living_frame extends JFrame{
	int width=800;   //界面的宽度
	int height=580;   //界面的高度

	/**
	 * @author 王文萱
	 * 20180713
	 * 实现住房界面的基本属性设置，如大小等
	 */
	public living_frame() {
		setSize(width,height);  //设置窗口尺寸
		setLocationRelativeTo(null);       //设置窗口在屏幕中间
		setLayout(null);         //没有布局，绝对布局
    	    
        setResizable(false);     //不可调节窗口大小
    	livingPanel panel=new livingPanel();   //创建面板
    	panel.setLayout(null);      //面板绝对布局
		setLocationRelativeTo(null);  //设置页面居中
		
		panel.add(button_start());   //开始按钮加入到面板中
		panel.add(button_end());      //退房按钮加入到面板中
		panel.add(button_clean());    //打扫按钮加入面板中
		
	
		JLabel label_1=new JLabel();       //价格标签
		label_1.setBounds(215,256,100,100); //设置边界
		JLabel label_2=new JLabel();      //价格标签
		label_2.setBounds(215,288,100,100); //设置边界
		JLabel label_3=new JLabel();      //价格标签
		label_3.setBounds(215,321,100,100); //设置边界
		JLabel label_4=new JLabel();       //价格标签
		label_4.setBounds(450,256,100,100);  //设置边界
		JLabel label_5=new JLabel();       //价格标签
		label_5.setBounds(450,288,100,100);  //设置边界
		JLabel label_6=new JLabel();       //价格标签
		label_6.setBounds(450,321,100,100);  //设置边界
		JLabel label_7=new JLabel();       //价格标签
		label_7.setBounds(450,360,100,100);  //设置边界
		JLabel label_8=new JLabel();       //价格标签
		label_8.setBounds(211,398,100,100);  //设置边界
		JLabel label_9=new JLabel();       //价格标签
		label_9.setBounds(212,432,100,100);  //设置边界
		panel.add(label_1);   //将标签label_1加入到面板中
		panel.add(label_2);   //将标签label_2加入到面板中
		panel.add(label_3);   //将标签label_3加入到面板中
		panel.add(label_4);   //将标签label_4加入到面板中
		panel.add(label_5);   //将标签label_5加入到面板中
		panel.add(label_6);   //将标签label_6加入到面 板中
		panel.add(label_7);   //将标签label_7加入到面板中
		panel.add(label_8);   //将标签label_8加入到面板中
		panel.add(label_9);   //将标签label_9加入到面板中
		
		SystemService system=new SystemServiceImpl();  //得到服务对象
		ArrayList<room_style> room1=system.getroomstyle();   //得到房间类型集合
	    label_1.setText(String.valueOf(room1.get(0).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_2.setText(String.valueOf(room1.get(1).getPrice()));    //用相应房间类型的价格设置对应标签的文本
	    label_3.setText(String.valueOf(room1.get(2).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_4.setText(String.valueOf(room1.get(4).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_5.setText(String.valueOf(room1.get(3).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_6.setText(String.valueOf(room1.get(5).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_7.setText(String.valueOf(room1.get(6).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_8.setText(String.valueOf(room1.get(7).getPrice()));   //用相应房间类型的价格设置对应标签的文本
	    label_9.setText(String.valueOf(room1.get(8).getPrice()));   //用相应房间类型的价格设置对应标签的文本
		 setContentPane(panel);    //设置该面板为主面板
	
	}
	/**
	 * @author 王文萱
	 * 20180713
	 * 设置打扫按钮
	 */
	private Component button_clean() {
		// TODO Auto-generated method stub
		JButton button_clean=new JButton("Clean");   //得到文本为Clean的按钮
		button_clean.setBounds(630, 220, 100, 40);   //设置按钮的位置尺寸
		button_clean.setBorderPainted(false);        //设置该按钮没有边界
		button_clean.setIcon(new ImageIcon("image/3-2.png"));    //设置按钮的图片
		button_clean.addActionListener(new ActionListener() {    //设置按钮的点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {   //点击时发生的事件
				// TODO Auto-generated method stub    
				living_clean clean=new living_clean();    //得到新的living_clean对象
				clean.setVisible(true);   //设置该界面可见
				clean.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //设置界面的关闭方式
			}
		});
		return button_clean;   //返回按钮
	}
	/**
	 * @author 王文萱
	 * 20180713
	 * 设置开房按钮
	 */
	private Component button_start() {
		// TODO Auto-generated method stub
		JButton button_start=new JButton("Check in");  //得到文本为Check in的按钮对象
		button_start.setBounds(630, 320, 100,40);      //设置按钮的位置尺寸
		button_start.setBorderPainted(false);          //设置按钮没有边界
		button_start.setIcon(new ImageIcon("image/3-3.png"));   //设置按钮的图片
		button_start.addActionListener(new ActionListener() {   //设置按钮的点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {   //按钮点击产生的事件
				// TODO Auto-generated method stub
				living_start start=new living_start();    //得到新的living_start界面
				start.setVisible(true);                   //设置该页面可见
				start.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //设置界面的关闭方式
			}
		});
		return button_start;  //返回界面
	}
	/**
	 * @author 王文萱
	 * 20180713
	 * 设置退房按钮
	 */
	private Component button_end() {
		// TODO Auto-generated method stub
		JButton button_end=new JButton("Check out");   //得到文本为Check out的按钮
		button_end.setBounds(630,420,100,40);        //设置按钮的尺寸位置
		button_end.setBorderPainted(false);      //设置按钮没有边界
		button_end.setIcon(new ImageIcon("image/3-4.png"));  //设置按钮图片
		button_end.addActionListener(new ActionListener() {   //设置按钮点击产生的事件
			
			@Override
			public void actionPerformed(ActionEvent e) {    //按钮点击时的事件
				// TODO Auto-generated method stub   
				living_exit exit=new living_exit();   //得到新的living_exit界面
				                      
				exit.setVisible(true);                 //设置该页面可见
				exit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //设置页面的关闭方式
			}
		});
		return button_end;
	}
}
