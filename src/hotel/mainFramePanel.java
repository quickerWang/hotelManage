/**
 * @author ������
 *20180715
 *�����汳�� 
 */

package hotel;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

import java.awt.Dimension;

public class mainFramePanel extends JPanel {// ��¼���

	public int width, height;// ���Ŀ��
	private Image imag;// ��¼���ı���ͼƬ
/**
 * @author ������
 * 20180715
 * ����ͼƬʵ��
 */
	public mainFramePanel() {// ��¼���Ĺ��췽��
		super();// ���ø���JPanel�Ĺ�����
		ImageIcon icon=new ImageIcon("image/2-0.png");  //���ñ���
  	    imag=icon.getImage();
	}
	/**
	 * @author ������
	 * 20180715
	 * ����ͼƬ����
	 */
	protected void paintComponent(Graphics g) {// ��д�����������
		super.paintComponent(g);// �������
		g.drawImage(imag, 0, 0, this);// ����ͼƬ
	}

}