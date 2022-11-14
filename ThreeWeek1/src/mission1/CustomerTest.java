package mission1;

import java.util.ArrayList;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerJa = new Customer("James", 10000, 2);
        Customer customerTo = new Customer("Tomas", 30000, 2);
        Customer customerEd = new PLATINUMCustomer("Edward", 10000, 2);
        Customer customerPe = new PLATINUMCustomer("Percy", 30000, 2);
        Customer customerEl = new DIAMONDCustomer("Elizabet", 30000, 2);


        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(customerJa);
        customerList.add(customerTo);
        customerList.add(customerEd);
        customerList.add(customerPe);
        customerList.add(customerEl);

        System.out.println("=========================고객정보 출력=========================");
        for(Customer customer: customerList) {
            System.out.println(customer.showCustomerInfo());
        }
    }
}
