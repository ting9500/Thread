package basic;
public class Thread_1 {

	public static void main(String[] args) {
		/*
		 * �̵߳Ŀ��ٷ�ʽ��
		 * 1.�Զ����߳��ࣨ�ɶ���ǿ�����ǵ��̳У�
		 */
		MyThread mt = new MyThread();
		mt.start();
		System.out.println("�߳�1����֤");
		
		
		/*
		 * 2.ͨ��Runnable�ӿڣ����ã�
		 */
		Runnable r = ()->{
			for(int i=0; i<10; i++) {
				System.out.println("�߳�2�����߼�"+i);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
	
	
}


class MyThread extends Thread{	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println("�߳�1�����߼�"+i);
		}
	}	
}
