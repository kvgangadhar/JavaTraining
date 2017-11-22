package com.neagaze.imcs.db;

import com.neagaze.imcs.db.entities.PaymentMethod;
import com.neagaze.imcs.db.entities.CardType;
import com.neagaze.imcs.db.entities.Customer;
import com.neagaze.imcs.db.service.ConcreteDbService;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import com.neagaze.imcs.db.util.CustomerUtils;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by neaGaze on 11/8/17.
 */
public class App {

    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        DatabaseServiceInterface service = new ConcreteDbService();

        Scanner scan = new Scanner(System.in);
        int id;
        boolean shouldContinueLoop = true;
        while(shouldContinueLoop) {
            System.out.println("1. Add customer\n2. Delete Customer\n3. Fetch Customer + Address + PaymentMethod\n" +
                "4. Fetch Customer + Address\n5. Delete Payment Methods\n6. Update Payment Method\n" +
                "7. Fetch all payment methods for a given customer\n8. Add payment methods for a given customer\n" +
                "9. Exit");
            id = scan.nextInt();

            switch (id) {
                case 1:
                    // adding customer
                    Customer customer = CustomerUtils.createCustomer();
                    service.addCustomer(customer);
                    System.out.println("The customerId in main.app is: " + customer.getId());
                    logger.debug("The customerId in main.app is: " + customer.getId());
                    break;

                case 2:
                    // now deleting
                    System.out.println("What is the id of the customer you want to delete?");
                    service.deleteCustomer(new Integer(scan.nextInt()));
                    break;

                case 3:
                    // now fetching
                    System.out.println("What is the id of the customer you want to fetch?");
                    int custId = scan.nextInt();
                    Customer c1 = service.getCustomer(custId);
                    System.out.println(c1.getName());
                    System.out.println(c1.getAddress());
                    if(c1.getPaymentMethodList() != null)
                    for (PaymentMethod p : c1.getPaymentMethodList()) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    // now fetching
                    System.out.println("What is the id of the customer you want to fetch?");
                    int custId1 = scan.nextInt();
                    Customer c2 = service.getCustomerWithAddress(custId1);
                    System.out.println(c2.getName());
                    System.out.println(c2.getAddress());
                    break;

                case 5:
                    // delete PaymentMethods
                    System.out.println("What is the customer_id of the payment methods you want to delete?");
                    int custId2 = new Integer(scan.nextInt());
                    service.deletePaymentMethods(custId2);
                    break;

                case 6:
                    // udpate payment methods
                    System.out.println("What is the payment_id of the payment methods you want to update?");
                    int payId = new Integer(scan.nextInt());

                    PaymentMethod paymentMethod2 = new PaymentMethod();
                    paymentMethod2.setId(new Integer(payId));
                    paymentMethod2.setCardName("BANK OF AMERICA");
                    paymentMethod2.setCardNumber(new Long(12349807));
                    paymentMethod2.setCardType(CardType.DEBIT_CARD);
                    paymentMethod2.setDateFrom(new Date());
                    service.updatePaymentMethod(paymentMethod2);
                    break;

                case 7:
                    // fetch all payment methods for a given customer
                    System.out.println("What is the customer_id of the payment methods you want to fetch");
                    ArrayList<PaymentMethod> list = (ArrayList<PaymentMethod>) service.
                            getPaymentFromCustomer(new Integer(scan.nextInt()));
                    for (PaymentMethod pm: list) {
                        System.out.println(pm);
                        logger.debug(pm);
                    }
                    break;

                case 8:
                    // add payment methods for a given customer
                    System.out.println("What is the customer_id of the payment methods you want to add");
                    Integer cId = new Integer(scan.nextInt());
                    service.addPayments(cId, CustomerUtils.createPaymentMethod());
                    break;

                default:
                    shouldContinueLoop = false;
                    break;
            }
        }
    }
}
