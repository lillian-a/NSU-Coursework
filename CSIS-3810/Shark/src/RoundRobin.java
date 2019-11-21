// Java program for implementation of RR scheduling

public class RoundRobin {

	/**
	 * Method finds wait time for all processes
	 * @param processes	
	 * @param n			number of processes
	 * @param bt			burst times
	 * @param wt			waiting times
	 * @param q			quantum
	 */
	static void findWaitingTime(int processes[], int n, int bt[], int wt[], int q) {
		// Make copy of bt[] to store remaining burst times
		int rem_bt[] = new int[n];
		for (int i = 0 ; i < n ; i++)
			rem_bt[i] =  bt[i];
		
		// Current time
		int t = 0;
		// Keep traversing processes in round robin manner
		// until all of them are not done.
		while(true) {
			boolean done = true;
			// Traverse all processes one by one repeatedly
			for (int i = 0 ; i < n; i++) {
				// If bt of a process is greater than 0
				// then only need to process further
				if (rem_bt[i] > 0) {
					// There is a pending process
					done = false;

					if (rem_bt[i] > q) {
						// Increase t - shows how much time process has been processed
						t += q;
						// Decrease bt of current process by q
						rem_bt[i] -= q;
					}
					// If bt is smaller than or equal to q - Last cycle for process
					else {
						// Increase t - shows how much time process has been processed
						t = t + rem_bt[i];
						// Waiting time is current time minus time used by this process
						wt[i] = t - bt[i];
						// As process gets fully executed make its remaining burst time = 0
						rem_bt[i] = 0;
					}
				}
			}

			// If all processes done
			if (done == true)
				break;
		}
	}

	/**
	 * Method to calculate turn around time 
	 * @param processes
	 * @param n			number of processes
	 * @param bt			burst times
	 * @param wt			waiting times
	 * @param tat		turnaround time
	 */
	static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
		// calculating turnaround time by adding bt[i] + wt[i]
		for (int i = 0; i < n ; i++)
			tat[i] = bt[i] + wt[i];
	}

	/**
	 * Method to calculate average time 
	 * @param processes
	 * @param n			number of processes
	 * @param bt			burst times
	 * @param q			quantum
	 */
	static void findavgTime(int processes[], int n, int bt[], int q) {
		int wt[] = new int[n], tat[] = new int[n];
		int total_wt = 0, total_tat = 0;

		// Function finds waiting time of all processes
		findWaitingTime(processes, n, bt, wt, q);

		// Function finds turn around time for all processes
		findTurnAroundTime(processes, n, bt, wt, tat);

		// Display processes along with all details
		System.out.println("Processes " + " Burst time " +
				" Waiting time " + " Turn around time");

		// Calc total waiting time and total turn around time
		for (int i=0; i<n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " +
					wt[i] +"\t\t " + tat[i]);
		}

		System.out.println("Avg waiting time = " + (float)total_wt / (float)n);
		System.out.println("Avg turn around time = " + (float)total_tat / (float)n);
	}

	// Driver Method
	public static void main(String[] args) {
		// process id's
		int processes[] = { 1, 2, 3};
		int n = processes.length;

		// Burst time of all processes
		int burst_time[] = {10, 5, 8};

		// Time q
		int q = 2;
		findavgTime(processes, n, burst_time, q);
	}
}