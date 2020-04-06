package ThreadSource;

public class SourceMethod {

	public static void main(String[] args) {
		Runnable r = ()->{
			while(TicketCenter.ticketCount>0) {
				sellTicket();
			}
		};
		Thread t1 = new Thread(r, "thread-1");
		Thread t2 = new Thread(r, "thread-2");
		Thread t3 = new Thread(r, "thread-3");
		Thread t4 = new Thread(r, "thread-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	public static synchronized void sellTicket() {
		synchronized (SourceCode.class) {
			if(TicketCenter.ticketCount>0) {						
				System.out.println(Thread.currentThread().getName()+
						"Âô³öÁËÆ±£¬Ê£Óà"+--TicketCenter.ticketCount+"ÕÅ");					
			}
		}
	}
}
