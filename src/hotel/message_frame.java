/**
 * @author ������
 * 20180715
 * ��Ϣ����
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
	  
	    private JTabbedPane tabbedpane=new JTabbedPane(JTabbedPane.NORTH); //ѡ�
	  
	    private JPanel  user_panel;  //�û���Ϣ���
		SystemServiceImpl system=new SystemServiceImpl();
		/**
		 * @author ������
		 * 20180715
		 * ���������������
		 */
		public message_frame() {
        	setTitle("��Ϣ��ѯ");  //title
            setSize(500,500);  //��С
       	    setLocationRelativeTo(null);  //�Ƿ����
       	    setResizable(false);  //�ܷ����
  //����һϵ�е���嵽ѡ���
       	tabbedpane.add("����Ա",get_user());
        tabbedpane.add("������",get_consumer());
       	tabbedpane.add("ס�����ѵ�",get_list());
       	tabbedpane.add("����",get_room());
       	add(tabbedpane,BorderLayout.CENTER);
       	
        }
		/**
		 * @author ������
		 * 20180715
		 * ���������
		 */
        private JPanel get_consumer() {
            JPanel consumer_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	name.add("���֤��");
        	name.add("����");
        	name.add("�Ա�");   //�������
        
   
        
        	 
        	ArrayList<consumer> consumer_list=new ArrayList<consumer>();
        
        	consumer_list=system.getconsumer();
        	for(int i=0;i<consumer_list.size();i++) {   //��ȡ���ݿ���Ϣ�����
        		Vector<Object> v=new Vector<Object>();
        		v.add(consumer_list.get(i).getId());
        		v.add(consumer_list.get(i).getName());
        		v.add(consumer_list.get(i).getSex());
        		value.add(v);
        	}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //�������
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //scrolllpane�ӱ��
			pane.setViewportView(table);
			consumer_panel.add(pane,BorderLayout.CENTER);   //scrollpane�������
        	return consumer_panel;
        }
        /**
		 * @author ������
		 * 20180715
		 * �������
		 */
        private JPanel get_room() {
            JPanel room_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>(); //�������
        	name.add("���");
        	name.add("����");
        	name.add("�Ƿ�ס��");
        	name.add("�Ƿ��ɨ");
        	name.add("Ѻ��");
        	name.add("������");
        	name.add("���");
        	name.add("��ס����");
        	
			
        	ArrayList<room> a_room= new ArrayList<room>();
        	LivingImpl living=new LivingImpl();
        	String sql="select * from room";        //����δ����ɨ�ķ����sql���
        	
        	String []s=new String[0];         //��ȡ���ݿ���Ϣ�������
        	
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
    				v.add("��");
    				v.add(bbroom.getStyle().name());
    				v.add("��");
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
    				v.add("��");
    				v.add("��");
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
    				v.add("��");
    				v.add("��");
    				v.add(luxuryroom.getRoom_num());
    				value.add(v);
    			}
    		}
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);  //�������ģ��
			JTable table=new JTable(tablemodel);
			JScrollPane pane=new JScrollPane();  //����scrollpane������
			pane.setViewportView(table);
			room_panel.add(pane,BorderLayout.CENTER);  //scrollpane�������
        	return room_panel;
        }
        /**
		 * @author ������
		 * 20180715
		 * ���ѵ����
		 */
        private JPanel get_list() {
            JPanel list_panel=new JPanel();
        	
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();  //list����
        	name.add("���");
        	name.add("�˿����֤");
        	name.add("�����");
        	name.add("����ʱ��");
        	name.add("��������");
        	name.add("�����Ƿ��뿪");
        	name.add("�����ܶ�");
        	
        	
        	ArrayList<list> li_list=new ArrayList<list>();
        	li_list=system.getlist();  //���ݿ���Ϣ�������
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
			JTable table=new JTable(tablemodel);  //�����
			JScrollPane pane=new JScrollPane();  
			pane.setViewportView(table);
			list_panel.add(pane,BorderLayout.CENTER);
        	return list_panel;
        }
        /**
		 * @author ������
		 * 20180715
		 * �û����
		 */
        private JPanel get_user() {
        	user_panel=new JPanel();
        	Vector<Vector<Object>> value=new Vector<Vector<Object>>();
        	Vector<String> name=new Vector<String>();
        	
        	name.add("�û���");  //�������
        	name.add("����");
        	
        
        	ArrayList<user> userlist=new ArrayList<user>();
        	userlist=system.getuser();  //���ݿ���Ϣ�������
        	for(int i=0;i<userlist.size();i++) {
        		Vector<Object> v=new Vector<Object>();
        		v.add(userlist.get(i).getId());
        		v.add(userlist.get(i).getPassword());
        		
        		value.add(v);
        	}
        	
			DefaultTableModel tablemodel=new DefaultTableModel(value,name);
			JTable table=new JTable(tablemodel);  //�����
			JScrollPane pane=new JScrollPane();
			pane.setViewportView(table);
			user_panel.add(pane,BorderLayout.CENTER);
        	return user_panel;
        }
       
}
