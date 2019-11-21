import java.util.*;

public class SharkCPU {
	// LinkedList Queue of PCB's that are to be processed
	LinkedList<PCB> pcbList;
	// LinkedList Queue of PCB's that are finished
	LinkedList<PCB> pcbFinList;
	// memory data structure
	SharkMemory sharkMemory;
	// clock timer structure
	SharkClock time;
	
	PCB curr;
	
	boolean switchFlag;
	
	// 32-bit Registers
	// accumulator
	protected int ACC;
	// Storage Data Register
	protected int SDR;
	// Temporary Register
	protected int TMPR;
	// Control Storage Instruction Address Register
	protected int CSIAR;
	// Instruction Register
	protected int IR;
	// Micro-instruction Register
	protected int MIR;
		
	// 16-bit Registers
	// Primary  Storage  Instruction  Address  Register
	// MEMORY INSTRUCTION POINTER
	protected short PSIAR;
	// Storage Address Register
	protected short SAR;
	
	// program counter - for use with scheduling
	public int counter;
	// current instruction operand
	public int operand;
	// current instruction opcode
	public int opcode;
	public final int[] priority_time_count = {2, 3, 5};
	/**
	 * Constructor
	 * @param s SharkMemory data structure 
	 */
	public SharkCPU(SharkMemory s) {
		// setup access to memory data structure
		this.sharkMemory = s;
		// setup the clock timer structure
		time = new SharkClock();
	}
	
	/**
	 * Updates the 8 Registers via a passed int array
	 * Registers are always stored and assigned alphabetically
	 * 
	 * @param reg	(int array) of stored register values
	 * 				of size 8
	 */
	public void updateRegisters(int[] reg) {
		ACC = reg[0];
		CSIAR = reg[1]; 
		IR = reg[2];
		MIR = reg[3];
		PSIAR = (short) reg[4];
		SAR = (short) reg[5];
		SDR = reg[6];
		TMPR = reg[7];
	}
	/**
	 * Retrieves the 8 Registers returned via an int array
	 * Registers are always stored and assigned alphabetically
	 * 
	 * @return		arr (int array) of size 8
	 */
	public int[] getRegisters() {
		int[] arr = new int[8];
		arr[0] = ACC;
		arr[1] = CSIAR; 
		arr[2] = IR;
		arr[3] = MIR;
		arr[4] = PSIAR;
		arr[5] = SAR;
		arr[6] = SDR;
		arr[7] = TMPR;
		return arr;
	}

	/**
	 * ADD
	 */
	private void ADD() {
		// increment the PSIAR - using the ACC
		TMPR = ACC;
		ACC = PSIAR + 1;
		PSIAR = (short) ACC;
		ACC = TMPR;
		// use TMPR to transfer from SAR to SDR
		TMPR = SDR;
		SAR = (short) TMPR;
		SDR = sharkMemory.READ(SAR);
		TMPR = SDR;
		ACC = ACC + TMPR;
		CSIAR = 0;
	}


	/**
	 * SUB
	 */
	private void SUB() {
		// System.out.println("-- SUB --");
		TMPR = ACC;
		ACC = PSIAR + 1;
		PSIAR = (short) ACC;
		ACC = TMPR;
		TMPR = SDR;
		SAR = (short) TMPR;
		SDR = sharkMemory.READ(SAR);
		TMPR = SDR;
		ACC = ACC - TMPR;
		CSIAR = 0;
	}

	/**
	 * LDA - Load
	 */
	private void LDA() {
		// System.out.println("-- LOAD --");
		// Increment PSIAR ( using ACC )
		ACC = PSIAR + 1; 
		PSIAR = (short) ACC;
		// Transfer SRR to SAR using TMPR
		TMPR = SDR;
		SAR = (short) TMPR;
		SDR = sharkMemory.READ(SAR);
		ACC = SDR;
		CSIAR = 0;
	}
	
	private void LDI() {
		// Increment PSIAR ( using ACC )
		ACC = PSIAR + 1; 
		PSIAR = (short) ACC;
		// Load value from SDR into ACC 
		ACC = SDR;
		// Set CSIAR to 0
		CSIAR = 0;
		
	}

	/**
	 * STR - Store
	 */
	private void STR() {
		// System.out.println("-- STORE --");
		// 40
		TMPR = ACC; 
		// 41
		ACC = PSIAR + 1;
		// 42
		PSIAR = (short) ACC; 
		// 43
		ACC = TMPR;
		// 44
		TMPR = SDR; 
		// 45
		SAR = (short) TMPR;
		// 46
		SDR = ACC; 
		// 47
		// WRITE()
		sharkMemory.WRITE(SAR,SDR);
		// 48
		CSIAR = 0; 
	}

	/**
	 * BRH - Branch
	 */
	private void BRH(int st) {
		// System.out.println("-- BRANCH --");
		// Branch to location in SDR
		PSIAR = (short) (st + SDR);
		CSIAR = 0;
	}

	/**
	 * CBR - Conditional Branch
	 */
	private void CBR(int st) {
		// System.out.println("-- COND BRANCH --");
		// if Accumulator is 0, Branch to location in SDR
		if (ACC == 0) {
			PSIAR = (short) (st + SDR);
			CSIAR = 0;
		}
		// else go to next instruction
		else {
			ACC = PSIAR + 1;
			PSIAR = (short) ACC;
			CSIAR = 0;
		}
	}
	
