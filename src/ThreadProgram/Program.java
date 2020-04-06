package ThreadProgram;

public class Program {

	public static void main(String[] args) {
		ProductPool pool = new ProductPool(10);
		new Productor(pool).start();
		new Consumer(pool).start();
		
	}
	
}
