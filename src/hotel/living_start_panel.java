package hotel;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;
/**
 *
 * @author 孙思佳
 *  房间功能的背景图片面板
 *   20180714
 */
public class living_start_panel extends JPanel {// 登录面板

	public int width, height;// 面板的宽高
	private Image imag;// 登录面板的背景图片
	/**
	 *
	 * @author 孙思佳
	 * 界面初始化，背景绘制
	 *   20180714
	 */
	public living_start_panel() {// 登录面板的构造方法
		super();// 调用父类JPanel的构造器
		ImageIcon icon=new ImageIcon("image/2-0.png");  //设置背景
  	    imag=icon.getImage();
	}
	/**
	 *
	 * @author 孙思佳
	 *  界面背景的绘制
	 *   20180714
	 */
	protected void paintComponent(Graphics g) {// 重写绘制组件方法
		super.paintComponent(g);// 绘制组件
		g.drawImage(imag, 0, 0, this);// 绘制图片
	}

}