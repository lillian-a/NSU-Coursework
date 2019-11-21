import java.util.concurrent.*;
import java.util.Random;

public class Donut extends Thread {
	Table table;
	/* Semaphores */
	public static Semaphore homers = new Semaphore(0);
    public static Semaphore chef = new Semaphore(0);
    public static Semaphore tableAccess = new Semaphore(1);
    /* SEED VALUE */
    public static int seedValue;
    public final String[] donutPartNames = {"FILLING", "SHELL", "SPRINKLES"};
    /* value		donut part
     * 0			FILLING
     * 1			SHELL
     * 2			SPRINKLES
     */

    
    class Homer extends Thread {
    		// name of Homer instance
    		String name;
    		// part of the donut this Homer has in infinite quantity
    		int part;
    		// number of donuts eaten
    		int donutsEaten;
    		// lets homer know if he should keep going
    		boolean keepGoing;
    		
    		public Homer(String name, int part) {
    			this.name = name;
    			this.part = part;
    			this.donutsEaten = 0;
    			this.keepGoing = true;
    		}
    		public void run() {
    			while(keepGoing) {
	    			try {
	    				System.out.println(this.name + " TOTAL : " + this.donutsEaten);
	    				// get access to table
	    				tableAccess.acquire();
	    				// is the donut for this homer
	    				if(table.whatsMissing() == this.part) {
	    					System.out.println(this.name + " is taking items.");
	    					// take the items from the table
	    					table.takeItems();
	    					// release homer sem
	    					homers.release();
	    					// release table sem
	    					tableAccess.release();
	    					// make and eat a donut
	    					this.makeAndEatDonut();
	    				} else {
	    					System.out.println(this.name + " : NOT for me.");
	    					// release table sem
	    					tableAccess.release();
	    					// gives time for other homer's to check
	    					try {
	    	    					sleep(100);
	    	    					System.out.println("zzz " + this.name + " is going to sleep.");
	    	    				} catch (InterruptedException e) {
	    	    					System.err.println("InterruptedException: " + e.getMessage());
	    	    				}
	    				}
	    				// if the table says no more food tell homer to stop
	    				if (table.done == true){
	    					this.keepGoing = false;
	    					System.out.println("TOTAL for " + this.name + " : " + this.donutsEaten);
	    				}
	    			} catch (InterruptedException e) {
	    				System.err.println("InterruptedException: " + e.getMessage());
	    			}
    			}
    		}
    		public void makeAndEatDonut() {
    			this.donutsEaten++;
    			System.out.println(this.name + " is eating his donut # " + this.donutsEaten);
    			try {
    				sleep(100);
    			} catch (InterruptedException e) {
    				System.err.println("InterruptedException: " + e.getMessage());
    			}
    		}
    	
    }
    
    class Chef extends Thread {
    		boolean keepGoing;
    		int count;
    		Random r;
    		// Chef 
    		public Chef() {
    			this.keepGoing = true;
    			this.count = 0;
    			this.r = new Random();
    		}
    		public void run() {
    			while(keepGoing) {  // runs in an infinite loop
    			    try {
    			    		// tries to acquire homer
    			    		homers.acquire();
    			    		this.placeItems();
    			    		// at this time chef is up
    			    		tableAccess.release();
    			    		// chef is ready to place items
    			    		// chef.release();
    			    		//tableAccess.release();
    			    } catch (InterruptedException e) {
    			    		System.err.println("InterruptedException: " + e.getMessage());
    			    }
    			}
    			if(keepGoing == false) {
    				table.done = true;
    			}
    		}
    		/**
    		 * Place Items Function
    		 * function to tell Chef to place random items on the table 
    		 */
    		public void placeItems() {
    			if(this.count < seedValue) {
    				// print Count and SeedValue statement so we know how many donuts were made
    				System.out.println("");
    				System.out.println("COUNT: " + (count+1) + " / SEEDVALUE: " + seedValue);
    				// get a random number between 0 and 2 inclusive
    				int rInt = r.nextInt(3);
    				// create temp int array to hold items
    				int[] temp;
    				
    				if(rInt == 0) {
    					temp = new int[]{1, 2};
    				} else if(rInt == 1) {
    					temp = new int[]{0, 2};
    				} else {
    					temp = new int[]{0, 1};
    				}
    				// print out what chef is placing on the table
    				System.out.println("Chef is placing the items: "
    						+ donutPartNames[temp[0]] + " and "
    						+ donutPartNames[temp[1]]);
    				// add the donut items to the table
    				table.addItems(temp);
    				// increment count
    				this.count++;
    			} else {
    				// set keepGoing flag to false
    				this.keepGoing = false;
    				// print the chef is done statement
    				System.out.println();
    				System.out.println("CHEF IS DONE AND KITCHEN IS CLOSED!");
    			}
    		}
    }
    /* Table Class */
    class Table {
    		// array of items on table
    		boolean done;
    		int[] onTable;
    		public Table() {
    			onTable = new int[2];
    			done = false;
    		}
    		public void addItems(int[] onTable) {
    			this.onTable = onTable;
    		}
    		public void clearTable() {
    			int[] temp = new int[] {-1, -1};
    			this.onTable = temp;
    		}
    		public void takeItems() {
    			clearTable();
    		}
//    		public int whatsMissing() {
//    			int m = -1;
//    			if(((onTable[0] == 0) && (onTable[1] == 1))
//    					|| ((onTable[0] == 1) && (onTable[1] == 0))) {
//    						m = 2;
//    			} else if (((onTable[0] == 0) && (onTable[1] == 2))
//    					|| ((onTable[0] == 2) && (onTable[1] == 0))) {
//    						m = 1;
//    			} else if ((onTable[0] == -1) && (onTable[1] == -1)) {
//					m = -1;
//    			} else {
//    				m = 0;
//    			}
//    			return m;
//    		}
    		public int whatsMissing() {
    			int m = 0, i = 0;
    			m += onTable[0];
    			m += onTable[1];
    			if (m < 0) {
    				i = -1;
    			} else if (m == 3) {
    				i = 0;
    			} else if (m == 2) {
    				i = 1;
    			} else {
    				i = 2;
    			}
    			return i;
    		}
    }
    
    
    public static void main(String[] args) {
    		System.out.println("Welcome to the Donut Shop!");
		// check if seedValue passed in via command line, if not set to 20
		if(args.length > 0) {
			try {
				seedValue = Integer.parseInt(args[0]);
				if(seedValue < 0) {
					System.out.println("Positive numbers only. Setting seedValue to 20.");
					seedValue = 20;
				}
			} catch(NumberFormatException e) {
				System.out.println("Not a valid number. Setting seedValue to 20.");
			}
			
		} else {
			seedValue = 20;
		}
		
		// print out the seed value - for error checking
		// System.out.println("SeedValue: " + seedValue);
		
		// create a donut object and start the simulation
		Donut donutShop = new Donut();
		donutShop.start();
	}
    public void run() {
    		// create table
    		table = new Table();
    		// create Chef
    		Chef chef = new Chef();
    		// start chef
    		chef.start();
    		// create 3 homers
    	    Homer homerFilling = new Homer("HomerFilling", 0);
    	    Homer homerShell = new Homer("HomerShell", 1);
    	    Homer homerSprinkles = new Homer("HomerSprinkles", 2);
    	    // start the homer objects
    	    homerFilling.start();
    	    homerShell.start();
    	    homerSprinkles.start();
    	    
    	 }

	

}
