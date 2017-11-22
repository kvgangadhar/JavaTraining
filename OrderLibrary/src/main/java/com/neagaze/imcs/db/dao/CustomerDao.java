package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.Customer;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface CustomerDao {

    int insertCustomer(Customer customer);

    Customer fetchCustomerWithAddressAndPayment(int customerId);

    Customer fetchCustomerWithAddress(int customerId);

    void deleteCustomer(Integer customerId);

    List<Customer> fetchAllCustomers();
}
