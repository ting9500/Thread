package Clock;

public class DeadClock {

	public static void main(String[] args) {
		
		Runnable r1 = ()->{
			synchronized ("A") {
				System.out.println("A线程持有了A锁，等待持有B锁");
				synchronized ("B") {
					System.out.println("A线程同时持有A锁和B锁");
				}
			}
		};
		
		Runnable r2 = ()->{
			synchronized ("B") {
				System.out.println("B线程持有了B锁，等待持有A锁");
				synchronized ("A") {
					System.out.println("B线程同时持有A锁和B锁");
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
