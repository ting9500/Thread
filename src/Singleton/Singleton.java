/*
 * 多线程环境下的懒汉式单例
 * 当处于多线程环境下，某个对象会被实例化多次，并不是真正的单例
 * 需要给对象加锁，使其只能被实例化一次
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
		System.out.println("一个Person对象被实例化了");
	}
	private static Person Instance = null;
	public static synchronized Person getPerson() {
		if(Instance==null) {
			Instance = new Person();
		}
		return Instance;
	}
}