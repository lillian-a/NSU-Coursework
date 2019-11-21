import java.util.*;

public class Chef implements Runnable {
	/**
	 * Constructor without any Parameter
	 */
	private Chef() {
		
	}
	
	/**
	 * Get an instance of Chef object / semaphore
	 * @return Chef 		instance of Chef
	 */
	public static Chef getInstance() {
		return new Chef();
	}
	/**
	 * Run Chef semaphore
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void notifyChef() {
		
	}

}
