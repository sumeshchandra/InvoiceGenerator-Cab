package cabInvoiceGenerator;

public class CabInvoiceMain {
    private double COST_PER_KM = 10.0;
    private int COST_PER_MINUTE = 1;
    private double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double fare = COST_PER_KM * distance + COST_PER_MINUTE * time;
        return fare < MINIMUM_FARE ? MINIMUM_FARE : fare;
    }
}
