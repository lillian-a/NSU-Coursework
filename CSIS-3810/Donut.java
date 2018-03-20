import java.util.concurrent.*;
import java.util.Random;

public class Donut extends Thread {
	/* Table object */
	public Table table;
	/* Semaphores */
	public static Semaphore homers = new Semaphore(1);
    public static Semaphore tableAccess = new Semaphore(1);
    /* Seed Value */
    public static int seedValue;
    /* array of string names for donut parts */
    public final String[] donutPartNames = {"FILLING", "SHELL", "SPRINKLES"};

    /* Homer Class */
    class Homer extends Thread {
    		// name of Homer instance
    		private String name;
    		// part of the donut this Homer has in infinite quantity
    		private int part;
    		// number of donuts eaten
    		private int donutsEaten;
    		// lets homer know if he should keep going
    		private boolean keepGoing;
    		
    		public Homer(String name, int part) {
    			// name of homer
    			this.name = name;
    			// what part homer has in infinite quantity
    			this.part = part;
    			// number of donuts Homer has eaten - initialized to 0
    			this.donutsEaten = 0;
    			// boolean if homer should keep going
    			this.keepGoing = true;
    		}
    		public void run() {
    			// while homer can keep checking the table
    			while(keepGoing) {
	    			try {
	    				// get access to table
	    				tableAccess.acquire();
	    				// is the donut for this homer
	    				if(table.whatsMissing() == this.part) {
	    					System.out.println("Mine : " + this.name + " is taking items.");
	    					// take the items from the table
	    					table.takeItems();
	    					// release homer sem
	    					homers.release();
	    					// release table sem
	    					tableAccess.release();
	    					// make and eat a donut
	    					this.makeEatDonut();
	    				} else {
	    					// System.out.println(this.name + " : NOT for me.");
	    					System.out.println("Bye   : " + this.name + "  : NOT for me.");
	    					// release table sem
	    					tableAccess.release();
	    					// gives time for other homer's to check
	    					try {
	    						sleep(50);
	    	    				} catch (InterruptedException e) {
	    	    					// print error message if interrupted
	    	    					System.err.println("InterruptedException: " + e.getMessage());
	    	    				}
	    				}
	    				// if the table says no more food tell homer to stop
	    				if (table.done == true){
	    					// set keep going to false to stop checking the table
	    					this.keepGoing = false;
	    					System.out.println("** TOTAL for " + this.name + " : " + this.donutsEaten + " **");
	    				}
	    			} catch (InterruptedException e) {
	    				// print error message if interrupted
	    				System.err.println("InterruptedException: " + e.getMessage());
	    			}
    			}
    		}
    		public void makeEatDonut() {
    			// increment donutsEaten
    			this.donutsEaten++;
    			// print statement with the homer name and what # donut he is eating
    			System.out.println(this.name + " is eating his donut # " + this.donutsEaten);
    			// give homer time to eat
    			try {
    				System.out.println("Yummy : " + this.name + " is eating.");
				sleep(100);
				System.out.println("Burp  : " + this.name + " is done eating.");
    			} catch (InterruptedException e) {
    				// print error message if interrupted
    				System.err.println("InterruptedException: " + e.getMessage());
    			}
    		}
    	
    }
    
    class Chef extends Thread {
    		// bool of if chef should keep adding items
    		private boolean keepGoing;
    		// count of how many times chef has filled the table
    		private int count;
    		// random obj - for use in getting a random number
    		private Random r;
    		// Chef constructor
    		public Chef() {
    			// initialize keepGoing to true
    			this.keepGoing = true;
    			// initialize count to 0
    			this.count = 0;
    			// initialize random obj
    			this.r = new Random();
    		}
    		public void run() {
    			// chef should add items until told to stop by bool var
    			while(this.keepGoing) {
    			    try {
    			    		// tries to acquire homer semaphore
    			    		homers.acquire();
    			    		// tableAccess.acquire();
    			    		// 
    			    		this.placeItems();
    			    		// at this time chef is up
    			    		tableAccess.release();
    			    		// chef is ready to place items
    			    		// chef.release();
    			    		//tableAccess.release();
    			    } catch (InterruptedException e) {
    			    	// print error message if interrupted
    			    		System.err.println("InterruptedException: " + e.getMessage());
    			    }
    			}
    			// set table to done when chef is done
    			if(this.keepGoing == false) {
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
    				System.out.println("DONUT COUNT : " + (this.count+1) + "  of  TOTAL : " + seedValue);
    				// get a random number between 0 and 2 inclusive
    				int rInt = this.r.nextInt(3);
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
    				System.out.println();
    			}
    		}
    }
    /* Table Class */
    class Table {
    		// is table done?
    		protected boolean done;
    		// int array of items on table
    		private int[] onTable;
    		// table constructor
    		public Table() {
    			// initialize onTable int array
    			this.onTable = new int[2];
    			// initialize done to false
    			done = false;
    		}
    		public void addItems(int[] onTable) {
    			this.onTable = onTable;
    		}
    		public void takeItems() {
    			// create temp int array of size 2
    			//	fill with -1
    			int[] temp = new int[] {-1, -1};
    			// set onTable to temp
    			this.onTable = temp;
    		}
    		public int whatsMissing() {
    			// initilize local int variables: sum and num, both to 0
    			int sum = 0, num = 0;
    			// add to sum the value at index 0 of onTable array
    			sum += this.onTable[0];
    			// add to sum the value at index 1 of onTable array
    			sum += this.onTable[1];
    			
    			if (sum == 3) {
    				// if sum = 3 then 0 is the missing item
    				num = 0;
    			} else if (sum == 2) {
    				// if sum = 2 then 0 is the missing item
    				num = 1;
    			} else if (sum == 1){
    				// if sum = 1 then 0 is the missing item
    				num = 2;
    			} else {
    				// else then missing item does not exist
    				num = -1;
    			}
    			// return the missing item
    			return num;
    		}
    }
    
    
    public static void main(String[] args) {
    		// print welcome statement
    		System.out.println("Welcome to the Donut Shop!");
		
    		// check if seedValue passed in via command line, if not set to 20
    		// check if argument exists
		if(args.length > 0) {
			try {
				// parse argument to an int
				seedValue = Integer.parseInt(args[0]);
				// check if positive
				if(seedValue < 0) {
					// if not positive give error and set seedVal to default of 20
					System.out.println("Positive numbers only. Setting seedValue to 20.");
					seedValue = 20;
				}
			} catch(NumberFormatException e) {
				System.out.println("Not a valid number. Setting seedValue to 20.");
			}
			
		} else {
			// set seedVal to default of 20
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
    		// create 3 homers
    	    Homer homerFilling = new Homer("HomerFilling", 0);
    	    Homer homerShell = new Homer("HomerShell", 1);
    	    Homer homerSprinkles = new Homer("HomerSprinkles", 2);
    	    // start the homer objects
    	    chef.start();
    	    homerFilling.start();
    	    homerShell.start();
    	    homerSprinkles.start();
    	    
    	 }

	

}
