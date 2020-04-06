package Clock;

public class DeadClock {

	public static void main(String[] args) {
		
		Runnable r1 = ()->{
			synchronized ("A") {
				System.out.println("A�̳߳�����A�����ȴ�����B��");
				synchronized ("B") {
					System.out.println("A�߳�ͬʱ����A����B��");
				}
			}
		};
		
		Runnable r2 = ()->{
			synchronized ("B") {
				System.out.println("B�̳߳�����B�����ȴ�����A��");
				synchronized ("A") {
					System.out.println("B�߳�ͬʱ����A����B��");
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
