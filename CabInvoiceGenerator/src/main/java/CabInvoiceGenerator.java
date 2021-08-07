/****************************************************************************************************
 *
 * Purpose :
 *  UC 4 : InVoice Service :
 *         Given an User ID,The Invoice Service gets the list of rides from
 *         Ride Repository,and returns an invoice
 *
 ****************************************************************************************************/

import java.util.Hashtable;

public class CabInvoiceGenerator {

    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5.0;

    /**
     * Purpose : To calculate total fare
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {

        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;

        if(totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    /**
     * Purpose : To calculate fare for multiple rides
     *
     * @param rides array of multiple rides
     * @return total aggregate fare of multiple rides
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalAggregateFare = 0;
        for (Ride ride :rides) {
            totalAggregateFare += this.calculateFare(ride.distance,ride.time);
        }
        System.out.println(totalAggregateFare);
        return new InvoiceSummary(rides.length,totalAggregateFare);
    }

    public InvoiceSummary inVoiceService(Hashtable<Integer, Ride[]> listOfRides){
        Ride[] rides = listOfRides.get(1);
        InvoiceSummary inVoiceSummary = calculateFare(rides);
        return inVoiceSummary;
    }
}