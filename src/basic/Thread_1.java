package basic;
public class Thread_1 {

	public static void main(String[] args) {
		/*
		 * 线程的开辟方式：
		 * 1.自定义线程类（可读性强、但是单继承）
		 */
		MyThread mt = new MyThread();
		mt.start();
		System.out.println("线程1的验证");
		
		
		/*
		 * 2.通过Runnable接口（常用）
		 */
		Runnable r = ()->{
			for(int i=0; i<10; i++) {
				System.out.println("线程2开启逻辑"+i);
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
			System.out.println("线程1开启逻辑"+i);
		}
	}	
}
