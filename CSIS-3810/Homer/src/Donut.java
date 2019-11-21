import java.util.Random;
import java.util.concurrent.Semaphore;
// https://www.reddit.com/r/java/comments/mkvnw/little_help_with_a_homework_project/
public class Donut {
	int lock = 1;
	int homer_shell = 0;
	int homer_filling = 0;
	int homer_sprinkles = 0;
	private Semaphore table;
	private Semaphore chef;

	public synchronized void DonutTable() {
		
		int count = 2;
		
		while(count > 2) {
			Random r = new Random();
			r.nextInt(2);
			if(r.nextInt() == 1) {
				try {
					chef.acquire();
					System.out.println("Lock acquired. Notifying Homer with the shell");
					chef.notify();
					System.out.println("Notified the Homer with the shell");
					chef.release();
					System.out.println("Released the lock");
				} catch (InterruptedException e) {}
			} else if(r.nextInt() == 2) {
				try {
					chef.acquire();
					System.out.println("Lock acquired. Notifying Homer with the sprinkles");
					chef.notify();
					System.out.println("Notified the Homer with the sprinkles");
					chef.release();
					System.out.println("Released the lock");
				} catch (InterruptedException e) {}  
	        } else {
	        		try {
	        			chef.acquire();
	        			System.out.println("Lock acquired. Notifying Homer with the filling");
	        			chef.notify();
	        			System.out.println("Notified the Homer with the filling");
	        			chef.release();
	        			System.out.println("Released the lock");
	        		} catch (InterruptedException e) {}
	        }
			try {
	        		chef.notify();    
	        		table.wait();  
	        } catch (InterruptedException e) {}  
		}
	}
	public synchronized void homer_shell() {  
	    try {   
	    wait();  
	    table.wait();  
	    chef.notify();  
	    table.notify();  
	    } catch (InterruptedException e) { }  
	}   

	public synchronized void homer_sprinkles() {
		try {
			wait();
			table.wait();
			chef.notify();
			table.notify();
		} catch (InterruptedException e) { }
	}
	
	public synchronized void homer_filling() {  
		try {
			wait();
			table.wait();
			chef.notify();
			table.notify();
		} catch (InterruptedException e) {}
	}  
}
