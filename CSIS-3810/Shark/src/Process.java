
public class Process implements Comparable{
	private int process_num;
	protected int priority_level;
	// public int arival_time;
	public int burst_time;
	
	public Process(int id, int pri, int a, int b) {
		process_num = id;
		priority_level = pri;
		// arival_time = a;
		burst_time = b;
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Object o) {
		Process p = (Process) o;
		// same
		if(this.priority_level == p.priority_level)
			return 0;
		// o has higher priority
		else if(this.priority_level < p.priority_level)
			return -1;
		// o has lower priority
		else
			return 1;
	}
}

