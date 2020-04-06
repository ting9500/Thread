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
			System.out.println("������������һ����Ʒ��" + product.getName());
		}
	}
	
}

