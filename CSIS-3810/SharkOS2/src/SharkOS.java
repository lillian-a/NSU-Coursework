import java.io.*;
import java.util.*;

public class SharkOS {
	// Job Queue of PCB's = using LinkedList Structure
	public LinkedList<PCB> jobQ;
	// Memory
	public SharkMemory sharkMemory;
	public SharkCPU cpu;
	public String[] files;
	private final int NUMBER_OF_JOBS = 6;
	private final int MEMORY_SIZE = 1024;
	private final int MEMORY_JOB_START = 400;
	public int jobStart;
	
	public SharkOS() {
		// initialize files array
		files = new String[NUMBER_OF_JOBS];
		// pass in fileNames of programs to files array
		files[0] = "Program1A.txt";
		files[1] = "Program2.txt";
		files[2] = "Program3.txt";
		files[3] = "Program1A.txt";
		files[4] = "Program2.txt";
		files[5] = "Program3.txt";
		bootUp();
	}
	public void main() {
		// initialize files array
		files = new String[NUMBER_OF_JOBS];
		// pass in fileNames of programs to files array
		files[0] = "Program1A.txt";
		files[1] = "Program2.txt";
		files[2] = "Program3.txt";
		files[3] = "Program1A.txt";
		files[4] = "Program2.txt";
		files[5] = "Program3.txt";
		bootUp();
	}
	
	/**
	 * run startup process
	 */
	protected void bootUp() {
		jobStart = MEMORY_JOB_START;
		// create memory object
		// pass in size of memory and where to start storing programs
		sharkMemory = new SharkMemory(MEMORY_SIZE, jobStart);
		
		// create jobQueue
		jobQ = new LinkedList<PCB>();
		
		// TODO incorporate this into programs
		sharkMemory.WRITE(0, 0);
		sharkMemory.WRITE(1, 1);
		sharkMemory.WRITE(2, 2);
		sharkMemory.WRITE(100, 1);
		sharkMemory.WRITE(101, 1);
		sharkMemory.WRITE(102, 1);
		sharkMemory.WRITE(103, 1);
		sharkMemory.WRITE(104, 1);
		sharkMemory.WRITE(105, 1);
		sharkMemory.WRITE(106, 1);
		sharkMemory.WRITE(107, 1);
		sharkMemory.WRITE(108, 1);
		sharkMemory.WRITE(109, 1);
		
		// Create CPU Object
		// Pass in memory
		cpu = new SharkCPU(sharkMemory);
		
		// load jobs into memory
		try {
			// load all files from the files string array
			for(String f: files) {
				loadFile(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		// sharkMemory.printMem();
		// run simulation
		cpu.run(sharkMemory, jobQ);
	}
	
	/**
	 *  @param s - a file path/name; ex - test.txt      
	 */
	
	private void loadFile(String s) throws Exception {
		// assign job priority level between 0, 1 or 2
		int pri = getRandInt(0,3);
		// Job j = new Job(jobQueue.getSize(), jobStart, pri);
		Job j = new Job(jobQ.size(), jobStart, pri);
		// create file
		File f = new File(s);
		// create file reader
		FileReader fr = new FileReader(f);
		@SuppressWarnings("resource")
		// create buffered reader
		BufferedReader br = new BufferedReader(fr);
		// read in line
		String eachLine = br.readLine();
		// while line is not null - process the line
		while (eachLine != null) {
			// parse the line from string to int
			// SDR = Integer.parseInt(eachLine);
			int data = Integer.parseInt(eachLine);
			// get location of where it should be stored
			// SAR = (short) jobStart;
			int location = (short) jobStart;
			// write the line into memory at specified location
			// WRITE();
			sharkMemory.WRITE(location, data);
			// get next line
			eachLine = br.readLine();
			// increment the storage location
			jobStart++;
		}
		// update the job end location
		j.update(jobStart);
		// store the job object in a new PCB object
		// and then store the PCB object in the jobQueue
		// jobQueue.addPCB( new PCB(j, jobQueue.getSize(), pri, cpu) );
		jobQ.add( new PCB(j, jobQ.size(), j.priority_level, cpu) );
	}
	
	/**
	 * Gets a random number 
	 * @param min	min to start from
	 * @param max	max to go up to
	 * @return		random int between min and max range
	 */
	public static int getRandInt(int min, int max){
		return ((int) (Math.random()*(max - min))) + min;
	}
	
	
}
