package mission1;

public class Customer {
    protected String customerName;
    protected String customerGrade;
    protected int payment;
    protected int parkingTime;
    protected int parkingFee;
    protected double discountRatio;
    protected double pointRatio;

    public Customer(String customerName, int payment, int parkingTime) {
        this.customerName = customerName;
        this.payment = payment;
        this.parkingTime = parkingTime;
        customerGrade = "RED";
        discountRatio = 0;
        pointRatio = 0.01;
        parkingFee = 3000;
    }

    public String showCustomerInfo() {
        return customerName + "님의 지불 금액은 " + (int)(payment*(1 - discountRatio)) + "원이고, 적립 포인트는 "
                + (int)(payment*pointRatio) + "점 입니다. 주차 요금은 " + parkingFee*parkingTime + "원 입니다.";
    }
}
