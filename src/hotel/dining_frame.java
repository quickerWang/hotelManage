/**
 * @author ��˼��
 * 20180713
 * ���幦��:���ͽ���
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
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import hotel.Login;



public class dining_frame extends JFrame{
	JTextField field_3=new JTextField();      //����ı���
	
	JTextField field_2=new JTextField();      //�ն�
	JTextField field_1=new JTextField();     //���ѽ���ı���
	 JComboBox comboBox=new JComboBox();       //������
	 JButton button=new JButton();         //���˰�ť
	 java.sql.Statement sql;
	 ResultSet set;
	 String[] s={ "  ", "��    ��", "��Ʒ���", "��Ʒ����", "��    λ",
			"��    ��", "��    ��", "��    ��" };
	 String[] str= {"��  ��","̨  ��","��̨״̬"};
	 private Vector<Vector<Vector<Object>>> menuOfDeskV=new Vector<Vector<Vector<Object>>>();
	 JLabel topLabel;
	 JSplitPane splitpane=new JSplitPane();
	 JPanel leftPane;
	 JPanel rightPane;
	 JPanel bottomPane;
	 DefaultTableModel lefttablemodel;
	 DefaultTableModel righttablemodel;
	 Vector<String> foodcolumnNames=new Vector<String>();     //��¼ǩ���������
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //��¼ǩ�������Ϣ
	 JButton button_3=new JButton();       //ǩ��
	 
	 Vector<String> tabelcolumnNames=new Vector<String>();
	 Vector<Vector<Object>> tablevalues=new Vector<Vector<Object>>();
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //��Ʒ����
	 JTextField numberfield=new JTextField();   //����
	
	
	 JTable righttabel;
	 
	   public void JDBC(){
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				Connection cnn=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/haha","","");
				sql=cnn.createStatement();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
     public dining_frame() {
    	 JDBC();
    	 setSize(1024,768);
    	 setLocationRelativeTo(null);
    	 setResizable(false);
    	 setLayout(new BorderLayout());
    	 getContentPane().add(getTopLabel(),BorderLayout.NORTH);          
    	 getContentPane().add(getSplitPane(),BorderLayout.CENTER);
    	 getContentPane().add(getBottomPanel(),BorderLayout.SOUTH);
    	 
     }

    
     
	private JPanel getBottomPanel(){
		// TODO Auto-generated method stub
		
		bottomPane=new JPanel();
		bottomPane.setLayout(new BorderLayout());
		JPanel uppanel=new JPanel();    //����
		bottomPane.add(uppanel,BorderLayout.NORTH);
		uppanel.setLayout(new GridLayout(1, 13));
		
		uppanel.add(get_combobox());
		JLabel table_number=new JLabel("̨��");  //
		uppanel.add(table_number);
		
		  //
		uppanel.add(namefield);
		JLabel name=new JLabel("��Ʒ����"); //
		uppanel.add(name);
		
	
		uppanel.add(numberfield);
		JLabel number=new JLabel("����"); //
		uppanel.add(number);
			
		
		
		JPanel downpanel=new JPanel();
		downpanel.setLayout(new GridLayout(1,3));
		bottomPane.add(downpanel,BorderLayout.CENTER);
		
		JPanel leftpanel=new JPanel(new GridLayout(4, 1));
		JPanel panel_1=new JPanel(new GridLayout(1, 2));
		JLabel label_1=new JLabel("���ѽ��");
		
		panel_1.add(field_1);
		panel_1.add(label_1);
		leftpanel.add(panel_1);
		
		JPanel panel_2=new JPanel(new GridLayout(1, 2));
		JLabel label_2=new JLabel("ʵ�����");
		panel_2.add(field_2);
		panel_2.add(label_2);
		leftpanel.add(panel_2);
		
		JPanel panel_3=new JPanel(new GridLayout(1, 2));
		JLabel label_3=new JLabel("����");
		
		panel_3.add(field_3);
		panel_3.add(label_3);
		leftpanel.add(panel_3);
	
		leftpanel.add(get_calculate());
		downpanel.add(leftpanel);
		
		
		JPanel centerpanel=new JPanel();
		centerpanel.setLayout(null);
		centerpanel.add(start_paper());

		
		centerpanel.add(start_Desk());
		downpanel.add(centerpanel);
		
		
		centerpanel.add(getbutton_3());
		
		Calendar c = Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		month++;
		int day=c.get(Calendar.DATE);
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		
		
		Login.label_time_1.setBounds(100,25,250,20);
		Login.label_time_1.setFont(new Font("������κ",Font.BOLD, 18));
		
	
		Login.label_time_2.setBounds(100,50,250,20);
		Login.label_time_2.setFont(new Font("������κ",Font.BOLD, 18));
		
		JLabel label_user=new JLabel(Login.user);
		label_user.setBounds(100,75,250,20);
		label_user.setFont(new Font("������κ",Font.BOLD, 18));
		
		
		JPanel rightpanel=new JPanel();
		rightpanel.add(Login.label_time_1);
		rightpanel.add(Login.label_time_2);
		rightpanel.add(label_user);
		rightpanel.setLayout(null);
		downpanel.add(rightpanel);
		return bottomPane;
	}

	private JButton get_calculate(){
		button.setText("����");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = righttabel.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ���˵�̨�ţ�", "������ʾ",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					int rowCount = lefttabel.getRowCount();// ��ý��˲�̨�ĵ������
					String NEW = lefttabel.getValueAt(rowCount - 1, 0)
							.toString();// �������˵ı��
					if (NEW.equals("new")) {// �������˱����Ϊ��NEW��,�򵯳���ʾ
						JOptionPane.showMessageDialog(null, "����ȷ��δǩ����Ʒ�Ĵ���ʽ��",
								"������ʾ", JOptionPane.INFORMATION_MESSAGE);
					} else {
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
							
							String User=Login.user;
							double sum=Double.parseDouble(field_1.getText());
							String tabel=righttabel.getValueAt(selectedRow, 0).toString();
							//String date=Login.time_1;
							String date=Login.time_1+Login.time_2;
						
							try {
								try {
									Class.forName("com.mysql.jdbc.Driver");
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								Connection cnn=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/haha","","");
								java.sql.PreparedStatement Sql=cnn.prepareStatement("insert into consume(user,sum,desk_id,date) values(?,?,?,?)");
								Sql.setString(1,User);
								Sql.setDouble(2,sum);
								Sql.setString(3, tabel);
								Sql.setString(4, date);
								Sql.executeUpdate();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
							for (int i = 0; i < rowCount; i++) {// ͨ��ѭ����ø���������Ŀ����Ϣ
								int id=1;
								String food_id=lefttabel.getValueAt(i, 2).toString();
								int num=Integer.parseInt(lefttabel.getValueAt(i, 5).toString());
								double Sum=Double.parseDouble(lefttabel.getValueAt(i, 7).toString());
								int ID=1;
									try {
										try {
											Class.forName("com.mysql.jdbc.Driver");
										} catch (ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										ResultSet set=sql.executeQuery("select * from consume");
										while(set.next()) {
											ID=set.getInt("id");
										}
										Connection cnn=DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/haha","","");
										java.sql.PreparedStatement Sql=cnn.prepareStatement("insert into consume_item(consume_id,food_id,num,sum) values(?,?,?,?)");
										Sql.setInt(1,ID);
										Sql.setString(2, food_id);
										Sql.setInt(3, num);
										Sql.setDouble(4, Sum);
										Sql.executeUpdate();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
							}
							JOptionPane.showMessageDialog(null, righttabel
									.getValueAt(selectedRow, 0)
									+ " ������ɣ�", "������ʾ",
									JOptionPane.INFORMATION_MESSAGE);// �������������ʾ
							righttablemodel.removeRow(selectedRow);// �ӡ���̨�б���ȡ����̨
							foodtablevalues.removeAllElements();// ��ա�ǩ���б�
							lefttablemodel.setDataVector(foodtablevalues,
									foodcolumnNames);// ˢ�¡�ǩ���б�
							field_2.setText("0.00");// ��ա�ʵ�ս��ı���
							field_3.setText("0.00");// ��ա�������ı���
							menuOfDeskV.remove(selectedRow);// �ӡ�ǩ���б��������Ƴ��ѽ��˵�ǩ���б�
						}
					}
				}
			}
		});
		return button;
	}



	private JLabel getTopLabel() {
		//TODO Auto-generated method stub
		topLabel=new JLabel();
		topLabel.setBounds(0,0,1018,100);
		topLabel.setIcon(new ImageIcon("image/top.jpg"));
		return topLabel;
	}
	public JPanel getLeftPane() {
		leftPane=new JPanel();
		leftPane.setLayout(new BorderLayout());
		leftPane.add(new JLabel("ǩ��"),BorderLayout.NORTH);
		for(int i=0;i<s.length;i++) {
			foodcolumnNames.add(s[i]);
		}
	
		lefttablemodel=new DefaultTableModel(foodtablevalues,foodcolumnNames);
		lefttabel=new JTable(lefttablemodel);
		lefttablemodel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int sum=0;
				for(int i=0;i<lefttabel.getRowCount();i++) {
					sum+=Integer.parseInt(lefttabel.getValueAt(i, 7).toString());
					field_1.setText(String.valueOf(sum));
				}
			}
		});
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(lefttabel);
		leftPane.add(scrollpane);
		return leftPane;
	}
	public JPanel getRightPane() {
		rightPane=new JPanel();
		rightPane.setLayout(new BorderLayout());
		rightPane.add(new JLabel("��̨"),BorderLayout.NORTH);
		for(int i=0;i<str.length;i++) {
			tabelcolumnNames.add(str[i]);
		}
	
		righttablemodel=new DefaultTableModel(tablevalues,tabelcolumnNames);
		righttabel=new JTable(righttablemodel);
		righttabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = righttabel.getSelectedRow();// ��á���̨�б��е�ѡ����
				foodtablevalues.removeAllElements();// ��ա�ǩ���б��е�������
				foodtablevalues.addAll(menuOfDeskV.get(selectedRow));// ��ѡ��̨�ŵ�ǩ���б���ӵ���ǩ���б���
				lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);// ˢ�¡�ǩ���б�
				  comboBox .setSelectedItem(righttabel.getValueAt(selectedRow, 2)); 

			}
		});
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(righttabel);
		rightPane.add(scrollpane);
		return rightPane;
	}
	public JSplitPane getSplitPane(){
		splitpane=new JSplitPane();
		splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitpane.setDividerLocation(800);// �������Ĭ�ϵķָ�λ��
		splitpane.setDividerSize(10);// ���÷ָ����Ŀ��
		splitpane.setLeftComponent(getLeftPane());
		splitpane.setRightComponent(getRightPane());
		return splitpane;
	}  
    public JButton start_Desk() {
		JButton button_2=new JButton("��̨");
		button_2.setBounds(150,30,80,60);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = righttabel.getRowCount();// ��ÿ�̨�б��е����������ѿ�̨��
				if (rowCount >= 0) {// �Ѿ��п�̨
					String selectedDeskNum = comboBox.getSelectedItem().toString();
							// ��á�̨�š������˵���ѡ�е�̨��
					int needSelectedRow = -1;// Ĭ��ѡ�е�̨��δ��̨
					for (int row = 0; row < rowCount; row++) {// ͨ��ѭ���鿴ѡ�е�̨���Ƿ��Ѿ���̨
						String openedDeskNum =righttabel.getValueAt(row, 0).toString();// ����ѿ�̨��̨��
						if (selectedDeskNum.equals(openedDeskNum)) {// �鿴ѡ�е�̨���Ƿ��Ѿ���̨
							needSelectedRow = row;// ѡ�е�̨���Ѿ���̨
							break;// ����ѭ��
						}
					}
					if (needSelectedRow == -1) {// ѡ�е�̨����δ��̨�����¿�̨
						righttabel.clearSelection();// ȡ��ѡ�񡰿�̨�б��е�ѡ����
						
						try {
							set = sql.executeQuery("select * from desk");
							while(set.next()) {
								if(set.getString(1).equals(selectedDeskNum)) {
									Vector<Object> v=new Vector<Object>();
									v.add(set.getString(1));
									v.add(set.getString(2));
									v.add(set.getInt(3));
									tablevalues.add(v);
									break;
								}
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						righttablemodel.setDataVector(tablevalues, tabelcolumnNames);
						menuOfDeskV.add(new Vector<Vector<Object>>());
						//lefttablemodel.setDataVector(tablevalues,     //?
								//tabelcolumnNames);// ˢ�¡�ǩ���б�
					}
					else
					{
						JOptionPane.showMessageDialog(null, "�����ѱ�ʹ��");
					}
					}
				}
		});
		return button_2;
    }
    public JComboBox get_combobox() {
  	  //  ̨��ѡ����
  	
  	comboBox.removeAllItems();
  	comboBox.addItem("��ѡ��");
  	try {
  		set = sql.executeQuery("select * from desk");
  		while(set.next()) {
  			comboBox.addItem(set.getString(1));
  		}
  	} catch (SQLException e1) {
  		// TODO Auto-generated catch block
  		e1.printStackTrace();
  	}
  	//comboBox.setNextFocusableComponent(field);   
  	return comboBox;
  }
    private Component getbutton_3() {
		// TODO Auto-generated method stub
		button_3.setText("ǩ��");
		button_3.setBounds(250,30,80,60);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =righttabel.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫǩ����̨�ţ�", "������ʾ",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					int row = lefttabel.getRowCount() - 1;
					String NEW = lefttabel.getValueAt(row, 0).toString();
					if (NEW.equals("new")) {
						foodtablevalues.removeAllElements();
						foodtablevalues.addAll(menuOfDeskV.get(selectedRow));
						for (; row >= 0; row--) {
							foodtablevalues.get(row).set(0, "");
						}
						lefttablemodel.setDataVector(foodtablevalues,foodcolumnNames);
						lefttabel.setRowSelectionInterval(0, 0);
					}
				}
			}
		});
		return button_3;
	}
    
    public JButton start_paper() {
   	 JButton button_1=new JButton("����");
   	 button_1.setBounds(50,30,80,60);
   	 button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String input = namefield.getText().trim();// �����������
				String number=numberfield.getText().trim();
				int flag=0;
				if (input.length() > 0&&number.length()>0) {// �������ݲ�Ϊ��
					ResultSet set;
					try {
						set = sql.executeQuery("select * from food");
						while(set.next()) {
							if(set.getString("name").equals(input)) {
								String selection=comboBox.getSelectedItem().toString();
								Vector v=new Vector<Object>();
								v.add("new");
								v.add(lefttabel.getRowCount()+1);
                               v.add(set.getString(1));
                               v.add(set.getString(2));
                               v.add(set.getString(4));
                               v.add(numberfield.getText());
                               v.add(set.getString(3));
                               v.add(Integer.parseInt(set.getString(3))*Integer.parseInt(numberfield.getText()));
								menuOfDeskV.get(righttabel.getSelectedRow()).add(v);
								lefttablemodel.setDataVector(menuOfDeskV.get(righttabel.getSelectedRow()), foodcolumnNames);
								flag=1;
								break;
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (flag==0) {// �����ڷ��������Ĳ�Ʒ
					JOptionPane.showMessageDialog(null, "û�иò�Ʒ");
					namefield.setText(null);
					numberfield.setText(null);
				} 
			}
		});
   	 return button_1;
    }
}
