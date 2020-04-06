package ThreadProgram;

import java.util.LinkedList;
import java.util.List;

public class ProductPool {

	private List<Product> list;
	private int maxSize = 0;
	public ProductPool(int maxSize) {
		this.list = new LinkedList<Product>();
		this.maxSize = maxSize;
	}
	
	/*
	 * 生产者
	 */
	public synchronized void push(Product product) {
		if(this.list.size()==maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.list.add(product);
		this.notifyAll();
	}
	
	/*
	 * 消费者
	 */
	public synchronized Product pop() {
		if(this.list.size()==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Product product = this.list.remove(0);
		this.notifyAll();
		return product;
	}
	
	
	
	
}
