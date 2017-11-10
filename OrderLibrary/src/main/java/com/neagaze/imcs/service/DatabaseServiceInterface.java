package com.neagaze.imcs.service;

import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.entities.PaymentMethod;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface DatabaseServiceInterface {

    int addCustomer(Customer customer);

    void addPayments(int customerId, PaymentMethod paymentMethod);

     List<PaymentMethod> getPaymentFromCustomer(int customerId);

     Customer getCustomer(int customerId);

     Customer getCustomerWithAddress(int customerId);

     void deleteCustomer(Customer customer);

     void updatePayment(PaymentMethod paymentMethod);

     void deletePayment(int customerId);
}
