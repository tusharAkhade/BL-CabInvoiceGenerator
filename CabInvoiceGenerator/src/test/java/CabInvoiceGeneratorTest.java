/**
 * Purpose : To perform JUnit testing on methods of Cab Invoice Generator
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator inVoiceGenerator = null;

    @Before
    public void setUp() throws Exception {
        inVoiceGenerator = new CabInvoiceGenerator();
    }

    /**
     * Test Case 1 : given distance and time should return total fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 4.0;
        int time = 10;
        double totalFare = inVoiceGenerator.calculateFare(distance, time);

        Assert.assertEquals(50.0,totalFare,0.0);
    }

    /**
     * Test Case 2 : given distance and time should return minimum fare
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 2;
        double totalFare = inVoiceGenerator.calculateFare(distance, time);

        Assert.assertEquals(5.0,totalFare,0.0);
    }
}