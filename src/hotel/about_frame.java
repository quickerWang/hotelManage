/**
 * @author ������
 * 20180713
 * ���幦��:�������ǽ���
 */

package hotel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class about_frame extends JFrame{        //��ʾ���汳��
   public about_frame() {
	   setSize(360,280);         //���ý����С
	   JLabel label=new JLabel();           //Label������ͼƬ
	   label.setIcon(new ImageIcon("image/about us.png"));      //Ϊlabel����ͼƬ
	   setLocationRelativeTo(null);        //�������
	   getContentPane().add(label);       //label���뵽�����
   }
}
