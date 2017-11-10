package com.neagaze.imcs.service;

import com.neagaze.imcs.dao.ConcreteCustomerDao;
import com.neagaze.imcs.dao.ConcretePaymentMethodDao;
import com.neagaze.imcs.dao.CustomerDao;
import com.neagaze.imcs.dao.PaymentMethodDao;
import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.entities.PaymentMethod;
import com.neagaze.imcs.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcreteDbService implements DatabaseServiceInterface {

    public int addCustomer(Customer customer) {
        CustomerDao customerDao = new ConcreteCustomerDao();
        return customerDao.insertCustomer(customer);
    }

    public void addPayments(int customerId, PaymentMethod paymentMethod) {
        PaymentMethodDao paymentMethodDao = new ConcretePaymentMethodDao();
        paymentMethodDao.insert(paymentMethod);
    }

    public List<PaymentMethod> getPaymentFromCustomer(int customerId) {
        return null;
    }

    public Customer getCustomer(int customerId) {
        return null;
    }

    public Customer getCustomerWithAddress(int customerId) {
        return null;
    }

    public void deleteCustomer(Customer customer) {
        CustomerDao cdao = new ConcreteCustomerDao();
        cdao.deleteCustomer(customer);
    }

    public void updatePayment(PaymentMethod paymentMethod) {

    }

    public void deletePayment(int customerId) {

    }
}
