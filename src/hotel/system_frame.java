/**
 * @author ��˼��
 * 20180715
 * ��Ϣ���Ľ���
 */
package hotel;

import hotel.entity.*;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;





import hotel.entity.RoomStyle;
import hotel.service.impl.SystemServiceImpl;

public class system_frame extends JFrame{         //������Ϣ����
	   
	 String []s= {"Standard Single","Standard Double","Standard Triple","��Hello Kitty","��ordinary","��BrownBear","��Doraemon","����3","����4"};
	   String []sh= {"HelloKitty","nul","BrownBear","Doraemon"};     //�󴲷�����������
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH);    //ѡ����
	  
	    private JPanel  user_panel;      //�û����
	    int id;       //�ͻ����֤
	    int no;        //�����
	    SystemServiceImpl system=new SystemServiceImpl();
	    /**
	     * @author ��˼��
	     * 20180715
	     * ��Ϣ���Ľ��������������
	     */
	    public system_frame() {
        	setTitle("Message Change");     //����title
        	setSize(300,300);           //�����С
       	    setLocationRelativeTo(null);   //�������
       	    setResizable(false);       //���治�ɵ��ڴ�С
     
       	 tabbedpane.add("User",get_user());
        	tabbedpane.add("Room",get_room());    //����������ѡ�
       	add(tabbedpane,BorderLayout.CENTER);     //ѡ��������
       	
        }
	    /**
	     * @author ��˼��
	     * 20180715
	     * �������
	     */
        private JPanel get_room() {
      
        	
        	JPanel room_panel=new JPanel(); //�û����
        	room_panel.setLayout(null);  //���Բ���
        	
        	JLabel label_room_no=new JLabel("Number");
        	label_room_no.setBounds(20,50,50,20);
        	JTextField field_room_no=new JTextField();
        	field_room_no.setBounds(80,50,50,20);
        	room_panel.add(label_room_no);          //���label�������
        	room_panel.add(field_room_no);         //����ı���������
        	JLabel label_room_price=new JLabel("Price");
        	label_room_price.setBounds(25,90, 50, 20);
        	JTextField field_room_price=new JTextField();
        	field_room_price .setBounds(80,90, 50, 20);
        	room_panel.add(label_room_price);  //�۸�label�������
        	room_panel.add(field_room_price);   //�۸��ı���������
        	JComboBox room_style=new JComboBox();     //������ѡ��������
        	room_style.setSelectedItem(null);
        	room_style.addItem(s[0]);                 //���뷿����
        	room_style.addItem(s[1]);
        	room_style.addItem(s[2]);
        	room_style.addItem(s[3]);
        	room_style.addItem(s[4]);
        	room_style.addItem(s[5]);
        	room_style.addItem(s[6]);
        
        	room_style.addItem(s[7]);
        	room_style.addItem(s[8]);
        	room_style.setBounds(150, 50, 120, 20);
        	room_panel.add(room_style);      //������������������
 
        	JButton button_add=new JButton("Add");       //���Ӱ�ť
        	button_add.setBounds(10,165,80,30);
        	room_panel.add(button_add);           //���Ӱ�ť�������
        	JButton button_update=new JButton("Change");   //���İ�ť
        	button_update.setBounds(105,165,80,30);
        	room_panel.add(button_update);    //���İ�ť�������
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	room_panel.add(button_delete);       //ɾ����ť�������
			
           button_add.addActionListener(new ActionListener() {      //���İ�ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					no=Integer.parseInt(field_room_no.getText());
					
					id=room_style.getSelectedIndex()+1;
					try{
						 for(int i=0;i<field_room_no.getText().length();i++) {
		            		 if(!Character.isDigit(field_room_no.getText().charAt(i))) {
		            			 throw new Exception("����������");
		            		 }
		            	 }
						if(no>9999||no<1000) {
							throw new Exception("����ű�������λ��");
						}
						if(field_room_no.getText().length()==0) {
							throw new Exception("�����뷿���");
						}
						String[] sh= {String.valueOf(id)};
					
						system.adroom(sh, no);
					
							JOptionPane.showMessageDialog(null, "��ӳɹ�");
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
		            	  field_room_no.setText(null);
		            	  field_room_price.setText(null);
		              }
				}
				
			});
            button_update.addActionListener(new ActionListener() {    //���°�ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int index=room_style.getSelectedIndex()+1;
				    double p=Double.parseDouble(field_room_price.getText());
	              try {
	            	 for(int i=0;i<field_room_price.getText().length();i++) {
	            		 if(!Character.isDigit(field_room_price.getText().charAt(i))) {
	            			 throw new Exception("����������");
	            		 }
	            	 }
	            	    String[] s= {String.valueOf(p),String.valueOf(index)};
	            	    system.updateroom(sh, s, no,p,index);
					
					JOptionPane.showMessageDialog(null, "���ĳɹ�");
	              }catch(Exception ex) {
	            	  JOptionPane.showMessageDialog(null,ex.getMessage());
	              }finally {
	            	  field_room_no.setText(null);
	            	  field_room_price.setText(null);
	              }
				}
			});
			button_delete.addActionListener(new ActionListener() {        //ɾ����ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int no=Integer.parseInt(field_room_no.getText());
	                  try{
	                	  for(int i=0;i<field_room_no.getText().length();i++) {
	 	            		 if(!Character.isDigit(field_room_no.getText().charAt(i))) {
	 	            			 throw new Exception("����������");
	 	            		 }
	 	            	 }
						if(no>9999||no<1000) {
							throw new Exception("����ű�������λ��");
						}
						if(field_room_no.getText().length()==0) {
							throw new Exception("�����뷿���");
						}
						
						String[] s=new String[1];
						s[0]=String.valueOf(no);
					
						boolean u=system.deleteroom(s);
						if(u==false) {
							JOptionPane.showMessageDialog(null, "û�и÷���");
						}
						
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
	            	  field_room_no.setText(null);
	            	  field_room_price.setText(null);
	              }
				}
			});
        	return room_panel;
        }
        /**
	     * @author ��˼��
	     * 20180715
	     * �û����
	     */
        private JPanel get_user() {       //�û����
        	user_panel=new JPanel();
        	user_panel.setLayout(null);
        	JLabel label_id=new JLabel("Account");
        	label_id.setBounds(50,50,70,20);
        	JTextField field_id=new JTextField();
        
        	field_id.setBounds(120,50,100,20);
        	user_panel.add(label_id);
        	user_panel.add(field_id);
        	JLabel label_ps=new JLabel("Password");
        	label_ps.setBounds(45,80,70,20);
        	JTextField field_ps=new JTextField();
        
        	field_ps .setBounds(120,80,100,20);
        	user_panel.add(label_ps);
        	user_panel.add(field_ps);
        	JLabel label_new=new JLabel("New Password");
        	label_new.setBounds(25,110,90,20);
        	JTextField field_new=new JTextField();
        	
        	field_new.setBounds(120,110,100,20);
        	user_panel.add(label_new);
        	user_panel.add(field_new);
        	JButton button_add=new JButton("Add");
        	button_add.setBounds(10,165,80,30);
        	user_panel.add(button_add);
        	JButton button_update=new JButton("Change");
        	button_update.setBounds(105,165,80,30);
        	user_panel.add(button_update);
        	JButton button_delete=new JButton("Delete");
        	button_delete.setBounds(200,165,80,30);
        	user_panel.add(button_delete);
        	button_delete.addActionListener(new ActionListener() {        //ɾ����ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					if(s1.length()==0||s2.length()==0) {
						throw new Exception("������");
					}
					String[] s=new String[2];
					s[0]=s1;
					s[1]=s2;
					
					boolean u=system.deleteuser(s);
					if(u==true) {
						
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}else {
						throw new Exception("�û������������");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	button_update.addActionListener(new ActionListener() {         //���İ�ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					String s3=field_new.getText();
					if(s1.length()==0||s2.length()==0||s3.length()==0) {
						throw new Exception("������");
					}	
					String[] s=new String[2];
					s[0]=s1;
					s[1]=s2;
					String[] s0=new String[2];
					s0[0]=s3;
					s0[1]=s1;
					boolean u=system.updateuser(s, s0);
					if(u==true) {
						JOptionPane.showMessageDialog(null, "��������ɹ�");
					}
					else {
						throw new Exception("�û������������");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_new.setText(null);
						field_ps.setText(null);
					}
				}
			});
        	button_add.addActionListener(new ActionListener() {       //��Ӱ�ť��Ӧ
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try{String s1=field_id.getText();
					String s2=field_ps.getText();
					if(s1.length()==0||s2.length()==0) {
						throw new Exception("������");
					}
					String[] s=new String[1];
					s[0]=s1;
					String[] s3=new String[2];
					s3[0]=s1;
					s3[1]=s2;
					boolean u=system.adduser(s, s3);
						if(u==true) {
							JOptionPane.showMessageDialog(null, "��ӳɹ�");
						}
					else {
						throw new Exception("���˺��Ѵ���");
					}
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						field_id.setText(null);
						field_ps.setText(null);
						field_new.setText(null);
					}
				}
			});
        	return user_panel;
        }
}
