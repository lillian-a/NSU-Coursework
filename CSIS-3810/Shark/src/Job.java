
public class Job {
	protected int id;
	protected int start;
	protected int end;
	protected String status;
	// size?
	
	public Job (int i, int s) {
		id = i;
		start = s;
		status = "PENDING";
	}
	public void update(int e) {
		end = e;
	}
	public void setStatus(String s) {
		status = s;
	}
}
