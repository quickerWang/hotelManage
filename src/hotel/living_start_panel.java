package hotel;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;
/**
 *
 * @author ��˼��
 *  ���书�ܵı���ͼƬ���
 *   20180714
 */
public class living_start_panel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image imag;// ��¼���ı���ͼƬ
	/**
	 *
	 * @author ��˼��
	 * �����ʼ������������
	 *   20180714
	 */
	public living_start_panel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/2-0.png");  //���ñ���
  	    imag=icon.getImage();
	}
	/**
	 *
	 * @author ��˼��
	 *  ���汳���Ļ���
	 *   20180714
	 */
	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(imag, 0, 0, this);// ����ͼƬ
	}

}