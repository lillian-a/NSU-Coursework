
public class BufferArrayTest2 {

	public static void main(String[] args) {
		
		BufferArray buf1 = new BufferArray();
		buf1.insert(1);
		buf1.insert(2);
		buf1.insert(3);
		buf1.insert(4);
		buf1.insert(5);
		buf1.insert(6);
		buf1.display();
		if(buf1.locationOf(2) != -1)
			System.out.println("Has Element");
		else
			System.out.println("Doesn't Have Element");
		if(buf1.locationOf(100) != -1)
			System.out.println("Has Element");
		else
			System.out.println("Doesn't Have Element");
		buf1.remove(2);
		buf1.display();
		buf1.stableRemove(3);
		buf1.display();
	}

}
