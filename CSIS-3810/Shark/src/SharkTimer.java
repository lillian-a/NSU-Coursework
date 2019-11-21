
public class SharkTimer {
	private int time;
	
	public SharkTimer() {
		time = 0;
	}
	public SharkTimer(int t) {
		time = t;
	}
	public void addTime(int t) {
		time += t;
	}
	public int getTime() {
		return time;
	}
}
