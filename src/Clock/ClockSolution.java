/*
 * ����������⣺
 * wait���ȴ�����Object���е�һ����������ǰ���߳��ͷ��Լ������������ó�CPU��Դ��ʹ�õ�ǰ���߳̽���ȴ�������
 * notify��֪ͨ����Object���е�һ�����������ѵȴ������е�һ���̣߳�ʹ����߳̽�������
 * notifyAll��֪ͨ����Object���е�һ�����������ѵȴ������е������̣߳�ʹ��Щ�߳�ȫ����������
 */
package Clock;

public class ClockSolution {

	public static void main(String[] args) {
		Runnable r1 = ()->{
			synchronized ("A") {
				System.out.println("A�̳߳�����A�����ȴ�����B��");
				try {
					"A".wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
					"A".notifyAll();
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
