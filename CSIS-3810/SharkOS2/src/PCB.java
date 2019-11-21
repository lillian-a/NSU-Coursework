/**
 * Process Control Block Data Structure
 * 
 * @author Lillian Arguelles
 */
public class PCB {
	// Job Object - one each per PCB
	public Job job;
	// ID of PCB
	int id;
	// PCB Status
	String status;
	// register storage
	int[] registers;
	// priority level
	int priority_level;
	// finished flag
	boolean finished;
	// cpu storage
	SharkCPU cpu;
	
	/**
	 * Constructor - if creating a PCB with passing in a job
	 * @param job				PCB job object
	 * @param id					PCB id
	 * @param priority_level		PCB priority level (0 - 2)
	 * @param cpu				PCB private CPU object
	 */
	public PCB(Job job, int id, int priority_level, SharkCPU cpu) {
		// assign passed in variables
		this.job = job;
		this.id = id;
		this.priority_level = priority_level;
		this.cpu = cpu;
		// initialize the registers array
		registers = new int[8];
		// initially set finished to false
		finished = false;
	}
	/**
	 * Update the stored CPU object
	 * @param cpu
	 */
	public void updateCPU(SharkCPU cpu) {
		this.cpu = cpu;
	}
	/**
	 * Get the id of the PCB
	 * @return	id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set the id of the PCB
	 * @param id		int to set id to
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get the priority_level of the PCB
	 * @return	priority_level
	 */
	public int getPriorityLevel() {
		return priority_level;
	}
	/**
	 * Set the priority_level of the PCB
	 * @param priority_level		int to set priority_level to
	 */
	public void setPriorityLevel(int priority_level) {
		this.priority_level = priority_level;
	}
	/**
	 * Get register array
	 * @return int array of registers
	 */
	public int[] getRegisters() {
		return registers;
	}
	/**
	 * Set register array
	 * @param registers array
	 */
	public void setRegisters(int[] registers) {
		this.registers = registers;
	}
	/**
	 * check if PCB is finished being processed
	 * @return boolean finished
	 */
	public boolean isFinished() {
		return finished;
	}
	/**
	 * set PCB to finished
	 * @param boolean to set finished
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public String toString() {
		String s = "";
		s += "PCB ID # : " + id + "\n";
		s += "Priority : " + priority_level + "\n";
		s += "Finished : " + finished + "\n";
		s += job.toString();
		return s;
	}
	
	
	
}
