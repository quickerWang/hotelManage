/**
 * @author ������
 * 20180713
 * ʵ��ס������
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
	int width=800;   //����Ŀ��
	int height=580;   //����ĸ߶�

	/**
	 * @author ������
	 * 20180713
	 * ʵ��ס������Ļ����������ã����С��
	 */
	public living_frame() {
		setSize(width,height);  //���ô��ڳߴ�
		setLocationRelativeTo(null);       //���ô�������Ļ�м�
		setLayout(null);         //û�в��֣����Բ���
    	    
        setResizable(false);     //���ɵ��ڴ��ڴ�С
    	livingPanel panel=new livingPanel();   //�������
    	panel.setLayout(null);      //�����Բ���
		setLocationRelativeTo(null);  //����ҳ�����
		
		panel.add(button_start());   //��ʼ��ť���뵽�����
		panel.add(button_end());      //�˷���ť���뵽�����
		panel.add(button_clean());    //��ɨ��ť���������
		
	
		JLabel label_1=new JLabel();       //�۸��ǩ
		label_1.setBounds(215,256,100,100); //���ñ߽�
		JLabel label_2=new JLabel();      //�۸��ǩ
		label_2.setBounds(215,288,100,100); //���ñ߽�
		JLabel label_3=new JLabel();      //�۸��ǩ
		label_3.setBounds(215,321,100,100); //���ñ߽�
		JLabel label_4=new JLabel();       //�۸��ǩ
		label_4.setBounds(450,256,100,100);  //���ñ߽�
		JLabel label_5=new JLabel();       //�۸��ǩ
		label_5.setBounds(450,288,100,100);  //���ñ߽�
		JLabel label_6=new JLabel();       //�۸��ǩ
		label_6.setBounds(450,321,100,100);  //���ñ߽�
		JLabel label_7=new JLabel();       //�۸��ǩ
		label_7.setBounds(450,360,100,100);  //���ñ߽�
		JLabel label_8=new JLabel();       //�۸��ǩ
		label_8.setBounds(211,398,100,100);  //���ñ߽�
		JLabel label_9=new JLabel();       //�۸��ǩ
		label_9.setBounds(212,432,100,100);  //���ñ߽�
		panel.add(label_1);   //����ǩlabel_1���뵽�����
		panel.add(label_2);   //����ǩlabel_2���뵽�����
		panel.add(label_3);   //����ǩlabel_3���뵽�����
		panel.add(label_4);   //����ǩlabel_4���뵽�����
		panel.add(label_5);   //����ǩlabel_5���뵽�����
		panel.add(label_6);   //����ǩlabel_6���뵽�� ����
		panel.add(label_7);   //����ǩlabel_7���뵽�����
		panel.add(label_8);   //����ǩlabel_8���뵽�����
		panel.add(label_9);   //����ǩlabel_9���뵽�����
		
		SystemService system=new SystemServiceImpl();  //�õ��������
		ArrayList<room_style> room1=system.getroomstyle();   //�õ��������ͼ���
	    label_1.setText(String.valueOf(room1.get(0).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_2.setText(String.valueOf(room1.get(1).getPrice()));    //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_3.setText(String.valueOf(room1.get(2).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_4.setText(String.valueOf(room1.get(4).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_5.setText(String.valueOf(room1.get(3).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_6.setText(String.valueOf(room1.get(5).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_7.setText(String.valueOf(room1.get(6).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_8.setText(String.valueOf(room1.get(7).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
	    label_9.setText(String.valueOf(room1.get(8).getPrice()));   //����Ӧ�������͵ļ۸����ö�Ӧ��ǩ���ı�
		 setContentPane(panel);    //���ø����Ϊ�����
	
	}
	/**
	 * @author ������
	 * 20180713
	 * ���ô�ɨ��ť
	 */
	private Component button_clean() {
		// TODO Auto-generated method stub
		JButton button_clean=new JButton("Clean");   //�õ��ı�ΪClean�İ�ť
		button_clean.setBounds(630, 220, 100, 40);   //���ð�ť��λ�óߴ�
		button_clean.setBorderPainted(false);        //���øð�ťû�б߽�
		button_clean.setIcon(new ImageIcon("image/3-2.png"));    //���ð�ť��ͼƬ
		button_clean.addActionListener(new ActionListener() {    //���ð�ť�ĵ���¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {   //���ʱ�������¼�
				// TODO Auto-generated method stub    
				living_clean clean=new living_clean();    //�õ��µ�living_clean����
				clean.setVisible(true);   //���øý���ɼ�
				clean.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //���ý���Ĺرշ�ʽ
			}
		});
		return button_clean;   //���ذ�ť
	}
	/**
	 * @author ������
	 * 20180713
	 * ���ÿ�����ť
	 */
	private Component button_start() {
		// TODO Auto-generated method stub
		JButton button_start=new JButton("Check in");  //�õ��ı�ΪCheck in�İ�ť����
		button_start.setBounds(630, 320, 100,40);      //���ð�ť��λ�óߴ�
		button_start.setBorderPainted(false);          //���ð�ťû�б߽�
		button_start.setIcon(new ImageIcon("image/3-3.png"));   //���ð�ť��ͼƬ
		button_start.addActionListener(new ActionListener() {   //���ð�ť�ĵ���¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {   //��ť����������¼�
				// TODO Auto-generated method stub
				living_start start=new living_start();    //�õ��µ�living_start����
				start.setVisible(true);                   //���ø�ҳ��ɼ�
				start.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //���ý���Ĺرշ�ʽ
			}
		});
		return button_start;  //���ؽ���
	}
	/**
	 * @author ������
	 * 20180713
	 * �����˷���ť
	 */
	private Component button_end() {
		// TODO Auto-generated method stub
		JButton button_end=new JButton("Check out");   //�õ��ı�ΪCheck out�İ�ť
		button_end.setBounds(630,420,100,40);        //���ð�ť�ĳߴ�λ��
		button_end.setBorderPainted(false);      //���ð�ťû�б߽�
		button_end.setIcon(new ImageIcon("image/3-4.png"));  //���ð�ťͼƬ
		button_end.addActionListener(new ActionListener() {   //���ð�ť����������¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {    //��ť���ʱ���¼�
				// TODO Auto-generated method stub   
				living_exit exit=new living_exit();   //�õ��µ�living_exit����
				                      
				exit.setVisible(true);                 //���ø�ҳ��ɼ�
				exit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //����ҳ��Ĺرշ�ʽ
			}
		});
		return button_end;
	}
}
