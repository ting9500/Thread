package ThreadSource;

import java.util.concurrent.locks.ReentrantLock;

public class SourceClock {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Runnable r = () -> {
			while (TicketCenter.ticketCount > 0) {
				lock.lock();
				if(TicketCenter.ticketCount>0) {					
					System.out.println(Thread.currentThread().getName() + 
							"������Ʊ��ʣ��" + --TicketCenter.ticketCount + "��");
				}
				lock.unlock();
			}
		};
		Thread t1 = new Thread(r, "thread-1");
		Thread t2 = new Thread(r, "thread-2");
		Thread t3 = new Thread(r, "thread-3");
		Thread t4 = new Thread(r, "thread-4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
