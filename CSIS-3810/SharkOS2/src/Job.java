/**
 * Job Data Structure
 * @author Lillian Arguelles
 */
public class Job {
	// id of Job
	protected int id;
	// start location of Job
	protected int start;
	// end location of Job
	protected int end;
	// priority level of Job (0 - 2)
	protected int priority_level;
	// CPU time left to run
	protected long cpuTime;
	// size of Job
	protected long size;
	
	/**
	 * Job Object Constructor
	 * @param id					job id
	 * @param start				start location of job in memory
	 * @param priority_level		priority_level of job (0-2)
	 */
	public Job (int id, int start, int priority_level) {
		this.id = id;
		this.start = start;
		this.priority_level = priority_level;
		cpuTime = 0;
	}
	/**
	 * Update where in memory job ends
	 * @param end	update the end (for use in calculating size)
	 */
	public void update(int end) {
		// set end
		this.end = end;
		// set size based on end and start
		size = end - start;
	}
	/**
	 * print job string
	 * @return String of job status
	 */
	public String toString() {
		String s = "";
		s += "Job ID Num: " + id + "\n";
		s += "Job Priority: " + priority_level + "\n";
		s += "Job Location: " + start + "\n";
		s += "Job InstrSize: " + size + "\n";
		s += "Job Instr Run: " + cpuTime + "\n";
		s += "Job TimeLeft: " + getTimeLeft() + "\n";
		return s;
		
	}
	public void addToCPUTime(long l) {
		cpuTime += l;
	}
	/**
	 * returns cpu run time of Job
	 * @return
	 */
	public long getCPUTime() {
		return cpuTime;
	}
	/**
	 * returns size of the Job
	 * @return
	 */
	public long getSize() {
		return size;
	}
	/**
	 * Returns time left to process a Job
	 * @return long amt of time left to process
	 */
	public long getTimeLeft() {
		// time left is size - cpu time (already run)
		long l = size - cpuTime;
		// return time left
		//    if time < 0, return 0
		return (l < 0) ? 0 : l;
	}
}
