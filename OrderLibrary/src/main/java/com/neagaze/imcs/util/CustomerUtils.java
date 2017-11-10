package com.neagaze.imcs.util;

import com.neagaze.imcs.entities.Address;
import com.neagaze.imcs.entities.CardType;
import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.entities.PaymentMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by neaGaze on 11/10/17.
 */
public class CustomerUtils {

    public static Customer createCustomer() {

        Customer customer = new Customer();
        customer.setName("Michael Baptista");

        Address address = new Address();
        address.setAptNo("23");
        address.setStreetNo(715);
        address.setStreetName("Pioneer pkwy");
        address.setCity("Arlington");
        address.setState("TX");
        address.setZip(76001);
        customer.setAddress(address);
        address.setCustomer(customer);

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCardName("WELLS FARGO");
        paymentMethod.setCardNumber(new Long(566));
        paymentMethod.setCardType(CardType.CREDIT_CARD);
        paymentMethod.setDateFrom(new Date());
        paymentMethod.setCustomer(customer);

        PaymentMethod paymentMethod2 = new PaymentMethod();
        paymentMethod2.setCardName("CHASE");
        paymentMethod2.setCardNumber(new Long(6789000));
        paymentMethod2.setCardType(CardType.DEBIT_CARD);
        paymentMethod2.setDateFrom(new Date());
        paymentMethod2.setCustomer(customer);

        List<PaymentMethod> list = new ArrayList<PaymentMethod>();
        list.add(paymentMethod);
        list.add(paymentMethod2);
        customer.setPaymentMethodList(list);

        return customer;
    }

    public static PaymentMethod createPaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setDateFrom(new Date());
        paymentMethod.setCardType(CardType.CREDIT_CARD);
        paymentMethod.setCardName("CITI BANK");
        paymentMethod.setCardNumber(new Long(45699999));
        return paymentMethod;
    }
}
