
public class BytePrac {

	public static void main(String[] args) {
		long hexBytes = 0xFF_EC_DE_5E;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
		byte[] anArrayOfBytes;
		
		Byte bObj = new Byte("10");
	    //use byteValue method of Byte class to convert it into byte type.
	    byte b = bObj.byteValue();
	    System.out.println(b);
	   
	    //use shortValue method of Byte class to convert it into short type.
	    short s = bObj.shortValue();
	    System.out.println(s);
	   
	    //use intValue method of Byte class to convert it into int type.
	    int i = bObj.intValue();
	    System.out.println(i);
	   
	    //use floatValue method of Byte class to convert it into float type.
	    float f = bObj.floatValue();
	    System.out.println(f);
	 
	    //use doubleValue method of Byte class to convert it into double type.
	    double d = bObj.doubleValue();
	    System.out.println(d);
	   
	    //use longValue method of Byte class to convert it into long type.
	    long l = bObj.longValue();
	    System.out.println(l);
	    
	    short test1 = 10;
	    int test2 = test1;
	    short test3 = (short) test2;
	    System.out.println("test1: " + test1);
	    System.out.println("test2: " + test2);
	    System.out.println("test3: " + test3);
	    
	    
	    
	}
	
	public static void printBytes(byte[] array, String name) {
	    for (int k = 0; k < array.length; k++) {
	        System.out.println(name + "[" + k + "] = " + "0x" +
	            byteToHex(array[k]));
	    }
	}
	
	static public String byteToHex(byte b) {
	      // Returns hex String representation of byte b
	      char hexDigit[] = {
	         '0', '1', '2', '3', '4', '5', '6', '7',
	         '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	      };
	      char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
	      return new String(array);
	 }
	 
	   static public String charToHex(char c) {
	      // Returns hex String representation of char c
	      byte hi = (byte) (c >>> 8);
	      byte lo = (byte) (c & 0xff);
	      return byteToHex(hi) + byteToHex(lo);
	   }
}
