/**
 * @author ������
 * 20180714
 * ���������ʵ��
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
	JTextField field_3=new JTextField();      //����ı���
	
	JTextField field_2=new JTextField();      //�ն�
	JTextField field_1=new JTextField();     //���ѽ���ı���
	int days;         //��������
	
	 JButton button=new JButton();         //���˰�ť

	 
	 String[] s={ "���� ��", "��  ��", "Ѻ  ��", "��  ��",   //�����������
			"��������", "�׷���"};
	 String[] str= {"��  ��","���֤��","��  ��"};     //������Ϣ��������
	 
	 JLabel topLabel;            //ͷ��ͼƬ
	 JSplitPane splitpane=new JSplitPane();     //�м�ָ����
	 JPanel leftPane;               // �м�ָ������߱��
	 JPanel rightPane;               //�м�ָ�����ұ߱��
	 JPanel bottomPane;              //�ײ����
	 DefaultTableModel lefttablemodel;         //���������
	 DefaultTableModel righttablemodel;        //���������
	 Vector<String> foodcolumnNames=new Vector<String>();     //��¼����������
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //��¼��������Ϣ
	 JButton button_3=new JButton();       //ǩ��
	 
	 ArrayList<room> a_room=new ArrayList<room>();    //���淿����Ϣ�ļ���
	 ArrayList<consumer> a_consumer=new ArrayList<consumer>();     //����ͻ���Ϣ�ļ���
	 Vector<String> peoplecolumnNames=new Vector<String>();        //��������
	 Vector<Vector<Object>> peoplevalues=new Vector<Vector<Object>>();  //����ֵ
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //�����ı���
	 JTextField sexfield=new JTextField();   //�Ա��ı���
	 JTextField idfield=new JTextField();   //���֤���ı���
	 JTextField dayfield=new JTextField();  //�����ı���
	
	
	 JTable righttabel;            //������
	 /**
	  * @author ������
	  * 20180714
	  * ����Ļ�����������
	  */
     public living_start() {
    	 setSize(880,700);    //����ҳ���С   
    	 setLocationRelativeTo(null);    //����ҳ�����
    	 setResizable(false);     //����ҳ���޷����ڴ�лŶ
    	 setLayout(new BorderLayout());   //����ҳ�沼��Ϊ�߽粼��
    
    	 getContentPane().add(getTopLabel(),BorderLayout.NORTH);   //��ҳ���м��������ڱ���          
    	 getContentPane().add(getSplitPane(),BorderLayout.CENTER);  //��ҳ���м����������м�
    	 getContentPane().add(getBottomPanel(),BorderLayout.SOUTH);  //��ҳ���м����������Ϸ�
    	 
     }

     /**
	  * @author ������
	  * 20180714
	  * �õ��ײ������
	  */
     
	private JPanel getBottomPanel(){
		// TODO Auto-generated method stub
		
		bottomPane=new JPanel();       //�õ����Ķ���
		bottomPane.setLayout(new BorderLayout());    //���ø����Ĳ���Ϊ�߽粼��
		JPanel uppanel=new JPanel();    //�õ����
		bottomPane.add(uppanel,BorderLayout.NORTH);   //���������ڵײ����ı���
		uppanel.setLayout(new GridLayout(1, 4));   //���ø����Ĳ���Ϊ���񲼾�
		
		uppanel.add(dayfield);         //�������ı����������
		JLabel day=new JLabel("����");     //������ǩ  
		uppanel.add(day);               //������ǩ��������

		uppanel.add(namefield);        //�����ı���������
		JLabel table_number=new JLabel("����");  //������ǩ
		uppanel.add(table_number);   //������ǩ��������
		
		  
		uppanel.add(sexfield);    //�Ա��ı���������
		JLabel name=new JLabel("�Ա�"); //�Ա��ǩ
		uppanel.add(name);      //�Ա��ǩ��������
		
	
		uppanel.add(idfield);   //���֤���ı���������
		JLabel number=new JLabel("���֤��"); //���֤�ű�ǩ
		uppanel.add(number);   //���֤�ű�ǩ��������
		
			
		
		
		JPanel downpanel=new JPanel();   //�õ����
		downpanel.setLayout(new GridLayout(1,3));    //���ø����Ĳ���Ϊ���񲼾�
		bottomPane.add(downpanel,BorderLayout.CENTER);    //�������ӵ��ײ������м�
		
		JPanel leftpanel=new JPanel(new GridLayout(4, 1));     //�õ�����Ϊ���Բ��ֵ����leftpanel
		JPanel panel_1=new JPanel(new GridLayout(1, 2));      //�õ�����Ϊ���Բ��ֵ����panel_1
		JLabel label_1=new JLabel("���ѽ��");     //���ѽ��label;
		
		panel_1.add(field_1);      //�����ѽ���ı������panel_1
		panel_1.add(label_1);      //�����ѽ���ǩ����panel_1
		leftpanel.add(panel_1);    //��panel_1���뵽leftpanel
		
		JPanel panel_2=new JPanel(new GridLayout(1, 2));  //�õ�����Ϊ���񲼾ֵ����panel_2
		JLabel label_2=new JLabel("ʵ�����");   //�õ�ʵ������ǩ
		panel_2.add(field_2);          //��ʵ������ı������panel_2
		panel_2.add(label_2);      //��ʵ������ǩ����panel_2
		leftpanel.add(panel_2);    //panel_2���뵽leftpanel
		
		JPanel panel_3=new JPanel(new GridLayout(1, 2));     //����Ϊ���񲼾ֵ����panel_3
		JLabel label_3=new JLabel("����"); //�����ǩ
		
		panel_3.add(field_3);   //�������ı�����뵽panel_3��
		panel_3.add(label_3);   //�������ǩ���뵽panel_3��
		leftpanel.add(panel_3);   //��panel_3���뵽leftpanel��
	
		leftpanel.add(get_calculate());    //�����˰�ť���뵽lefpanel��
		downpanel.add(leftpanel);  //��leftpanel�����뵽downpanel��
		
		
		JPanel centerpanel=new JPanel();    //�õ����centerpanel
		centerpanel.setLayout(null);    //����centerpanel����Ϊ���Բ���
		centerpanel.add(start_paper());   //�����˰�ť����centerpanel

		downpanel.add(centerpanel);    //��centerpanel���뵽downpanel��
		
		
		
		
		
		Login.label_time_1.setBounds(100,25,250,20);   //����label_time_1�Ĵ�Сλ��
		Login.label_time_1.setFont(new Font("������κ",Font.BOLD, 18));   //����label����
		
	
		Login.label_time_2.setBounds(100,50,250,20);  //����label_time_2�Ĵ�Сλ��
		Login.label_time_2.setFont(new Font("������κ",Font.BOLD, 18));  //����label����
		
		JLabel label_user=new JLabel(Login.user);   //label_user�ı�ΪLogin.user
		label_user.setBounds(100,75,250,20);    //����label_user�Ĵ�С��λ��
		label_user.setFont(new Font("������κ",Font.BOLD, 18));   //����label����
		
		
		JPanel rightpanel=new JPanel();    //�õ����rightpanel
		rightpanel.add(Login.label_time_1);   //Login.label_time_1���뵽rightpanel��
		rightpanel.add(Login.label_time_2);   //Login.label_time_2���뵽rightpanel��
		rightpanel.add(label_user);       //label_user����rightpanel
		rightpanel.setLayout(null);   //����rightpanel����Ϊ���Բ���
		downpanel.add(rightpanel);   //rightpanel���뵽downpanel��
		return bottomPane;
	}
