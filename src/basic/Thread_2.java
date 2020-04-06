/*
 * 线程的命名方式
 */
package basic;
public class Thread_2 {

	public static void main(String[] args) {
		/*
		 * 1.通过setName()直接命名
		 */
		Thread t = new Thread();
		t.setName("thread1");		
		System.out.println(t.getName());
		
		/*
		 * 2.通过构造方法对线程进行命名，Thread(Runnable r, String name)
		 */
		Thread t2 = new Thread(()->{},"Thread2");
		System.out.println(t2.getName());
		
		/*
		 * 3.使用自定义线程类，实例对象时进行名称赋值
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

