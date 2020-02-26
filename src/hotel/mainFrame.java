/**
 * @author 王文萱
 * 20180715
 * 主界面实现
 */

package hotel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;




public class mainFrame extends JFrame{
	JButton button_exit;  //结算按钮
	JButton button_food;   //点餐按钮
	JButton button_live;  //住房按钮
	JButton button_message; //显示信息按钮
	JButton button_system;  //修改信息按钮
	JButton button_about;  //关于我们按钮
	
	
	   public mainFrame()
     {
    	 setTitle("Star Hotel");  //设置界面标题
    	
    	 setSize(815,600);   //设置界面尺寸
    	 setLayout(null);  //绝对布局
    	 getContentPane().setBackground(Color.WHITE);  //设置背景白色
    	 setLocationRelativeTo(null);   //设界面居中
    	
    	 mainFramePanel framepanel=new mainFramePanel();  //新建mainFramePanel
    	 framepanel.setLayout(null);   //设置该面板布局为绝对布局
    	
    	 framepanel.add(getFoodButton());    //点餐按钮加入面板
    	 framepanel.add(getLiveButton());  //住房按钮加入面板
    	 framepanel.add(getMessageButton());//信息按钮加入面板
    	 framepanel.add(getSystemButton());//修改信息按钮加入面板
    	 framepanel.add(getAboutButton());//关于按钮加入面板
    	 framepanel.add(getExitButton()); //结算按钮加入面板
    	 
    	 setContentPane(framepanel);  //设置该面板为主面板
     }
	  
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到关于按钮
	    */
	   public JButton getAboutButton() {
		   button_about=new JButton();  //新建按钮
	    	 button_about.setBounds(456,368,109,106);  //设置按钮大小，位置
	    	 button_about.setBorderPainted(false);   //设置无边界
	    	 button_about.setIcon(new ImageIcon("image/2-5.png"));  //设置按钮图片
    	 button_about.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				about_frame System=new about_frame();  //新建关于我们界面
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置界面关闭方式
				System.setVisible(true);  //可见
			}
		});
    	 return button_about;
	   }
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到信息更改按钮
	    */
	   public JButton getSystemButton() {
		   button_system=new JButton(); //新建按钮
	    	 button_system.setBounds(312,368,97,106); //设置按钮大小，位置
	    	 button_system.setBorderPainted(false);  //无边界
	    	 button_system.setIcon(new ImageIcon("image/2-4.png"));  //设置按钮图片
    	 button_system.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				system_frame System=new system_frame();  //新建界面
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式
				System.setVisible(true);//设置可见
			}
		});
    	 return button_system;
	   }
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到信息按钮
	    */
	   public JButton getMessageButton(){
			 button_message=new JButton();  //新建按钮
	    	 button_message.setBounds(608,248,100,85);  //设置按钮大小，位置
	    	 button_message.setBorderPainted(false);//设置按钮无边界
	    	 button_message.setIcon(new ImageIcon("image/2-3.png")); //设置按钮图片
    	 button_message.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				message_frame message=new message_frame();  //新建页面
				message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //关闭方式
				message.setVisible(true); //可见
			}
		});
    	 return button_message;
	   }
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到住房按钮
	    */
	   public JButton getLiveButton() {  
		   button_live=new JButton();//新建按钮
	    	 button_live.setBounds(456,248,100,94);  //设置大小位置
	    	 button_live.setIcon(new ImageIcon("image/2-2.png")); //设置图片
	    	 button_live.setBorderPainted(false);//设置无边界
   
    	 button_live.addActionListener(new ActionListener() {//按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				living_frame living=new living_frame();  //新建对象
				living.setVisible(true);//设置可见
				living.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置关闭方式
			}
		});
    	 return button_live;
	   }
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到订餐按钮
	    */
	   public JButton getFoodButton() {
		 
		   button_food=new JButton();  //新建对象
		     button_food.setBounds(312,248,91,101);  //设置大小，位置
		     button_food.setIcon(new ImageIcon("image/2-1.png")); //设置图片
		     button_food.setBorderPainted(false); //设置无边界
	     
	     button_food.addActionListener(new ActionListener() {  //设置按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dining_frame df=new dining_frame();   //新建页面
				df.setVisible(true);  //设置可见
				df.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置关闭方式
			}
		});
	     return button_food;
	   }
	   /**
	    * 
	    * @author 王文萱
	    * 20180715
	    * 得到结算按钮
	    */
	   public JButton getExitButton() {
		   button_exit=new JButton();  //新建对象
	    	 button_exit.setBounds(608,368,103,96);  //设置大小，位置
	    	 button_exit.setBorderPainted(false);  //设置无边界
	    	 button_exit.setIcon(new ImageIcon("image/2-7.png")); //设置按钮图片
	    	 button_exit.addActionListener(new ActionListener() {  //设置按钮点击事件
	 			@Override
	 			public void actionPerformed(ActionEvent e) {
	 				// TODO Auto-generated method stub
	 				MdataField hotel=new MdataField();  //新建界面
	 				hotel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置关闭方式
	 				hotel.setVisible(true);  //设置可见
	 				
	 			}
	 		});
	    	 return button_exit;
	   }
}
