package hotel.service;
/**
 * �̳�Check_list,Check_consumer�ӿ�
 * @author ����ͩ
 * 20180715
 * ����ʱ����
 */
public interface Check extends Check_list,Check_Consumer{
	public int checkroom(String []param);      //����ʱ����room������
}