	/**
	 * prints all main variables
	 */
	private void statusCheckPrint() {
		String str = "=";
		System.out.println(new String(new char[15]).replace("\0", str));
		System.out.println("REGISTERS:");
		System.out.println("ACC    : " + ACC);
		System.out.println("CSIAR  : " + CSIAR);
		System.out.println("IR     : " + IR);
		System.out.println("MIR    : " + MIR);
		System.out.println("PSIAR  : " + PSIAR);
		System.out.println("SAR    : " + SAR);
		System.out.println("SDR    : " + SDR);
		System.out.println("TMPR   : " + TMPR);
		System.out.println(new String(new char[15]).replace("\0", str));
		// System.out.println("MEMORY:");
		// sharkMemory.printMem();
	}
	
	
	
	/**
	 * 
	 * @param p		required priority level for requested index 
	 * @return		index of acceptable PCB if it exists
	 * 				-1 if no available PCB of that priority level exists
	 */
	public int getNextIndex(int p) {
		int index = -1;
		// loop through array list of PCBs
		for(int i = 0; i < pcbList.size(); i++) {
			// if the priority level matches the requested level
			// and it is not finished
			if ((pcbList.get(i).priority_level == p) && (pcbList.get(i).finished == false)) {
				return i;
			}
		}
		return index;
	}
	/**
	 * 
	 * @return		index of priority 2 || 1 PCB if it exists
	 * 				-1 if no available PCB exists
	 */
	public int getNextIndexForRoundRobin() {
		int index = -1;
		// loop through array list of PCBs
		for(int i = 0; i < pcbList.size(); i++) {
			// if the priority level doesn't match 0 and it is not finished
			if ((pcbList.get(i).priority_level != 0) && (pcbList.get(i).finished == false)) {
				return i;
			}
		}
		return index;
	}
	/**
	 * 
	 * @return		index of priority 0 PCB if it exists
	 * 				-1 if no available PCB exists
	 */
	public int getNextIndexForFIFO() {
		int index = -1;
		// loop through array list of PCBs
		for(int i = 0; i < pcbList.size(); i++) {
			// if the priority level matches 0 and it is not finished
			if ((pcbList.get(i).priority_level == 0) && (pcbList.get(i).finished == false)) {
				return i;
			}
		}
		return index;
	}


	public void run(SharkMemory m, LinkedList<PCB> p) {
		// print status - FOR DEBUGGING ONLY
		// statusCheckPrint();
		// load JobQueue
		pcbList = p;
		// create finished jobQueue
		pcbFinList = new LinkedList<PCB>();
		// load memory
		sharkMemory = m;
		// set switchFlag initially to false
		switchFlag = false;
		// while jobs exist to run
		while(!pcbList.isEmpty()) {
			// print status - FOR DEBUGGING ONLY
			// statusCheckPrint();
			
			// create index variable
			int index;
			
			// check if job exists for RoundRobin
			if(getNextIndexForRoundRobin() != -1) {
				// get next id of job for Round Robin Scheduling
				index = getNextIndexForRoundRobin();
			} else {
				// get next id of job for FIFO Scheduling
				index = getNextIndexForFIFO();
			}
			
			// get PCB that has that id
			curr = pcbList.get(index);
			
			// load PCB's register variables
			updateRegisters(curr.registers);
			
			// PSIAR = (short) curr.j.start;
			PSIAR = (short) ((short) curr.job.start + (short) curr.job.getCPUTime());
			// System.out.println("PSIAR: " + PSIAR);
			
			// while switch not available
			while(!switchFlag) {
				// System.out.println("*** INSTRUCTION ***");
				// System.out.println(curr);
				runInstruction();
				
				// TODO take out - or put in runInstruction???
				if(counter == priority_time_count[curr.job.priority_level]) {
					// System.out.println("*** SWITCHING ***");
					curr.setRegisters(getRegisters());
					counter = 0;
					switchFlag = true;
					// create userInput Object to ask if want to print stats
					if(new UserInput().getResponse()) {
						statusCheckPrint();
						printStats();
					}
				}
			}
			switchFlag = false;
		}
		
		
	}
	
	public PCB findPCBByID(int i) {
	    for(PCB obj : pcbList) {
	        if (obj.id == i) {
	            return obj;
	        }
	    }
	    return null;
	}
	
	public void runInstruction() {
		// FETCH
		SAR = PSIAR;
		// statusCheckPrint();
		SDR = sharkMemory.READ(SAR);
		IR = SDR;
		// DECODE
		operand = IR % 10000;
		opcode = (IR - (IR % 10000)) / 10000;
		
		// System.out.println("OPCODE  : " + opcode);
		// System.out.println("OPERAND : " + operand);
		// Check for Halt Code
		if(IR == 0) {
			curr.setFinished(true);
			curr.setRegisters(getRegisters());
			pcbFinList.add(curr);
			pcbList.remove(curr);
		} else {
			CSIAR = opcode;
			SDR = operand;
			// EXECUTE 
			switch(CSIAR) {
				case 10 :		ADD();				break;
				case 20 :		SUB();				break;
				case 30 :		LDA();				break;
				case 40 :		STR();				break;
				case 50 :		BRH(curr.job.start);	break;
				case 60 :		CBR(curr.job.start);	break;
				case 70 :		LDI();				break;
				default:			System.out.println("Opcode not valid: " + CSIAR); break;
			}
		}
		counter++;
		curr.job.addToCPUTime(1);
		time.incTime();
	}
	
	
	public void printStats() {
		String s = "CLOCK TIME: " + time.getTime() + "\n";
		s += "JOBS LEFT: " + pcbList.size() + "\n";
		s += "JOBS DONE: " + pcbFinList.size() + "\n";
		s += "CURR PCB ID: " + curr.getId() + "\n";
		s += "CURR JOB ID: " + curr.job.id + "\n";
		s += "TIME LEFT: " + (curr.job.getSize()-curr.job.getCPUTime()) + "\n";
		System.out.println(s);
	}
}
