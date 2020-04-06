package ThreadProgram;

public class Consumer extends Thread{
	
	private ProductPool productPool;

	public Consumer(ProductPool productPool) {
		this.productPool = productPool;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {			
			Product product = this.productPool.pop();
			System.out.println("消费者消费了一件产品：" + product.getName());
		}
	}
	
}

