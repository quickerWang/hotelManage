/**
 * @author 孙思佳
 * 20180714
 * 房间功能背景图片
 */
package hotel;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class livingPanel extends JPanel {// 登录面板

	public int width, height;// 面板的宽高
	private Image ima;// 登录面板的背景图片

	public livingPanel() {// 登录面板的构造方法
		super();// 调用父类JPanel的构造器
		ImageIcon icon=new ImageIcon("image/3-1.png");  //设置背景
  	    ima=icon.getImage();
	}
 
	protected void paintComponent(Graphics g) {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(ima, 0, 0, this);// 绘制图片
	}

}