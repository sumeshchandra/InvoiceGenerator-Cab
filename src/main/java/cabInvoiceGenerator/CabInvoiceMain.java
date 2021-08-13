package cabInvoiceGenerator;

public class CabInvoiceMain {
    RideRepository ridesRepository;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;


    public double calculateFare(double distance, int time) {
        double totalFare =  distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }
    public double calculateFare(double distance ,int time ,RideType ride){
        double totalFare = distance * ride.MINIMUM_COST_PER_KM + time *ride.COST_PER_MINUTE;
        if (totalFare < ride.MINIMUM_FARE)
            return ride.MINIMUM_FARE;
        return  totalFare;
    }

    public double calculateFare(Ride[] ride1) {
        double totalFare = 0;
        for (Ride ride :ride1){
            totalFare += this.calculateFare(ride.distance,ride.time);

        }
        return  totalFare;
    }


    public InvoiceSummary calculationFare(Ride[]ride){
        double totalFare = 0 ;
        for (Ride rides :ride){
            totalFare += this.calculateFare(rides.distance,rides.time);

        }
        return new InvoiceSummary(ride.length, totalFare);
    }

    public  InvoiceSummary fare(Ride[] rides,RideType rideType){
        double totalFare = 0 ;
        for (Ride ride:rides){
            totalFare +=this.calculateFare(ride.distance,ride.time,rideType);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }


    public CabInvoiceMain(){
        this.ridesRepository = new RideRepository();
    }


    public void addRides(String userId, Ride[] rides) {
        ridesRepository.addRideForUser(userId, rides);
    }

    public InvoiceSummary invoiceForUser(String userId) {
        return calculationFare(ridesRepository.getRidesForUser(userId));
    }


}
