/**
 * @author ������
 * ��¼����
 * 20180715
 */

package hotel;



import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import hotel.entity.*;
import hotel.service.Living;
import hotel.service.UserService;
import hotel.service.impl.LivingImpl;
import hotel.service.impl.UserServiceImpl;

import javax.swing.*;

public class Login extends JFrame{
	public static JLabel label_time_1=new JLabel();         //��ʾʱ��������
	public static JLabel label_time_2=new JLabel();         //��ʾʱ��ʱ����
	public static String user;              //����ʹ��ϵͳ���û���
	public static String time_1;        //ʱ��������
	public static String time_2;        //ʱ��ʱ����   
	private int width=384;           //��½���ڿ�
    private int height=260;          //��½���ڸ�
    
    private String name;              //�˺�
    private JTextField field;          //�˺ſ�
    private JPasswordField passwordfield;     //�����
    private  String password;       //����
    private JButton loginbutton;    //��½��ť
    private mainFrame frame;          //ϵͳ������ҳ�棬��½�ɹ������
	
    /**
     * @author ������
     * ��¼���������������
     * 20180715
     */
    
    public Login()
    { 
		Calendar c = Calendar.getInstance();        //�õ�ϵͳʱ��
		int year=c.get(Calendar.YEAR);              //��
		int month=c.get(Calendar.MONTH);              //��
		month++;
		int day=c.get(Calendar.DATE);            //��
		int hour=c.get(Calendar.HOUR);            //ʱ
		int minute=c.get(Calendar.MINUTE);         //��
		int second=c.get(Calendar.SECOND);         //��
		time_1=String.valueOf(year)+"��"+String.valueOf(month)+"��"+String.valueOf(day)+"��";   //ʱ���ַ���
		time_2=String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);    //ʱ���ַ���
		setSize(width,height);  //���ô��ڳߴ�
		setLocationRelativeTo(null);       //���ô�������Ļ�м�
		setLayout(null);         //û�в��֣����Բ���
    	
    	this.setTitle("��½");   //���ڱ���    
        setResizable(false);     //���ɵ��ڴ��ڴ�С
    	LoginPanel panel=new LoginPanel();   //�������
    	panel.setLayout(null);      //�����Բ���

        panel.add(getPasswordField(),null);    //�����������
        panel.add(getTextField(),null);       //�˺ſ�������
        panel.add(getExitButton(),null);    //�˳���ť�������
        panel.add(getLoginButton(),null);    //��½��ť�������
        
        setContentPane(panel);    //���ø����Ϊ�����
        
    }
    /**
     * 
     * @autuor ������
     * 20180715
     * �õ������
     */
	public JPasswordField getPasswordField(){
		passwordfield=new JPasswordField();  //�õ������
		passwordfield.setBounds(160, 140, 100, 20);   //���������Ĵ�С��λ��
        addKeyListener(new KeyListener() {   //����������¼�
			
			@Override
			public void keyTyped(KeyEvent e) {    //���°���ʱ
				// TODO Auto-generated method stub
				int keycode=e.getKeyCode();   //�õ����°�����ֵ
				if(keycode==KeyEvent.VK_ENTER)  //����ǻس�
				{
					loginbutton.doClick();  //ִ�е�¼��ť�ĵ���¼�
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {  //��ť�ɿ�ʱ
				// TODO Auto-generated method stub
			}    
			
			@Override
			public void keyPressed(KeyEvent e) {  //��ť����ʱ
				// TODO Auto-generated method stub	
			}
		});
		return passwordfield;
	}
	/**
	 * 
	 * @author ������
	 * 20180715
	 * �����ı���
	 */
	public JTextField getTextField() {
		field=new JTextField();  //�õ��ı���
		field.setBounds(160, 110, 100,20);  //�����ı���Ĵ�С��λ��

		return field;
	}
	/**
	 * 
	 * @author ������
	 * 20180715
	 * �õ��˳���ť
	 */
	public JButton getExitButton() {
		JButton button=new JButton("Exit");   //�õ��ı�ΪExit�İ�ť
		button.setBounds(220, 180, 64, 20);   //���ð�ť�Ĵ�С��λ��
		button.setIcon(new ImageIcon("image/1-2.png"));  //���ð�ť��ͼƬ
		button.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);   //�˳�ϵͳ
			}
		});
		return button;
	}
	/**
	 * 
	 * @author ������
	 * 20180715
	 * �õ���¼��ť
	 */
	public JButton getLoginButton() {
		loginbutton=new JButton();    //�õ���ť
        loginbutton.setText("login");  //���ð�ť�ı�Ϊlogin
        loginbutton.setBounds(120, 180, 64, 20);   //���ð�ť��С��λ��
        loginbutton.setIcon(new ImageIcon("image/1-3.png"));  //���ð�ťͼƬ
        loginbutton.addActionListener(new ActionListener() {  //���ð�ť����¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name=field.getText();   //�õ��˺ſ��ı�
				password=new String(passwordfield.getPassword()); //�õ�������ı�
				UserService use=new UserServiceImpl();  //�õ��û��������
				if(use.login(name,password)) {   //����login����
				
				user=name;
					frame=new mainFrame();   //�½����������
					frame.setVisible(true);  //������ɼ�
					setVisible(false);  //��¼���治�ɼ�
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);   //�����˳���ʽ
				}
				else{
					JOptionPane.showMessageDialog(null,"û������û�����");   //��ʾ��¼ʧ����Ϣ
					field.setText(null);   //����˺��ı���
					passwordfield.setText(null);  //��������ı���
				}
			}
		});
        
		return  loginbutton;
	}
 /**
  * 
  * @author ������
  * 20180715
  * ���������������
  */
	public static void main(String[] args) {     //����������
		// TODO Auto-generated method stub
         Login f=new Login();    //�½���¼����       
         f.setVisible(true);                //���ÿɼ�
         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     //���ùرշ�ʽ���رպ��˳�Ӧ�ó���
         Thread t=new Thread(new Runnable() {  //�½��̣߳��Ա����ִ��ʱͬʱ��ȡʱ��
			
			@Override
			public void run() {     //�߳����к���
				// TODO Auto-generated method stub
				while(true) {  //����ѭ��
					try {
						Thread.sleep(1000);  //˯��1000ms
						Calendar c = Calendar.getInstance();   //�õ�Calendar����
						int year=c.get(Calendar.YEAR);   //�õ����
						int month=c.get(Calendar.MONTH);   //�õ��·�
						month++;   
						int day=c.get(Calendar.DATE);   //�õ���
						int hour=c.get(Calendar.HOUR);   //ʱ
						int minute=c.get(Calendar.MINUTE);  //��
						int second=c.get(Calendar.SECOND);   //��
						time_1=String.valueOf(year)+"��"+String.valueOf(month)+"��"+String.valueOf(day)+"��"; //ʱ���ַ���
						time_2=String.valueOf(hour)+":"+String.valueOf(minute)+":"+String.valueOf(second);//ʱ���ַ���
						label_time_1.setText(time_1);//����label�ı�Ϊʱ���ַ���
						label_time_2.setText(time_2);//����label�ı�Ϊʱ���ַ���
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
         t.start();  //�߳̿�ʼ����
	}
}
