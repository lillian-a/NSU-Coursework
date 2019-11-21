/**
 * 
 * @author Lillian Arguelles
 *
 */

public class Word {
	
	protected int value;
	protected int opcode;
	
	public Word(int n) {
		value = n;
		opcode = 0;
	}
	
	public Word(int op, int n) {
		value = n;
		opcode = op;
	}
	
	public int getValue() 			{	return value;			}
	public int getOpCode() 			{	return opcode;			}
	
	public void setValue(int i) 		{	value = i;				}
	public void setOpCode(int i) 	{	opcode = i;				}
	
	public int add(Word o)			{	return value + o.value;	}
	public int sub(Word o)			{	return value - o.value;	}
	
	public boolean isEqual(int i)	{	return value == i;		}
	public boolean isEqual(Word o)	{	return value == o.value;	}
	
	public String toString() {
		return "[ " + opcode + " " + value + " ]";
		
	}
	
	
	/* public static void main(String[] args) {
			Mem m1 = new Mem(0);
			Mem m2 = new Mem(1);
			Mem m3 = new Mem(5);
			Mem m4 = new Mem(10);
			Mem m5 = new Mem(100);
			System.out.println("Mem1 : " +m1.value);
			System.out.println("Mem2 : " +m2.value);
			System.out.println("Mem3 : " +m3.value);
			System.out.println("Mem4 : " +m4.value);
			System.out.println("Mem5 : " +m5.value);
			System.out.println("Mem1 + Mem2: " +m1.add(m2));
			System.out.println("Mem2 + Mem3: " +m2.add(m3));
			System.out.println("Mem5 - Mem4: " +m5.sub(m4));
			String s1 = "ADD10";
			Mem m6;
			s1.toUpperCase().trim();
			if(s1.startsWith("ADD")) {
				m6 = new Mem(10, Integer.parseInt(s1.substring(3).trim()));
			} else {
				m6 = new Mem(0,0);
			}
			System.out.println("Mem6 : " +m6.value + " " + m6.opcode);
		}
	 */

}


