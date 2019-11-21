
public class Main {

	public static void main(String[] args) {
		// create Homer objects
		Homer homer1 = Homer.getInstance("Homer 1");
		Homer homer2 = Homer.getInstance("Homer 2");
		Homer homer3 = Homer.getInstance("Homer 3");
		// create Chef object
		Chef chef = Chef.getInstance();
		// create Table object
		Table table = Table.getInstance();
		// add Homer and Cheg objects to the Table object
		table.addHomer(homer1);
		table.addHomer(homer2);
		table.addHomer(homer3);
		table.addChef(chef);
		
		// create threads
		Thread homerThread1 = new Thread(homer1);
		Thread homerThread2 = new Thread(homer2);
		Thread homerThread3 = new Thread(homer3);
		Thread chefThread = new Thread(chef);

	}

}
