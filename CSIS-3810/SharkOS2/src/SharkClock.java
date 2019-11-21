
public class SharkClock {
	// current cpu time
	private long time;
	/**
	 * Clock Constructor
	 * initializes time to 0
	 */
	public SharkClock() {
		time = 0;
	}
	/**
	 * Increments time by a passed in amount 
	 * @param t		amount to increment time by
	 */
	public void addTime(long t) {
		time += t;
	}
	/**
	 * increment timer by 1 tick
	 */
	public void incTime() {
		time++;
	}
	/**
	 * Get time
	 * @return time amount
	 */
	public long getTime() {
		return time;
	}
}
