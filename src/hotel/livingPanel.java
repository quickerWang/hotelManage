/**
 * @author ��˼��
 * 20180714
 * ���书�ܱ���ͼƬ
 */
package hotel;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class livingPanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image ima;// ��¼���ı���ͼƬ

	public livingPanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/3-1.png");  //���ñ���
  	    ima=icon.getImage();
	}
 
	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(ima, 0, 0, this);// ����ͼƬ
	}

}