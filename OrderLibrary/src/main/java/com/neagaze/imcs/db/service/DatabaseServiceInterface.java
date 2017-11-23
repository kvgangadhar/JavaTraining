package com.neagaze.imcs.db.service;

import com.neagaze.imcs.db.entities.PaymentMethod;
import com.neagaze.imcs.db.entities.Customer;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface DatabaseServiceInterface {

    int addCustomer(Customer customer);

    void addPayments(Integer custId, PaymentMethod paymentMethod);

    List<PaymentMethod> getPaymentFromCustomer(Integer customerId);

    Customer getCustomer(int customerId);

    Customer getCustomerWithAddress(int customerId);

    void deleteCustomer(Integer customerId);

    PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

    void deletePaymentMethods(Integer customerId);

    List<Customer> getAllCustomers();
}
