
public class SharkOS {
	
	private static final int NUMBER_OF_JOBS = 3;
	private static final int MEMORY_SIZE = 1024;
	private static final int MEMORY_JOB_START = 320;
	
	private CPU cpu;
	private ALU alu;
	
	public static void main(String[] args) {
		SharkMain m = new SharkMain();
		m.startUp(MEMORY_SIZE, NUMBER_OF_JOBS, MEMORY_JOB_START);
	}
	
	public void SharkOS(CPU cpu, ALU alu) {
		this.cpu = cpu;
		this.alu = alu;
		
	}


}
