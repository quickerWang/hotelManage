/**
 * ������
 * @author ������
 * 2018-07-13
 */
package hotel.entity;

	public class list {
		private int listno;//�������
		private String id;//���֤��
		private int no;//�����
		private String start;//����ʱ��
		private int days;//��������
		private boolean isEnded;//�����Ƿ���� 0��δ��� 1�����
		private int money;
		
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			this.money = money;
		}
		public int getListno() {
			return listno;
		}
		public void setListno(int listno) {
			this.listno = listno;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getStart() {
			return start;
		}
		public void setStart(String start) {
			this.start = start;
		}
		public int getDays() {
			return days;
		}
		public void setDays(int days) {
			this.days = days;
		}
		public boolean isEnded() {
			return isEnded;
		}
		public void setEnded(boolean isEnded) {
			this.isEnded = isEnded;
		}
	     

	}


