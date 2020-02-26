/**
 * @author 孙思佳
 * 20180713
 * 具体功能:订餐界面
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
	JTextField field_3=new JTextField();      //余额文本框
	
	JTextField field_2=new JTextField();      //收额
	JTextField field_1=new JTextField();     //消费金额文本框
	 JComboBox comboBox=new JComboBox();       //下拉框
	 JButton button=new JButton();         //结账按钮
	 java.sql.Statement sql;
	 ResultSet set;
	 String[] s={ "  ", "序    号", "商品编号", "商品名称", "单    位",
			"数    量", "单    价", "金    额" };
	 String[] str= {"序  号","台  号","开台状态"};
	 private Vector<Vector<Vector<Object>>> menuOfDeskV=new Vector<Vector<Vector<Object>>>();
	 JLabel topLabel;
	 JSplitPane splitpane=new JSplitPane();
	 JPanel leftPane;
	 JPanel rightPane;
	 JPanel bottomPane;
	 DefaultTableModel lefttablemodel;
	 DefaultTableModel righttablemodel;
	 Vector<String> foodcolumnNames=new Vector<String>();     //记录签单表格列名
	 Vector<Vector<Object>> foodtablevalues=new Vector<Vector<Object>>();   //记录签单表格信息
	 JButton button_3=new JButton();       //签单
	 
	 Vector<String> tabelcolumnNames=new Vector<String>();
	 Vector<Vector<Object>> tablevalues=new Vector<Vector<Object>>();
	 JTable lefttabel;
	 JTextField namefield=new JTextField();      //商品名称
	 JTextField numberfield=new JTextField();   //数量
	
	
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
		JPanel uppanel=new JPanel();    //北面
		bottomPane.add(uppanel,BorderLayout.NORTH);
		uppanel.setLayout(new GridLayout(1, 13));
		
		uppanel.add(get_combobox());
		JLabel table_number=new JLabel("台号");  //
		uppanel.add(table_number);
		
		  //
		uppanel.add(namefield);
		JLabel name=new JLabel("商品名称"); //
		uppanel.add(name);
		
	
		uppanel.add(numberfield);
		JLabel number=new JLabel("数量"); //
		uppanel.add(number);
			
		
		
		JPanel downpanel=new JPanel();
		downpanel.setLayout(new GridLayout(1,3));
		bottomPane.add(downpanel,BorderLayout.CENTER);
		
		JPanel leftpanel=new JPanel(new GridLayout(4, 1));
		JPanel panel_1=new JPanel(new GridLayout(1, 2));
		JLabel label_1=new JLabel("消费金额");
		
		panel_1.add(field_1);
		panel_1.add(label_1);
		leftpanel.add(panel_1);
		
		JPanel panel_2=new JPanel(new GridLayout(1, 2));
		JLabel label_2=new JLabel("实付金额");
		panel_2.add(field_2);
		panel_2.add(label_2);
		leftpanel.add(panel_2);
		
		JPanel panel_3=new JPanel(new GridLayout(1, 2));
		JLabel label_3=new JLabel("找零");
		
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
		Login.label_time_1.setFont(new Font("华文新魏",Font.BOLD, 18));
		
	
		Login.label_time_2.setBounds(100,50,250,20);
		Login.label_time_2.setFont(new Font("华文新魏",Font.BOLD, 18));
		
		JLabel label_user=new JLabel(Login.user);
		label_user.setBounds(100,75,250,20);
		label_user.setFont(new Font("华文新魏",Font.BOLD, 18));
		
		
		JPanel rightpanel=new JPanel();
		rightpanel.add(Login.label_time_1);
		rightpanel.add(Login.label_time_2);
		rightpanel.add(label_user);
		rightpanel.setLayout(null);
		downpanel.add(rightpanel);
		return bottomPane;
	}

	private JButton get_calculate(){
		button.setText("结账");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = righttabel.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "请选择要结账的台号！", "友情提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					int rowCount = lefttabel.getRowCount();// 获得结账餐台的点菜数量
					String NEW = lefttabel.getValueAt(rowCount - 1, 0)
							.toString();// 获得最后点菜的标记
					if (NEW.equals("new")) {// 如果最后点菜被标记为“NEW”,则弹出提示
						JOptionPane.showMessageDialog(null, "请先确定未签单商品的处理方式！",
								"友情提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						float expenditure = Float.valueOf(field_1
								.getText());// 获得消费金额
						float realWages = Float.valueOf(field_2
								.getText());// 获得实收金额
						if (realWages < expenditure) {// 如果实收金额小于消费金额，则弹出提示
							if (realWages == 0.0f)
								JOptionPane
										.showMessageDialog(null, "请输入实收金额！",
												"友情提示",
												JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,
										"实收金额不能小于消费金额！", "友情提示",
										JOptionPane.INFORMATION_MESSAGE);
							field_2.requestFocus();// 并令“实收金额”文本框获得焦点
						} else {
							field_3.setText(realWages - expenditure
									+ "0");// 计算并设置“找零金额”
							
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
							
							for (int i = 0; i < rowCount; i++) {// 通过循环获得各个消费项目的信息
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
									+ " 结账完成！", "友情提示",
									JOptionPane.INFORMATION_MESSAGE);// 弹出结账完成提示
							righttablemodel.removeRow(selectedRow);// 从“开台列表”中取消开台
							foodtablevalues.removeAllElements();// 清空“签单列表”
							lefttablemodel.setDataVector(foodtablevalues,
									foodcolumnNames);// 刷新“签单列表”
							field_2.setText("0.00");// 清空“实收金额”文本框
							field_3.setText("0.00");// 清空“找零金额”文本框
							menuOfDeskV.remove(selectedRow);// 从“签单列表”集合中移除已结账的签单列表
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
		leftPane.add(new JLabel("签单"),BorderLayout.NORTH);
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
		rightPane.add(new JLabel("开台"),BorderLayout.NORTH);
		for(int i=0;i<str.length;i++) {
			tabelcolumnNames.add(str[i]);
		}
	
		righttablemodel=new DefaultTableModel(tablevalues,tabelcolumnNames);
		righttabel=new JTable(righttablemodel);
		righttabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = righttabel.getSelectedRow();// 获得“开台列表”中的选中行
				foodtablevalues.removeAllElements();// 清空“签单列表”中的所有行
				foodtablevalues.addAll(menuOfDeskV.get(selectedRow));// 将选中台号的签单列表添加到“签单列表”中
				lefttablemodel.setDataVector(foodtablevalues, foodcolumnNames);// 刷新“签单列表”
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
		splitpane.setDividerLocation(800);// 设置面版默认的分割位置
		splitpane.setDividerSize(10);// 设置分割条的宽度
		splitpane.setLeftComponent(getLeftPane());
		splitpane.setRightComponent(getRightPane());
		return splitpane;
	}  
    public JButton start_Desk() {
		JButton button_2=new JButton("开台");
		button_2.setBounds(150,30,80,60);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = righttabel.getRowCount();// 获得开台列表中的行数，即已开台数
				if (rowCount >= 0) {// 已经有开台
					String selectedDeskNum = comboBox.getSelectedItem().toString();
							// 获得“台号”下拉菜单中选中的台号
					int needSelectedRow = -1;// 默认选中的台号未开台
					for (int row = 0; row < rowCount; row++) {// 通过循环查看选中的台号是否已经开台
						String openedDeskNum =righttabel.getValueAt(row, 0).toString();// 获得已开台的台号
						if (selectedDeskNum.equals(openedDeskNum)) {// 查看选中的台号是否已经开台
							needSelectedRow = row;// 选中的台号已经开台
							break;// 跳出循环
						}
					}
					if (needSelectedRow == -1) {// 选中的台号尚未开台，即新开台
						righttabel.clearSelection();// 取消选择“开台列表”中的选中行
						
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
								//tabelcolumnNames);// 刷新“签单列表”
					}
					else
					{
						JOptionPane.showMessageDialog(null, "该桌已被使用");
					}
					}
				}
		});
		return button_2;
    }
    public JComboBox get_combobox() {
  	  //  台号选择栏
  	
  	comboBox.removeAllItems();
  	comboBox.addItem("请选择");
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
		button_3.setText("签单");
		button_3.setBounds(250,30,80,60);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =righttabel.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "请选择要签单的台号！", "友情提示",
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
   	 JButton button_1=new JButton("开单");
   	 button_1.setBounds(50,30,80,60);
   	 button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String input = namefield.getText().trim();// 获得输入内容
				String number=numberfield.getText().trim();
				int flag=0;
				if (input.length() > 0&&number.length()>0) {// 输入内容不为空
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
				if (flag==0) {// 不存在符合条件的菜品
					JOptionPane.showMessageDialog(null, "没有该菜品");
					namefield.setText(null);
					numberfield.setText(null);
				} 
			}
		});
   	 return button_1;
    }
}
