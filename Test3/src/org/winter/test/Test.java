package org.winter.test;

//�Լ�дһ���ص�������С���ȥ�ܲ�����С���ڼҰ�æ����������֮���绰֪ͨС��������
//�ص���Javaʵ�֣�
public class Test {
	public static void main(String[] args) {
		Li li=new Li();
		Zhang z=new Zhang(li);
		
		z.askHelp();
	}
}
interface CallBack{
	public void tel(String message);
}
class Zhang implements CallBack{
	private Li li;
	public Zhang(Li li) {
		// TODO Auto-generated constructor stub
		this.li=li;
	}
	public void askHelp(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				li.cook(Zhang.this);
			}}).start();
		paobu();
	}
	public void paobu(){
		for(int i=1;i<=5;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("������"+i*1000+"����");
		}
	}
	@Override
	public void tel(String message) {
		// TODO Auto-generated method stub
		System.out.println("С�Ŵ�绰�����ң�"+message);
	}

	public Li getLi() {
		return li;
	}

	public void setLi(Li li) {
		this.li = li;
	}

}
class Li{
	private String message;
	public void cook(CallBack cb) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(4000);
			System.out.println("�����Ӻ�...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMessage("����������");
		cb.tel(getMessage());
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
