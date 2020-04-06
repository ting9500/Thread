package ThreadProgram;

public class Productor extends Thread{

	private ProductPool productPool;

	public Productor(ProductPool productPool) {
		this.productPool = productPool;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			String name = (int)(Math.random()*100) + "�Ų�Ʒ";
			Product product = new Product(name);
			System.out.println("������һ����Ʒ"+name);
			this.productPool.push(product);
		}
	}
	
	
	
	
}
