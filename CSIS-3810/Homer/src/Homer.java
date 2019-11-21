import java.util.*;

public class Homer implements Runnable{
	// Homer's name
	String name;
	/**
	 * Constructor without any Parameter
	 */
	private Homer() {
		
	}
	/**
	 * Constructor with String Parameter
	 * @param name	string to set name to
	 */
	private Homer(String name) {
		this.name = name;
	}
	/**
	 * Get an instance of Homer object / semaphore
	 * @return Homer 	instance of homer
	 */
	public static Homer getInstance(String name) {
		return new Homer(name);
	}
	/**
	 * Run Homer semaphore
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void makeDonut() {
		
	}
	public void eatDonut() {
		
	}

}
