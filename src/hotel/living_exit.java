/**
 * @author ��˼��
 * �˷�ҳ��
 * 20180713
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
import hotel.service.Living;
import hotel.service.impl.LivingImpl;

public class living_exit extends JFrame{
	
	 String[] s={ "���� ��", "��  ��", "Ѻ  ��", "��  ��",
				"��������", "�׷���"};   //�����������
	 JLabel topLabel;            //ͷ��ͼƬ
	 JSplitPane splitpane=new JSplitPane();     //�м�ָ����
	 JPanel topPane=new JPanel();               // �м�ָ������߱��

	 DefaultTableModel lefttablemodel;         //���������
	
	 Vector<String> foodcolumnNames=new Vector<String>();     //��¼����������
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //��¼��������Ϣ
	
	 
	 ArrayList<room> a_room=new ArrayList<room>();   //�õ���������Ϣ��ArrayList
	 JTable lefttabel;     //������
	 /**
	  * @author ��˼��
	  * 20180713
	  *����Ļ������ԣ����С������
	  */
	 public living_exit() {      
		 setResizable(false);    //����Ϊ���ɵ���
		 setLocationRelativeTo(null);   //����ҳ�����
		 setSize(400,300);       //���ý����С
		 setLayout(new BorderLayout());    //���ò���Ϊ�߽粼��
     getContentPane().add(topPane,BorderLayout.NORTH);     //��topPane�����뵽�����б���
	topPane.setLayout(new BorderLayout());                //����topPaneΪ�߽粼��
	topPane.add(new JLabel("����"),BorderLayout.NORTH);    //�������ǩ�ӵ�topPane�ı���
	for(int i=0;i<s.length;i++) {       //�����������
		foodcolumnNames.add(s[i]);
	}
    
	
      
	
	
	
	String sql="select * from room where state=1";   //�����Ѿ�ס�˵�room��sql���
	String []s=new String[0];                        
	LivingImpl living=new LivingImpl();    //�õ�����Ķ���
	a_room=(ArrayList)living.selectroom(sql, s);     //����selectroom()�����õ��Ѿ�ס�˵�room����
	

	Iterator it=a_room.iterator();     //�õ�ArrayList�ĵ�����
	while(it.hasNext()) {      //ѭ����ȡroom���ݵ������
		room r=(room)it.next();   //�õ�room����
		
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
	lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);  //����foodcolumnNamesΪ������foodtablevaluesΪ������ݽ������ģ��
	lefttabel=new JTable(lefttablemodel);//���øñ��ģ�ͽ������
	lefttabel.addMouseListener(new MouseAdapter() {   //���������¼�
	
		@Override
		public void mouseClicked(MouseEvent e) {    //�����ʱ�������¼�
			// TODO Auto-generated method stub  
			int selectedRow=lefttabel.getSelectedRow();   //�õ�ѡ��ı������
			int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());  //�õ����з�����Ϣ�ķ����
			int ya=Integer.parseInt(lefttabel.getValueAt(selectedRow, 2).toString());   //�õ����з�����Ϣ��Ѻ��
		
			String []s={String.valueOf(room_no)};        //��������һ��������ַ������ַ�������
			LivingImpl living=new LivingImpl();    //�õ���Ӧ�������
			living.roomExit(s);      //����roomExit�����ı䷿��״̬
			
			String []sh={String.valueOf(ya),String.valueOf(room_no)};   //��������������ַ�����Ѻ���ַ������ַ�������
			living.check(sh);        //����check�����ı����ѵ�״̬
			for(int i=0;i<foodtablevalues.size();i++) {   //ѭ����ѯ���������
				if(foodtablevalues.get(i).get(0)==lefttabel.getValueAt(selectedRow, 0)) {   //�ӱ����ɾ���ո��˷��ķ�����Ϣ
					foodtablevalues.remove(i);
					break;   //�ҵ������ķ�����Ϣ������ѭ��
				}
			}
			lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);   //��foodcolumnNamesΪ������foodtablevaluesΪ������ݽ������ģ��
			JOptionPane.showMessageDialog(null, "�˳��ɹ�");  //��ʾ�˳��ɹ�
		}
	});
	
	JScrollPane scrollpane=new JScrollPane();   //�õ�JScrollPane
	scrollpane.setViewportView(lefttabel);  //��������JScrollPane��
	topPane.add(scrollpane,BorderLayout.CENTER);  //��JScrollPane�������
}
}
