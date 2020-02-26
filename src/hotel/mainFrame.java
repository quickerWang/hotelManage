/**
 * @author ������
 * 20180715
 * ������ʵ��
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
	JButton button_exit;  //���㰴ť
	JButton button_food;   //��Ͱ�ť
	JButton button_live;  //ס����ť
	JButton button_message; //��ʾ��Ϣ��ť
	JButton button_system;  //�޸���Ϣ��ť
	JButton button_about;  //�������ǰ�ť
	
	
	   public mainFrame()
     {
    	 setTitle("Star Hotel");  //���ý������
    	
    	 setSize(815,600);   //���ý���ߴ�
    	 setLayout(null);  //���Բ���
    	 getContentPane().setBackground(Color.WHITE);  //���ñ�����ɫ
    	 setLocationRelativeTo(null);   //��������
    	
    	 mainFramePanel framepanel=new mainFramePanel();  //�½�mainFramePanel
    	 framepanel.setLayout(null);   //���ø���岼��Ϊ���Բ���
    	
    	 framepanel.add(getFoodButton());    //��Ͱ�ť�������
    	 framepanel.add(getLiveButton());  //ס����ť�������
    	 framepanel.add(getMessageButton());//��Ϣ��ť�������
    	 framepanel.add(getSystemButton());//�޸���Ϣ��ť�������
    	 framepanel.add(getAboutButton());//���ڰ�ť�������
    	 framepanel.add(getExitButton()); //���㰴ť�������
    	 
    	 setContentPane(framepanel);  //���ø����Ϊ�����
     }
	  
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ����ڰ�ť
	    */
	   public JButton getAboutButton() {
		   button_about=new JButton();  //�½���ť
	    	 button_about.setBounds(456,368,109,106);  //���ð�ť��С��λ��
	    	 button_about.setBorderPainted(false);   //�����ޱ߽�
	    	 button_about.setIcon(new ImageIcon("image/2-5.png"));  //���ð�ťͼƬ
    	 button_about.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				about_frame System=new about_frame();  //�½��������ǽ���
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ý���رշ�ʽ
				System.setVisible(true);  //�ɼ�
			}
		});
    	 return button_about;
	   }
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ���Ϣ���İ�ť
	    */
	   public JButton getSystemButton() {
		   button_system=new JButton(); //�½���ť
	    	 button_system.setBounds(312,368,97,106); //���ð�ť��С��λ��
	    	 button_system.setBorderPainted(false);  //�ޱ߽�
	    	 button_system.setIcon(new ImageIcon("image/2-4.png"));  //���ð�ťͼƬ
    	 button_system.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				system_frame System=new system_frame();  //�½�����
				System.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //���ùرշ�ʽ
				System.setVisible(true);//���ÿɼ�
			}
		});
    	 return button_system;
	   }
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ���Ϣ��ť
	    */
	   public JButton getMessageButton(){
			 button_message=new JButton();  //�½���ť
	    	 button_message.setBounds(608,248,100,85);  //���ð�ť��С��λ��
	    	 button_message.setBorderPainted(false);//���ð�ť�ޱ߽�
	    	 button_message.setIcon(new ImageIcon("image/2-3.png")); //���ð�ťͼƬ
    	 button_message.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				message_frame message=new message_frame();  //�½�ҳ��
				message.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //�رշ�ʽ
				message.setVisible(true); //�ɼ�
			}
		});
    	 return button_message;
	   }
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ�ס����ť
	    */
	   public JButton getLiveButton() {  
		   button_live=new JButton();//�½���ť
	    	 button_live.setBounds(456,248,100,94);  //���ô�Сλ��
	    	 button_live.setIcon(new ImageIcon("image/2-2.png")); //����ͼƬ
	    	 button_live.setBorderPainted(false);//�����ޱ߽�
   
    	 button_live.addActionListener(new ActionListener() {//��ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				living_frame living=new living_frame();  //�½�����
				living.setVisible(true);//���ÿɼ�
				living.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ùرշ�ʽ
			}
		});
    	 return button_live;
	   }
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ����Ͱ�ť
	    */
	   public JButton getFoodButton() {
		 
		   button_food=new JButton();  //�½�����
		     button_food.setBounds(312,248,91,101);  //���ô�С��λ��
		     button_food.setIcon(new ImageIcon("image/2-1.png")); //����ͼƬ
		     button_food.setBorderPainted(false); //�����ޱ߽�
	     
	     button_food.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				dining_frame df=new dining_frame();   //�½�ҳ��
				df.setVisible(true);  //���ÿɼ�
				df.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ùرշ�ʽ
			}
		});
	     return button_food;
	   }
	   /**
	    * 
	    * @author ������
	    * 20180715
	    * �õ����㰴ť
	    */
	   public JButton getExitButton() {
		   button_exit=new JButton();  //�½�����
	    	 button_exit.setBounds(608,368,103,96);  //���ô�С��λ��
	    	 button_exit.setBorderPainted(false);  //�����ޱ߽�
	    	 button_exit.setIcon(new ImageIcon("image/2-7.png")); //���ð�ťͼƬ
	    	 button_exit.addActionListener(new ActionListener() {  //���ð�ť����¼�
	 			@Override
	 			public void actionPerformed(ActionEvent e) {
	 				// TODO Auto-generated method stub
	 				MdataField hotel=new MdataField();  //�½�����
	 				hotel.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //���ùرշ�ʽ
	 				hotel.setVisible(true);  //���ÿɼ�
	 				
	 			}
	 		});
	    	 return button_exit;
	   }
}
