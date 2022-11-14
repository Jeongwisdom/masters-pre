package mission1;

public class PLATINUMCustomer extends Customer {

    public PLATINUMCustomer(String customerName, int payment, int parkingTime) {
        super(customerName, payment, parkingTime);
        customerGrade = "PLATINUM";
        discountRatio = 0.05;
        pointRatio = 0.05;
        parkingFee = 1000;
    }
}
