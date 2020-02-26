/**
 * @author ������
 * 20180713
 * ���幦��:�����ɨ����
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
	
	 String[] s={ "���� ��", "��  ��", "Ѻ  ��", "��  ��",      //�����������
				"��������", "�׷���"};
	
	
	 JPanel topPane=new JPanel();               // ���

	 DefaultTableModel lefttablemodel;         //���ģ��
	
	 Vector<String> foodcolumnNames=new Vector<String>();     //��¼����������
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //��¼��������Ϣ
	
	 
	 ArrayList<room> a_room=new ArrayList<room>();    //���伯��
	 JTable lefttabel;   //���
	 /**
	  * @author ������
	  * 20180713
	  * ���幦��:�����ɨ����Ĵ�С�Ȼ�������
	  */
	 public living_clean() {        
		 setResizable(false);           //����Ϊ���ɵ���
		 setLocationRelativeTo(null);     //�������
		 setSize(400,300);             //���ý����С
		 setLayout(new BorderLayout());      //��������ΪBorderLayout����
     getContentPane().add(topPane,BorderLayout.NORTH);       //�����뵽������
	topPane.setLayout(new BorderLayout());               //������ó�BorderLayout����
	topPane.add(new JLabel("����"),BorderLayout.NORTH);        //������label�ӵ������
	for(int i=0;i<s.length;i++) {       //�������
		foodcolumnNames.add(s[i]);
	}
	LivingImpl living=new LivingImpl();          //�����µ�LivingImp����
	String sql="select * from room where clean=1";        //����δ����ɨ�ķ����sql���
	
	String []s=new String[0];
	
	a_room=(ArrayList)living.selectroom(sql, s);       //�������е�δ����ɨ�ķ���

	Iterator it=a_room.iterator();      //�õ�a_room�ĵ�����
	while(it.hasNext()) {            //ѭ���õ�������Ϣ
		room r=(room)it.next();      //�õ���Ӧ����
		
		if(r instanceof BBRoom) {     //����÷����Ǵ󴲷�
			BBRoom bbroom=(BBRoom)r;   //������ǿ��ת���ɴ󴲷�����
			Vector<Object> v=new Vector<Object>();    //����װ�뷿����Ϣ
			v.add(bbroom.getNo());      //����ż���������
			v.add(bbroom.getPrice());   //����۸��������
			v.add(bbroom.getMoney());   //����Ѻ���������
			v.add("��");                //û�з�������
			v.add(bbroom.getStyle().name());   //�������������
			v.add("��");                //û�з�����
			foodtablevalues.add(v);     //���������ŵ����������
		}
		if(r instanceof CommonRoom) {   //����÷�������ͨ��
			CommonRoom commonroom=(CommonRoom)r;   //������ǿ��ת������ͨ��
			Vector<Object> v=new Vector<Object>();   //���������淿������
			v.add(commonroom.getNo());     //����ż�������
			v.add(commonroom.getPrice());  //����۸��������
			v.add(commonroom.getMoney());  //����Ѻ���������
			v.add(commonroom.getNum());    //����������������
			v.add("��");                   //û�з�����
			v.add("��");                   //û�з�����
			foodtablevalues.add(v);        //���������ŵ����������
		}
		if(r instanceof LuxuryRoom) {    //����÷����Ǻ�����
			LuxuryRoom luxuryroom=(LuxuryRoom)r;   //������ǿ��ת���ɺ�����
			Vector<Object> v=new Vector<Object>();  //���������淿������
			v.add(luxuryroom.getNo());     //����ż�������
			v.add(luxuryroom.getPrice());  //����۸��������
			v.add(luxuryroom.getMoney());  //����Ѻ���������
			v.add("��");       //û�з�������
			v.add("��");       //û�з�����
			v.add(luxuryroom.getRoom_num());   //��������������
			foodtablevalues.add(v);     //��������������������
		}
	}
	lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //��foodcolumnNamesΪ��������foodtablevaluesΪ��������ݽ������ģ��
	lefttabel=new JTable(lefttablemodel);      //�Ըñ��ģ��Ϊģ�ͽ������
	lefttabel.addMouseListener(new MouseAdapter() {   //Ϊ�ñ��������¼�
	
		@Override
		public void mouseClicked(MouseEvent e) {    //�����ʱ���¼�
			// TODO Auto-generated method stub
			int selectedRow=lefttabel.getSelectedRow();    //�õ����������ı�������
			int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());  //�õ�����ķ�����Ϣ�ķ����
			    
			
				String[] s=new String[1];    
				s[0]=String.valueOf(room_no);    //�ַ��������д��뷿����ַ���
				LivingImpl living=new LivingImpl();   //�õ��µķ������
				living.clean(s);                   //����clean()�����ı䷿��״̬
				for(int i=0;i<foodtablevalues.size();i++) {    //ѭ����ȡ����е�����
					if(foodtablevalues.get(i).get(0)==lefttabel.getValueAt(selectedRow, 0)) {   //�ڱ��������ɾ���ոձ���ɨ�ķ�������
						foodtablevalues.remove(i);    
						break;   //����ҵ������ķ������ݣ��Ƴ�ѭ��
					}
				}
				lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);   //���ñ��������ͱ������
				JOptionPane.showMessageDialog(null, "��ɨ�ɹ�");    //��ʾ��ɨ�ɹ�����
			
				
			
			
		}
	});
	
	JScrollPane scrollpane=new JScrollPane();   //�õ�JScrollPane
	scrollpane.setViewportView(lefttabel);  //��������JScrollPane��
	topPane.add(scrollpane,BorderLayout.CENTER);  //��JScrollPane�������
}
}