//----------------------------------------------------------------
	private JButton get_calculate(){         //����
		button.setText("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = lefttabel.getSelectedRow();
						float expenditure = Float.valueOf(field_1
								.getText());// ������ѽ��
						float realWages = Float.valueOf(field_2
								.getText());// ���ʵ�ս��
						if (realWages < expenditure) {// ���ʵ�ս��С�����ѽ��򵯳���ʾ
							if (realWages == 0.0f)
								JOptionPane
										.showMessageDialog(null, "������ʵ�ս�",
												"������ʾ",
												JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,
										"ʵ�ս���С�����ѽ�", "������ʾ",
										JOptionPane.INFORMATION_MESSAGE);
							field_2.requestFocus();// ���ʵ�ս��ı����ý���
						} else {
							field_3.setText(realWages - expenditure
									+ "0");// ���㲢���á������
							
						
							int room_no=Integer.parseInt(lefttabel.getValueAt(selectedRow, 0).toString());
		                
							int rowCount=righttabel.getRowCount();
							for (int i = 0; i < rowCount; i++) {// ͨ��ѭ����ø���������Ŀ����Ϣ
								
								String people_id=righttabel.getValueAt(i, 1).toString();
								String start=Login.time_1+Login.time_2;       //���ϵͳ��ǰʱ��
								
								
								//��list�в�������
							
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
								//��consumer�м�������
								living.checkconsumer(sh, s3);
									
					
							
							String[] s4=new String[1];
							s4[0]=String.valueOf(room_no);
							//����room����
							living.checkroom(s4);
							
							
							JOptionPane.showMessageDialog(null, 
									 " ������ɣ�", "������ʾ",
									JOptionPane.INFORMATION_MESSAGE);// �������������ʾ

							field_2.setText("0.00");// ��ա�ʵ�ս��ı���
							field_3.setText("0.00");// ��ա�������ı���
						
						}
					}
			}
			
		});
		return button;
	}

	/**
	  * @author ������
	  * 20180714
	  * �õ��������
	  */

	private JLabel getTopLabel() {
		//TODO Auto-generated method stub
		topLabel=new JLabel();//�õ�topLabel
		topLabel.setBounds(0,0,880,128);   //����label�Ĵ�С��λ��
		topLabel.setIcon(new ImageIcon("image/4-0.png"));  //����label��ͼƬ
		return topLabel;
	}
	public JPanel getLeftPane() {
		leftPane=new JPanel();   //�õ�leftPane
		leftPane.setLayout(new BorderLayout());   //����leftpane����ΪleftPane
		leftPane.add(new JLabel("����"),BorderLayout.NORTH);   //������label���뵽leftpane�ı���
		for(int i=0;i<s.length;i++) {       //�������
			foodcolumnNames.add(s[i]);
		}
		LivingImpl living=new LivingImpl();    //ded�������
		String sql="select * from room where state=0 and clean=0";        //�����ѱ���ɨ�ķ����sql���
		
		String []s=new String[0];
		
		a_room=(ArrayList)living.selectroom(sql, s);   //���ҵ��ѱ���ɨ�ķ���
		
		
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
		
		lefttabel.addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseClicked(MouseEvent e) {   //������¼�
				// TODO Auto-generated method stub
				int select=lefttabel.getSelectedRow();  //�õ���ѡ��ı����
				
			
				double m_1 = 0;          //�������
				
				try{if(dayfield.getText().length()==0) {     //day�ı���Ϊ��
					throw new Exception("������дס������");   //���쳣
				}
				else {	
				for(int i=0;i<dayfield.getText().length();i++) {   //day�ı��в�������
					if(!Character.isDigit(dayfield.getText().charAt(i))) {
						throw new Exception("ס����������������");   //���쳣
				}
				}
				days=Integer.parseInt(dayfield.getText());   //�õ�day�ı�������
				if(!lefttabel.getValueAt(select, 3).toString().equals("��")) {     //�÷���Ϊ��ͨ��
					CommonRoom r=new CommonRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),Integer.parseInt(lefttabel.getValueAt(select, 3).toString())); //������ͨ������
					m_1=r.sum(days);  //�õ�����۸�

				}
				if(!lefttabel.getValueAt(select, 4).toString().equals("��")) {  //�÷���Ϊ�󴲷�
					BBRoom r=new BBRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),RoomStyle.valueOf(lefttabel.getValueAt(select, 4).toString())); //�����󴲷�����
					m_1=r.sum(days); //�õ�����۸�
				}
				if(!lefttabel.getValueAt(select, 5).toString().equals("��")) {   //�÷���Ϊ������
					LuxuryRoom r=new LuxuryRoom(Integer.parseInt(lefttabel.getValueAt(select, 0).toString()),Double.parseDouble(lefttabel.getValueAt(select, 1).toString()),
							true,true,
							Integer.parseInt(lefttabel.getValueAt(select, 2).toString()),Integer.parseInt(lefttabel.getValueAt(select, 5).toString())); //��������������
					m_1=r.sum(days); //�õ�����۸�
				}
				double m=Double.parseDouble(lefttabel.getValueAt(select,2).toString()); //�õ�����Ѻ��
				field_1.setText(String.valueOf(m+m_1));   //����Ӧ�����
				}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());  //��ʾ�쳣��Ϣ
				}
			}
		});
		JScrollPane scrollpane=new JScrollPane();    //�õ�scrollpane����
		scrollpane.setViewportView(lefttabel);   //��lefttable����scrollpane
		leftPane.add(scrollpane);   //scrollpane����leftpane
		return leftPane;
	
	}
	/**
	  * @author ������
	  * 20180714
	  * �õ��Ҳ����
	  */
	public JPanel getRightPane() {
		rightPane=new JPanel();  //�õ�rightPane���
		rightPane.setLayout(new BorderLayout());  //���ò���Ϊ�߽粼��
		rightPane.add(new JLabel("����"),BorderLayout.NORTH);  //���˱�ǩ�ӵ�rightpane�ı���
		for(int i=0;i<str.length;i++) {  //�����������
			peoplecolumnNames.add(str[i]);  
		}
	    
		righttablemodel=new DefaultTableModel(peoplevalues,peoplecolumnNames); //����peoplecolumnNames��peoplevalues�Ķ����ģ��
		righttabel=new JTable(righttablemodel);  //���øñ��ģ�彨�����
	
		JScrollPane scrollpane=new JScrollPane();    //�õ�scrollpane����
		scrollpane.setViewportView(righttabel);  //����righttabel���뵽scrollpane
		rightPane.add(scrollpane);   //scrollpane����rightpane
		return rightPane;
	}
	public JSplitPane getSplitPane(){
		splitpane=new JSplitPane();   //�½��ָ����
		splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  //ˮƽ�ָ�
		splitpane.setDividerLocation(700);// �������Ĭ�ϵķָ�λ��
		splitpane.setDividerSize(10);// ���÷ָ����Ŀ��
		splitpane.setLeftComponent(getLeftPane());   //�������
		splitpane.setRightComponent(getRightPane());//�������
		return splitpane;
	}  
  
    
	/**
	  * @author ������
	  * 20180714
	  * �õ����밴ť
	  */
    public JButton start_paper() {
   	 JButton button_1=new JButton("����");  //���˰�ť
   	 button_1.setBounds(50,30,80,60);   //���ð�ť��Сλ��
   	 button_1.addActionListener(new ActionListener() {   //���������¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				String input_name = namefield.getText().trim();// �����������
				String input_sex=sexfield.getText().trim(); // �����������
				String input_id=idfield.getText().trim(); // �����������
				try{
					 if (input_name.length()==0||input_id.length()==0||input_sex.length()==0) {    //�������ݲ�ȫ
						 throw new Exception("��Ϣ��ȫ������������");   //�׳��쳣
					 }
					 if("Male".equals(sexfield.getText().trim())||"Female".equals(sexfield.getText().trim()))   //�Ա�������ȷ
					 {input_sex=sexfield.getText().trim();}
					 else  //�Ա�������ȷ
						 throw new Exception("�Ա������Male or Female!");  //�׳��쳣

					if(idfield.getText().trim().length()==18) {    //���֤����ȷ
			        input_id=idfield.getText().trim();}
				else              //���֤�Ŵ���
					{
						throw new Exception("���֤�ű���18λ��");   //�׳��쳣
					}
				 
										Vector<Object> v=new Vector<Object>	();   //����
										v.add(input_name);     //��������
										v.add(input_id);     //����id
										v.add(input_sex);   //�����Ա�
										peoplevalues.add(v);    //�ù˿ͼ��뵽���������
										righttablemodel.setDataVector(peoplevalues, peoplecolumnNames);  //����peoplecolumnNames��peoplevalues�������ģ��
								
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, (ex.getMessage()));  //��ʾ�쳣��Ϣ
				}finally {
					namefield.setText(null);  //�����ı����ÿ�
					idfield.setText(null);  //���֤�ı����ÿ�
					sexfield.setText(null);   //�Ա��ı����ÿ�
					dayfield.setText(null);  //�����ı����ÿ�
					
				}
			}
		});
   	 return button_1;
    }
}

