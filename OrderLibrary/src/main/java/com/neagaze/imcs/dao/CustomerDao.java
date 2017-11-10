package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Customer;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface CustomerDao {

    int insertCustomer(Customer customer);

    void fetchCustomerWithAddressAndPayment(int customerId);

    void fetchCustomerWithAddress(int customerId);

    void deleteCustomer(Customer customer);
}
