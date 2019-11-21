public class Calculations {

    protected int SPEED_AMOUNT;
    protected int SPEED_LIMIT;
    protected boolean LOCATION_ZONE;
    public final String OVER_30_STRING = "Court Mandatory";

    public Calculations(){
        this.SPEED_AMOUNT = 0;
        this.SPEED_LIMIT = 0;
        this.LOCATION_ZONE = false;
    }

    public void updateSpeed(int num){
        this.SPEED_AMOUNT = num;
    }
    public void updateLimit(int num){
        this.SPEED_LIMIT = num;
    }

    public void updateZone(boolean v){
        this.LOCATION_ZONE = v;
    }

    public void updateValues(int a, int l, boolean z){
        updateSpeed(a);
        updateLimit(l);
        updateZone(z);
    }

    public int runCalculations(int a, int l, boolean z){
        updateValues(a, l, z);
        // calculate fine
        // int fine = calculateFine(SPEED_AMOUNT,SPEED_LIMIT,LOCATION_ZONE);
        // return fine;
        return runCalculations();

    }

    public int runCalculations(){
        System.out.println("SPEED_AMOUNT: " + this.SPEED_AMOUNT+" SPEED_LIMIT: "+ this.SPEED_LIMIT + " LOCATION_ZONE: "+ this.LOCATION_ZONE);
        return calculateFine(this.SPEED_AMOUNT,this.SPEED_LIMIT,this.LOCATION_ZONE);
    }


    /**
     *
     * @param speed
     * @param limit
     * @param zone
     * @return
     */
    public static int calculateFine(int speed, int limit, boolean zone) {
        int fine = 0;
        // get speed
        int speedOver = checkSpeed(speed, limit);
        System.out.println("speedOver: "+speedOver);
        // get fine amount
        int fineAmt = getFine(speedOver);
        System.out.println("fineAmt: " + fineAmt);
        // do final calc and return
        if (fineAmt > -1) {
            if (zone){
                fineAmt *= 2;
            }
            return fineAmt;
        } else {
            // Court Mandatory
            return -1;
        }
        /*
        if (zone)
            ßfineAmt *= 2;
        return fine;
         */
    }

    /**
     *
     * @param speed
     * @param limit
     * @return int amount of speed diff if over limit
     */
    public static int checkSpeed (int speed, int limit) {
        return speed <= limit ? 0 : (speed - limit);
    }


    /**
     *
     * @param speed
     * @return int amount of fine
     */
    public static int getFine (int speed) {

//        if (speed >= 30) {
//            return -1;
//        } else if ((speed < 30) && (speed >= 20)) {
//            return 279;
//        } else if ((speed < 20) && (speed >= 15)) {
//            return 254;
//        } else if ((speed < 15) && (speed >= 10)) {
//            return 204;
//        } else if ((speed < 10) && (speed > 0)) {
//            return 179;
//        } else {
//            return 0;
//        }

        if (speed <= 0) {
            return 0;
        } else if (speed < 10) {
            return 179;
        } else if (speed < 15) {
            return 204;
        } else if (speed < 20) {
            return 254;
        } else if (speed < 30) {
            return 279;
        } else {
            return -1;
        }
    }
}
