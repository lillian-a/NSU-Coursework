
public class Memory {
	private short size;
	short[][] m;
	
	public Memory(short size) {
		m = new short[size][size];
		this.size = size;
	}
	
	public void init() {
		for(int i = 0; i < size; i++) {
			m[i][0] = 0;
			m[0][i] = 0;
		}
	}
	
	public short[] memRead(int i) {
		short[] temp = new short[2];
		temp[0] = m[i][0];
		temp[1] = m[0][i];
		return temp;
	}
	
	public void memWrite(int i, short[] temp) {
		m[i][0] = temp[0];
		m[0][i] = temp[1];
	}
	
	public short getOpcode(int i) {
		return m[i][0];
	}
	public short getOperand(int i) {
		return m[0][i];
	}
	

}
