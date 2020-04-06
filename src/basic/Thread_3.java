package basic;
public class Thread_3 {

	public static void main(String[] args) {
//		ThreadSleep();		//�߳�����
//		ThreadPriority();	//�߳����ȼ�
		ThreadYield();		//�߳�����
	}
	
	/*
	 * �߳�����
	 * sleep():��λ��ms��������쳣�����׳�����Ҫ������̬������̬������̬֮���״̬ת��
	 */
	public static void ThreadSleep() {
		MyThread3 mt3 = new MyThread3();
		mt3.start();
	}
	
	
	/*
	 * �߳����ȼ�
	 * ֻ���޸ĸ��߳�����CPUʱ��Ƭ�ĸ��ʣ�����һ����������Դ
	 */
	public static void ThreadPriority() {
		Runnable r = ()->{
			for(int i=0; i<100; i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		};
		Thread t1 = new Thread(r,"Thread-1");
		Thread t2 = new Thread(r,"Thread-2");
		
		t1.setPriority(6);
		t2.setPriority(5);
		t1.start();
		t2.start();
	}

	
	/*
	 * �߳�����
	 * �õ�ǰ���е��߳��ͷ��Լ���CPU��Դ��������״̬���ص�����״̬�����º������̹߳�ͬ��ռ��Դ
	 */
	public static void ThreadYield() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getName()+":"+i);
					if(i==5) {
						Thread.yield();
					}
				}
			}
		};
		
		Thread t1 = new Thread(r, "thread-1");
		Thread t2 = new Thread(r, "thread-2");
		t1.start();
		t2.start();
	}


}

class MyThread3 extends Thread{
	public MyThread3() {}
	public MyThread3(String name) {
		this.setName(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


