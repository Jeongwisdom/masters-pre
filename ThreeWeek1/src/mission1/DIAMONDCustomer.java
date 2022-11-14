package mission1;

public class DIAMONDCustomer extends Customer {

    public DIAMONDCustomer(String customerName, int payment, int parkingTime) {
        super(customerName, payment, parkingTime);
        customerGrade = "DIAMOND";
        discountRatio = 0.1;
        pointRatio = 0.1;
        parkingFee = 0;
    }

    public String showCustomerInfo() {
        return super.showCustomerInfo() + " 전문 상담원이 무료로 배정되었습니다.";
    }
}