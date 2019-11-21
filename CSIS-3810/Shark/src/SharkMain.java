import java.io.*;
// import java.util.*;

public class SharkMain {
	
	// MEMORY
	private int[] memArray;
	// JOBS
	private Queue jobQueue;
	private int jobStart;
	
	//  REGISTERS
	
	// 32-bit
	private int ACC;			// accumulator
	private int SDR;			// Storage Data Register
	private int TMPR;		// Temporary Register
	
	// 16-bit
	private short PSIAR;		// Primary  Storage  Instruction  Address  Register - MEMORY INSTRUCTION POINTER
	private short SAR;		// Storage Address Register
	
	private int CSIAR;		// Control Storage Instruction Address Register
	private int IR;			// Instruction Register
	private int MIR;			// Micro-instruction Register
	
	/**
	 * Sets all registers to 0
	 */
	private void clearRegisters() {
		ACC = 0;
		CSIAR = 0;
		IR = 0;
		MIR = 0;
		PSIAR = 0;
		SAR = 0;
		SDR = 0;
		TMPR = 0;
	}
	
	/**
	 * End - Clears registers and prints end message
	 */
	private void end() {
		clearRegisters();
		System.out.println("Done All Jobs");
	}
	
	/**
	 * Prints the status of job with id and location.
	 * @param id			job id
	 * @param loc		job location
	 * @param status		job status
	 */
	private void jobStatusPrint(int id, int loc, String status) {
		System.out.println("--------------------");
		System.out.println("JOB ID: " + id);
		System.out.println("LOCA #: " + loc);
		System.out.println("STATUS: " + status);
		System.out.println("--------------------");
	}
	
	/**
	* Prints a readable array of integers to the console.
	* Separates each in sets of 16 with spacing with 8 digits
	* and a number in front indicating the row number.
	* @param arr		array to print
	*/
	private void prettyPrint(int[] arr) {
		System.out.print("00: ");
		for(int i = 0, j = 1; i < arr.length; i++) {
			System.out.printf(" %8d",arr[i]);
			if ((i % 16 == 15) && (i < arr.length-1)) {
				System.out.println();
				System.out.printf("%02d: ", j);
				j++;
			}
		}
		System.out.println();
	}
	
	/**
	 * print registers
	 */
	@SuppressWarnings("unused")
	private void printRegisters() {
		System.out.println("ACC    : " + ACC);
		System.out.println("CSIAR  : " + CSIAR);
		System.out.println("IR     : " + IR);
		System.out.println("MIR    : " + MIR);
		System.out.println("PSIAR  : " + PSIAR);
		System.out.println("SAR    : " + SAR);
		System.out.println("SDR    : " + SDR);
		System.out.println("TMPR   : " + TMPR);
	}

	/**
	 * Run and process job queue and instructions
	 */
	private void run() {
		clearRegisters();
		System.out.println("Running...");
		statusCheckPrint();
		// while jobs exist
		while (!jobQueue.isEmpty()) {
			// Clear the registers
			clearRegisters();
			// Get Job
			Job curr = jobQueue.remove();
			// set PSIAR to job start
			PSIAR = (short) curr.start;
			jobStatusPrint(curr.id, curr.start, curr.status);
			
			while (true) {
				// statusCheckPrint();
				// FETCH
				// 00
				SAR = PSIAR;
				
				// 01
				READ();
				
				// 02
				IR = SDR;
				
				// DECODE
				int operand = IR % 10000;
				int opcode = (IR - (IR % 10000)) / 10000;
				// for error checking readability
				// System.out.println("OPCODE  : " + opcode);
				// System.out.println("OPERAND : " + operand);
				
				// if PSIAR is past where the job's end is then break
//				if(PSIAR >= curr.end) {
//					// System.out.println("Done Job...");
//					break;
//				}
				if(IR == 0) {
					break;
				}
				
				// 03
				CSIAR = opcode;
				
				// 04
				SDR = operand;
				
				// EXECUTE 
				
				// printRegisters();
				switch(CSIAR) {
					case 10 :		ADD();		break;
					case 20 :		SUB();		break; 
					case 30 :		LDA();		break;
					case 40 :		STR();		break;
					case 50 :		BRH();		break;
					case 60 :		CBR();		break;
					default:			System.out.println("Opcode not valid: " + CSIAR); break;
				}
				
			}
			curr.setStatus("FINISHED");
			jobStatusPrint(curr.id, curr.start, curr.status);
			statusCheckPrint();
		}
		end();
	}
	
	/**
	 * READ
	 * passes data from primary storage (memArray) at
	 * 	the location specified in SAR to SDR
	 */
	private void READ() {
		// System.out.println("-- READ --");
		SDR = memArray[SAR];
	}

	/**
	 * ADD
	 * 
	 */
	private void ADD() {
		// System.out.println("-- ADD --");
		// 10
		// TMPR = ACC;
		// 11
		// ACC = PSIAR + 1;
		// 12
		// PSIAR = (short) ACC;
		PSIAR++;
		// 13
		// ACC = TMPR;
		// 14
		TMPR = SDR;
		// 15
		SAR = (short) TMPR;
		// 16
		READ();
		// 17
		TMPR = SDR;
		// 18
		ACC = ACC + TMPR;
		// 19
		// CSIAR = 0;
	}


