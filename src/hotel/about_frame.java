/**
 * @author 王文萱
 * 20180713
 * 具体功能:关于我们界面
 */

package hotel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class about_frame extends JFrame{        //显示界面背景
   public about_frame() {
	   setSize(360,280);         //设置界面大小
	   JLabel label=new JLabel();           //Label用来放图片
	   label.setIcon(new ImageIcon("image/about us.png"));      //为label设置图片
	   setLocationRelativeTo(null);        //界面居中
	   getContentPane().add(label);       //label加入到面板中
   }
}
