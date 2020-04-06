/*
 * ���̻߳����µ�����ʽ����
 * �����ڶ��̻߳����£�ĳ������ᱻʵ������Σ������������ĵ���
 * ��Ҫ�����������ʹ��ֻ�ܱ�ʵ����һ��
 */
package Singleton;

public class Singleton {

	public static void main(String[] args) {
		Runnable r = ()->{
			Person.getPerson();
		};
		for(int i=0; i<100; i++) {
			new Thread(r).start();
		}
	}
}

class Person{
	private Person() {
		System.out.println("һ��Person����ʵ������");
	}
	private static Person Instance = null;
	public static synchronized Person getPerson() {
		if(Instance==null) {
			Instance = new Person();
		}
		return Instance;
	}
}