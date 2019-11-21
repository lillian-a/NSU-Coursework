import java.util.*;
import java.util.concurrent.Semaphore;

public class Table {
	private Semaphore donutFillingHomer = new Semaphore(0);
	private Semaphore donutShellHomer = new Semaphore(0);
	private Semaphore donutSprinkleHomer = new Semaphore(0);
	
	private LinkedList<Homer> homers;
	private LinkedList<Chef> chefs;
	
	private Table() {
		homers = new LinkedList<Homer>();
		chefs = new LinkedList<Chef>();
	}
	
	public static Table getInstance() {
		return new Table();
	}
	public void addHomer(Homer h) {
		homers.add(h);
	}
	public void addChef(Chef c) {
		chefs.add(c);
	}
}
