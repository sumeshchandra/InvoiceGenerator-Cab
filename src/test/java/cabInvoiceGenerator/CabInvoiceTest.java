package cabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {

    CabInvoiceMain invoiceGenerator = new CabInvoiceMain();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);

    }

    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(ride1);
        Assert.assertEquals(30, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] ride = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoice = invoiceGenerator.calculationFare(ride);
        InvoiceSummary invoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(invoiceSummary, invoice);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        String userId = "bis";
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.invoiceForUser(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenNormalRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary fare = invoiceGenerator.fare(rides, RideType.NORMAL);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, fare);
    }

    @Test
    public void givenPremiumsRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary fare = invoiceGenerator.fare(rides, RideType.PREMIUM);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummary , fare);
    }

}










