/*
 * �̵߳�������ʽ
 */
package basic;
public class Thread_2 {

	public static void main(String[] args) {
		/*
		 * 1.ͨ��setName()ֱ������
		 */
		Thread t = new Thread();
		t.setName("thread1");		
		System.out.println(t.getName());
		
		/*
		 * 2.ͨ�����췽�����߳̽���������Thread(Runnable r, String name)
		 */
		Thread t2 = new Thread(()->{},"Thread2");
		System.out.println(t2.getName());
		
		/*
		 * 3.ʹ���Զ����߳��࣬ʵ������ʱ�������Ƹ�ֵ
		 */
		MyThread2 mt2 = new MyThread2("Thread3");
		System.out.println(mt2.getName());
		
		
	}
}

class MyThread2 extends Thread {
	public MyThread2() {}
	public MyThread2(String name) {
		this.setName(name);
	}	
}

