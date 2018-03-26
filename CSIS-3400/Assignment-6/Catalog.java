import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Catalog {
	public static void main(String[] args) {
		// List<Item> list = new ArrayList<Item>();
		List<Item> list = new LinkedList<Item>();
		list.add(new Item("Budget Garden Hose", 3.99, 2.2));
		list.add(new Item("Deluxe Garden Hose", 27.45, 4.8));
		list.add(new Item("Pink Girl Power Garden Hose", 12.83, 5.0));
		list.add(new Item("Combat Camo Garden Hose", 77.18, 3.0));
		list.add(new Item("Green Eco Friendly Garden Hose", 18.75, 4.1));
		list.add(new Item("Civil War Commemorative Garden Hose", 18.61, 2.7));
		list.add(new Item("Lederhose Fine Leather Garden Hose", 90.00, 3.6));
		list.add(new Item("QuelquesHose Garden Hose for Connoisseurs", 49.50, 4.8));
		list.add(new Item("NASA Mars Ready Garden Hose", 5327.16, 1.3));
		list.add(new Item("Collapsible Pocket Garden Hose", 8.99, 2.7));
		list.add(new Item("Lifetime Guaranteed Garden Hose", 35.50, 4.8));
		list.add(new Item("Armor Plated Mower-Proof Garden Hose", 58.88, 4.6));
		list.add(new Item("Barbie's Dollhouse Garden Hose", 4.78, 4.2));
		
		// print list as added
		System.out.println("\n*** List in order as inserted ***");
		for (Item it: list)
			System.out.println(it);
		
		// sort by compareTo and use for-each loop
		System.out.println("\n*** List sorted by description ***");
		//	*** WRITE THE LINE TO SORT list THAT WILL USE Items’s compareTo METHOD ***
		Collections.sort(list);
		for (Item itm: list)
			System.out.println(itm);
		
		// sort by price comparator and use Iterator
		System.out.println("\n*** List sorted by Price (shown low to high) ***");
		Collections.sort(list, Item.getPriceComparator());
		Iterator<Item> iter = list.iterator();
		// *** WRITE THE WHILE LOOP USING iter TO PRINT EACH ITEM IN THE LIST ***
		while(iter.hasNext())
			System.out.println(iter.next());
		
		// sort by review comparator and use ListIterator in reverse
		System.out.println("\n*** List sorted by Reviews (shown high to low) ***");
		// *** WRITE THE LINE TO SORT list USING THE REVIEW COMPARATOR ***
		Collections.sort(list, Item.getReviewComparator());
		// *** WRITE THE LINE TO DECLARE AND INITIALIZE listiter TO START AT THE END ***
		ListIterator<Item> listiter = list.listIterator(list.size());
		while(listiter.hasPrevious())
			System.out.println(listiter.previous());
	}
}
