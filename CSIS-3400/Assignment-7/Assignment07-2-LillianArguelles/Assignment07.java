public class Assignment07 {
	public static void main(String  args[]) {
		IterableLinkedList list =  new IterableLinkedList();
		list.insertHead("Erich Gamma");
		list.insertHead("Richard Helm");
		list.insertHead("Ralph Johnson");
		list.insertHead("John Vlissides");
		GofIterator giter = list.createGofIterator();
		for(giter.first(); !giter.isDone(); giter.next())
			System.out.println(giter.currentItem());
		// robustness check
		System.out.println(giter.currentItem());
		JavaIterator jiter = list.createJavaIterator();
		while(jiter.hasNext())
			System.out.println(jiter.next());
		// robustness check
		System.out.println(jiter.next());
	}
}