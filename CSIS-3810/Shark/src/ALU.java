
public class ALU {

	public ALU() {
		
	}
	
	public int add2(int a, int b) {
		return a + b;
	}
	public int sub2(int a, int b) {
		return a - b;
	}
	
	/**
	 * ADD
	 * 
	 */
	private void ADD() {
		// System.out.println("-- ADD --");
		/* 
		 * // 10
		 * TMPR = ACC;
		 * // 11
		 * ACC = PSIAR + 1;
		 * // 12
		 * PSIAR = (short) ACC;
		 * // 13
		 * ACC = TMPR;
		 * // 14
		 * setTemp(getSDR))
		 * TMPR = SDR;
		 * // 15
		 * setSAR(getTemp())
		 * SAR = (short) TMPR;
		 * // 16
		 * READ();
		 * // 17
		 * setTemp(getSDR))
		 * TMPR = SDR;
		 * // 18
		 * setACC(getACC() + getTemp())
		 * ACC = ACC + TMPR;
		 * // 19
		 * CSIAR = 0;
		 */
		
		
	}
}
