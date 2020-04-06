package basic;
public class Thread_3 {

	public static void main(String[] args) {
//		ThreadSleep();		//线程休眠
//		ThreadPriority();	//线程优先级
		ThreadYield();		//线程礼让
	}
	
	/*
	 * 线程休眠
	 * sleep():单位是ms，会产生异常，需抛出，主要是运行态、阻塞态、就绪态之间的状态转换
	 */
	public static void ThreadSleep() {
		MyThread3 mt3 = new MyThread3();
		mt3.start();
	}
	
	
	/*
	 * 线程优先级
	 * 只是修改该线程抢到CPU时间片的概率，并不一定能抢到资源
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
	 * 线程礼让
	 * 让当前运行的线程释放自己的CPU资源，由运行状态，回到就绪状态，重新和其他线程共同抢占资源
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


