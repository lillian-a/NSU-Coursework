import java.nio.ByteBuffer;

public class Register {

	private int size;
	private byte[] data;
	
	public Register(int s) {
		size = s;
		data = new byte[s];
	}
	
	public int size() {
		return size;
	}
	
	public byte[] readData() {
		return data;
	}
	
	public int readDataInt() {
		// ByteBuffer b = ByteBuffer.allocate(4).put(data);
		// return b.getInt(0);
        return ByteBuffer.allocate(4).put(data).getInt(0);
    }
	
	public void writeData(byte[] b) {
		if(b.length == size) {
			data = b;
		}
	}
	
	public void writeData(int b) {
		if(!(size < 4))
			data = ByteBuffer.allocate(size).putInt(b).array();
	}
}