	/**
	 * SUB
	 */
	private void SUB() {
		// System.out.println("-- SUB --");
		// 20
		TMPR = ACC;
		// 21
		ACC = PSIAR + 1;
		// 22
		PSIAR = (short) ACC;
		// 23
		ACC = TMPR;
		// 24
		TMPR = SDR;
		// 25
		SAR = (short) TMPR;
		// 26
		READ();
		// 27
		TMPR = SDR;
		// 28
		ACC = ACC - TMPR;
		// 29
		CSIAR = 0;
	}

	/**
	 * LDA - Load
	 */
	private void LDA() {
		// System.out.println("-- LOAD --");
		// 30
		ACC = PSIAR + 1; 
		// 31
		PSIAR = (short) ACC;
		// 32
		TMPR = SDR;
		// 33
		SAR = (short) TMPR;
		// 34
		READ();
		// 35
		ACC = SDR;
		// 36
		CSIAR = 0;
	}

	/**
	 * STR - Store
	 */
	private void STR() {
		// System.out.println("-- STORE --");
		// 40
		// TMPR = ACC; 
		// 41
		// ACC = PSIAR + 1;
		// 42
		// PSIAR = (short) ACC; 
		// 43
		// ACC = TMPR;
		// 44
		TMPR = SDR; 
		// 45
		SAR = (short) TMPR;
		// 46
		SDR = ACC; 
		// 47
		WRITE();
		// 48
		// CSIAR = 0; 
	}

	/**
	 * BRH - Branch
	 */
	private void BRH() {
		// System.out.println("-- BRANCH --");
		// 50
		PSIAR = (short) SDR; 
		// 51
		// CSIAR = 0;
	}

	/**
	 * CBR - Conditional Branch
	 */
	private void CBR() {
		// System.out.println("-- COND BRANCH --");
		// 60
		if (ACC == 0) {
			System.out.println("-- SKIP --");
			CSIAR = CSIAR + 2;
			// 62
			PSIAR = (short) SDR;
			// 63
			// CSIAR = 0;
		}
		else {
			// CSIAR = CSIAR + 1;
			// 61
			// CSIAR = 64;
			// 64
			// ACC = PSIAR + 1;
			// 65
			// PSIAR = (short) ACC;
			// 66
			CSIAR = 0;
		}
	}
	
	/**
	 *  @param s
	 *            a file path/name; ex - test.txt      
	 */
	
	private void loadFile(String s) throws Exception {
		Job j = new Job(jobQueue.len + 1, jobStart);
		// jobs.add(jobStart);
		File f = new File(s);
		FileReader fr = new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String eachLine = br.readLine();
		while (eachLine != null) {
			// WRITE(Integer.parseInt(eachLine));
			SDR = Integer.parseInt(eachLine);
			SAR = (short) jobStart;
			WRITE();
			eachLine = br.readLine();
			jobStart++;
		}
		j.update(jobStart);
		jobQueue.insert(j);
	}
	
	/**
	 * not currently used
	 * SKIP Function
	 * SKIP < add 2 to CSIAR if ACC=0; else add 1
	 */
	@SuppressWarnings("unused")
	private void SKIP() {
		System.out.println("-- SKIP --");
		if (ACC == 0)
			CSIAR = CSIAR + 2;
		else
			CSIAR = CSIAR + 1;
	}
	
	/**
	 * runs startup process
	 * @param m 			size of memory to set
	 * @param n 			number of jobs to set
	 */
	protected void startUp(int m, int n, int startFill) {
		System.out.println("Starting up...");
		int memSize = m;
		int numJobs = n;
		clearRegisters();
		
		memArray = new int[memSize];
		
		jobQueue = new Queue(numJobs);
		jobStart = 320;
		
		// fill memory
		memArray[0] = 0;
		memArray[1] = 1;
		memArray[2] = 2;
		memArray[100] = 1;
		memArray[101] = 1;
		memArray[102] = 1;
		memArray[103] = 1;
		memArray[104] = 1;
		memArray[105] = 1;
		memArray[106] = 1;
		memArray[107] = 1;
		memArray[108] = 1;
		memArray[109] = 1;
		memArray[201] = 11;
		memArray[301] = 10;
		System.out.println("Loading Jobs...");
		
		// load jobs into memory
		// catch exceptions
		try {
			loadFile("Program1A.txt");
			loadFile("Program2.txt");
			loadFile("Program3.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		// run the system
		run();
	}
	
	/**
	 * prints all main variables
	 */
	private void statusCheckPrint() {
		String str = "=";
		System.out.println(new String(new char[15]).replace("\0", str));
		System.out.println("REGISTERS:");
		// used in error checking prev - has same lines for registers as below
		// printRegisters();
		System.out.println("ACC    : " + ACC);
		System.out.println("CSIAR  : " + CSIAR);
		System.out.println("IR     : " + IR);
		System.out.println("MIR    : " + MIR);
		System.out.println("PSIAR  : " + PSIAR);
		System.out.println("SAR    : " + SAR);
		System.out.println("SDR    : " + SDR);
		System.out.println("TMPR   : " + TMPR);
		System.out.println(new String(new char[15]).replace("\0", str));
		System.out.println("MEMORY:");
		prettyPrint(memArray);
	}
	
	/**
	 * WRITE
	 * passes data from SDR to primary storage (memArray)
	 *  at the location specified in SAR 
	 */
	private void WRITE() {
		// System.out.println("-- WRITE --");
		memArray[SAR] = SDR;
	}
}
