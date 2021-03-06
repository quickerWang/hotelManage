/**
 * @author 孙思佳
 * 20180715
 * 结算界面
 */

package hotel;

import java.awt.*;
import java.awt.event.*;

import java.text.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;



import hotel.entity.*;
import hotel.service.SystemService;
import hotel.service.impl.SystemServiceImpl;
public class MdataField extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;  //文本框
/**
 * @author 孙思佳
 * 20180715
 * 主界面设置
 */
	public MdataField() {
		super();  //调用父类构造函数
		
		setBounds(600, 200, 300, 250);  //设置界面大小，位置
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置界面关闭方式
		setLayout(null);  //绝对布局


 		JLabel topLabel = new JLabel();  //新建label
 		topLabel.setText("日期：");  //设置文本
 		topLabel.setBounds(60,60,50,20);  //设置label大小位置
 		getContentPane().add(topLabel);  //label加入界面
		textField = new JTextField();  //新建文本框
		textField.setBounds(100,60,50,20);  ///设置文本框大小位置
		textField.setColumns(12);  //设置允许输入长度
		getContentPane().add(textField);  //文本框加入界面

		final JButton button = new JButton();  //展开按钮
		button.setBounds(160,60,60,20);  //设置按钮大小位置
		button.setText("...");  //设置按钮文本
		button.setMargin(new Insets(0, 4, 0, 4));  //按钮边框和标签之间的空白
		button.addActionListener(new ActionListener() {  //按钮点击事件，显示日历
			public void actionPerformed(ActionEvent e) {
				Dimension preferredSize = textField.getPreferredSize();    //封装了一个构件的高度和宽度
				Point locationOnScreen = textField.getLocationOnScreen();   
				int x = (int) locationOnScreen.getX();
				int y = (int) (locationOnScreen.getY() + preferredSize
						.getHeight());
				int width = 310;
				int height = 187;
				JRootPane rootPane = textField.getRootPane();  //返回根面板
				Point rootPaneLocationOnScreen = rootPane.getLocationOnScreen();
				if (height > rootPaneLocationOnScreen.getY()
						+ rootPane.getHeight() - y) {
					y = (int) (locationOnScreen.getY() - height);
				}
				ChooseDateDialog dialog = new ChooseDateDialog();
				dialog.setBounds(x, y, width, height);
				dialog.setVisible(true);
			}
		});
		getContentPane().add(button);  //按钮加入界面
		JButton button_1=new JButton("日结"); //日结按钮
		button_1.setBounds(15,130,70,30);  //设置按钮大小位置
		getContentPane().add(button_1);  //按钮加入界面
		JButton button_2=new JButton("月结");//月结按钮
		button_2.setBounds(105,130,70,30);//设置按钮大小位置
		getContentPane().add(button_2);//按钮加入界面
		JButton button_3=new JButton("年结");//年结按钮
		getContentPane().add(button_3);//按钮加入界面
		button_3.setBounds(195,130,70,30);//设置按钮大小位置
		button_1.addActionListener(new ActionListener() {  //日结按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double sum=0;  //总销售金额
 				String []s=textField.getText().split("-");  //得到年月日
		
 			
 				SystemService system=new SystemServiceImpl();  //新建服务
 				sum=system.sumday(s);  //计算总销售金额
				JOptionPane.showMessageDialog(null,s[0]+"年"+ s[1]+"月："+s[2]+"日"+sum);  //显示信息
			}
		});
		
         button_2.addActionListener(new ActionListener() {//月结按钮点击事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double sum=0;   //销售金额
 				String []s=textField.getText().split("-");  //得到年月日
			
 				SystemService system=new SystemServiceImpl();  //新建服务
 				sum=system.summonth(s);  //计算总销售金额
				JOptionPane.showMessageDialog(null,s[0]+"年"+ s[1]+"月："+sum);  //显示信息
 			}
		});
         
         button_3.addActionListener(new ActionListener() {//年结按钮点击事件
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				double sum=0;  //总销售金额
 				String []s=textField.getText().split("-");  //得到年月日
		
				
 			
 				SystemService system=new SystemServiceImpl();  //得到服务
 				sum=system.sumyear(s);  //计算销售金额
				JOptionPane.showMessageDialog(null, s[0]+"年结:"+sum);  //显示信息
 			}
 		});
		
		//
	}

	class ChooseDateDialog extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int year;

		private int month;

		private int day;

		private int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
				31, 30, 31 };

		private JTextField yTextField;

		private JTextField mTextField;

		private DefaultTableModel tableModel;

		public ChooseDateDialog() {
			super();
			setModal(true);
			setUndecorated(true);
			setBounds(100, 100, 310, 153);

			Calendar today = Calendar.getInstance();
			year = today.get(Calendar.YEAR);
			month = today.get(Calendar.MONTH) + 1;
			day = today.get(Calendar.DAY_OF_MONTH);
			if (year % 4 == 0) {
				if (year % 100 != 0 || year % 400 == 0)
					daysOfMonth[2] = 29;
				else
					daysOfMonth[2] = 28;
			} else {
				daysOfMonth[2] = 28;
			}

			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBorder(new LineBorder(Color.black, 1, false));
			getContentPane().add(panel, BorderLayout.CENTER);

			final JPanel buttonPanel = new JPanel();
			panel.add(buttonPanel, BorderLayout.NORTH);

			final JButton pyButton = new JButton();
			pyButton.setText("<<");
			pyButton.setToolTipText("上一年");
			pyButton.setMargin(new Insets(0, 10, 0, 10));
			pyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					yTextField.setText(--year + "");
					initTableModel();
				}
			});
			buttonPanel.add(pyButton);

			final JButton pmButton = new JButton();
			pmButton.setText("<");
			pmButton.setToolTipText("上一月");
			pmButton.setMargin(new Insets(0, 12, 0, 12));
			pmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					month--;
					if (month < 1) {
						month = 12;
						yTextField.setText(--year + "");
					}
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			buttonPanel.add(pmButton);

			yTextField = new JTextField();
			yTextField.setColumns(4);
			yTextField.setEditable(false);
			yTextField.setHorizontalAlignment(JTextField.CENTER);
			yTextField.setText(year + "");
			buttonPanel.add(yTextField);

			final JLabel yLabel = new JLabel();
			yLabel.setText("年");
			buttonPanel.add(yLabel);

			mTextField = new JTextField();
			mTextField.setColumns(2);
			mTextField.setEditable(false);
			mTextField.setHorizontalAlignment(JTextField.CENTER);
			mTextField.setText(month + "");
			buttonPanel.add(mTextField);

			final JLabel mLabel = new JLabel();
			mLabel.setText("月");
			buttonPanel.add(mLabel);

			final JButton nmButton = new JButton();
			nmButton.setText(">");
			nmButton.setToolTipText("下一月");
			nmButton.setMargin(new Insets(0, 12, 0, 12));
			nmButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					month++;
					if (month > 12) {
						month = 1;
						yTextField.setText(++year + "");
					}
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			buttonPanel.add(nmButton);

			final JButton nyButton = new JButton();
			nyButton.setText(">>");
			nyButton.setToolTipText("下一年");
			nyButton.setMargin(new Insets(0, 12, 0, 12));
			nyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					yTextField.setText(++year + "");
					initTableModel();
				}
			});
			buttonPanel.add(nyButton);

			final JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);

			tableModel = new DefaultTableModel(6, 7);
			String[] columnNames = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五",
					"星期六" };
			tableModel.setColumnIdentifiers(columnNames);
			initTableModel();

			final JTable table = new MTable(tableModel);
			table.setRowSelectionAllowed(false);
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String dayS = table.getValueAt(table.getSelectedRow(),
							table.getSelectedColumn()).toString();
					if (!dayS.startsWith("[")) {
						day = Integer.valueOf(dayS);
						textField.setText(getSelectedDate());
						dispose();
					}
				}
			});
			scrollPane.setViewportView(table);

			final JLabel label = new JLabel();
			label.setText(" ");
			panel.add(label, BorderLayout.WEST);

			final JLabel label_1 = new JLabel();
			label_1.setText(" ");
			panel.add(label_1, BorderLayout.EAST);

			final JPanel todayPanel = new JPanel();
			panel.add(todayPanel, BorderLayout.SOUTH);

			final JLabel label_2 = new JLabel();
			label_2.setText("今天：" + year + "-" + month + "-" + day + "  ");
			todayPanel.add(label_2);

			final JButton button = new JButton();
			button.setText("...");
			button.setMargin(new Insets(0, 12, 0, 12));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calendar today = Calendar.getInstance();
					year = today.get(Calendar.YEAR);
					month = today.get(Calendar.MONTH) + 1;
					day = today.get(Calendar.DAY_OF_MONTH);
					if (year % 4 == 0) {
						if (year % 100 != 0 || year % 400 == 0)
							daysOfMonth[2] = 29;
						else
							daysOfMonth[2] = 28;
					} else {
						daysOfMonth[2] = 28;
					}
					yTextField.setText(year + "");
					mTextField.setText(month + "");
					initTableModel();
				}
			});
			todayPanel.add(button);

		}

		private void initTableModel() {
			DateFormat dateFormat = DateFormat.getDateInstance();
			try {
				dateFormat.parse(year + "-" + month + "-" + 1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar theDay = dateFormat.getCalendar();
			int dayOfWeek = theDay.get(Calendar.DAY_OF_WEEK);
			for (int col = 0; col < dayOfWeek - 1; col++) {
				int days = ((month - 1) < 1 ? 31 : daysOfMonth[month - 1]);
				int day = days - ((dayOfWeek - 1) - 1 - col);
				tableModel.setValueAt("[ " + day + " ]", 0, col);
			}
			int day = 1;
			for (int col = dayOfWeek - 1; col < 7; col++) {
				tableModel.setValueAt(day++, 0, col);
			}
			String s = "";
			String e = "";
			for (int row = 1; row < 6; row++) {
				for (int col = 0; col < 7; col++) {
					if (day > daysOfMonth[month]) {
						s = "[ ";
						e = " ]";
						day = 1;
					}
					tableModel.setValueAt(s + day++ + e, row, col);
				}
			}
		}

		public String getSelectedDate() {
			return year + "-" + month + "-" + day;
		}

	}

	class MTable extends JTable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MTable() {
			super();
		}

		public MTable(DefaultTableModel tableModel) {
			super(tableModel);
		}

		// 表格列名信息
		@Override
		public JTableHeader getTableHeader() {
			// 获得表格头对象
			JTableHeader tableHeader = super.getTableHeader();
			tableHeader.setReorderingAllowed(false);// 设置表格列不可重排
			// 获得表格头的单元格对象
			DefaultTableCellRenderer defaultRenderer = (DefaultTableCellRenderer) tableHeader
					.getDefaultRenderer();
			// 设置单元格内容（即列名）居中显示
			defaultRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return tableHeader;
		}

		// 表格列值居中显示
		@Override
		public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
			// 获得除表格头部分的单元格对象
			DefaultTableCellRenderer defaultRenderer = (DefaultTableCellRenderer) super
					.getDefaultRenderer(columnClass);
			// 设置单元格内容居中显示
			defaultRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
			return defaultRenderer;
		}

		// 表格不可编辑
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		// 用来设置表格的选中行
		@Override
		public void setRowSelectionInterval(int fromRow, int toRow) {// 重构父类的方法
			super.setRowSelectionInterval(fromRow, toRow);
		}

		// 用来设置表格的唯一选中行
		public void setRowSelectionInterval(int row) {// 通过重载实现自己的方法
			setRowSelectionInterval(row, row);
		}

	}

}
