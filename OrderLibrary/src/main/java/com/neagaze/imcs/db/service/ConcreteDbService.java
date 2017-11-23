package com.neagaze.imcs.db.service;

import com.neagaze.imcs.db.dao.*;
import com.neagaze.imcs.db.entities.Address;
import com.neagaze.imcs.db.entities.PaymentMethod;
import com.neagaze.imcs.db.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
@Service
public class ConcreteDbService implements DatabaseServiceInterface {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private PaymentMethodDao paymentMethodDao;

    public int addCustomer(Customer customer) {
        Customer customer1 =  customerDao.save(customer);
        return (customer1 != null) ? 1 : 0;
    }

    public void addPayments(Integer custId, PaymentMethod paymentMethod) {

        paymentMethod.setCustomer(customerDao.findOne(custId));

        paymentMethodDao.save(paymentMethod);
    }

    public List<PaymentMethod> getPaymentFromCustomer(Integer customerId) {
        return paymentMethodDao.findPaymentMethods(customerId);
        //return null;
    }

    public Customer getCustomer(int customerId) {
        return customerDao.fetchCustomerWithAddressAndPayment(new Integer(customerId));
    }

    public Customer getCustomerWithAddress(int customerId) {
        return customerDao.findOne(new Integer(customerId));
    }

    public void deleteCustomer(Integer customerId) {
        customerDao.delete(customerId);
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodDao.save(paymentMethod);
    }

    public void deletePaymentMethods(Integer customerId) {
        paymentMethodDao.delete(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> lists = new ArrayList<Customer>();
        Iterable<Customer> iterable =  customerDao.findAll();
        Iterator<Customer> iter = iterable.iterator();
        while (iter.hasNext()) {
            lists.add(iter.next());
        }
        return lists;
    }
}
