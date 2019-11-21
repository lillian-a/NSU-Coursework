
public class PCB {

	// Process Control Block
	int id;
	String status;
	int[] registers;
	int priority_level;
	int CPU_Time;
	int Total_Time;
	Job j;
	
	public PCB(Job j) {
		registers = new int[8];
		this.j = j;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int[] getRegisters() {
		return registers;
	}

	public void setRegisters(int[] registers) {
		this.registers = registers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority_level() {
		return priority_level;
	}

	public void setPriority_level(int priority_level) {
		this.priority_level = priority_level;
	}

	public int getCPU_Time() {
		return CPU_Time;
	}

	public void setCPU_Time(int cPU_Time) {
		CPU_Time = cPU_Time;
	}

	public int getTotal_Time() {
		return Total_Time;
	}

	public void setTotal_Time(int total_Time) {
		Total_Time = total_Time;
	}
	
	
}
