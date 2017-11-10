package com.neagaze.imcs.service;

import com.neagaze.imcs.dao.ConcreteCustomerDao;
import com.neagaze.imcs.dao.ConcretePaymentMethodDao;
import com.neagaze.imcs.dao.CustomerDao;
import com.neagaze.imcs.dao.PaymentMethodDao;
import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.entities.PaymentMethod;
import com.neagaze.imcs.util.HibernateUtils;
import org.apache.log4j.Logger;
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

    public void addPayments(Integer custId, PaymentMethod paymentMethod) {

        CustomerDao cdao = new ConcreteCustomerDao();
        paymentMethod.setCustomer(cdao.fetchCustomerWithAddress(custId));

        PaymentMethodDao paymentMethodDao = new ConcretePaymentMethodDao();
        paymentMethodDao.insert(paymentMethod);
    }

    public List<PaymentMethod> getPaymentFromCustomer(Integer customerId) {
        PaymentMethodDao paymentMethodDao = new ConcretePaymentMethodDao();
        return paymentMethodDao.findPaymentMethods(customerId);
    }

    public Customer getCustomer(int customerId) {
        CustomerDao cdao = new ConcreteCustomerDao();
        return cdao.fetchCustomerWithAddressAndPayment(customerId);
    }

    public Customer getCustomerWithAddress(int customerId) {
        CustomerDao cdao = new ConcreteCustomerDao();
        return cdao.fetchCustomerWithAddress(customerId);
    }

    public void deleteCustomer(Integer customerId) {
        CustomerDao cdao = new ConcreteCustomerDao();
        cdao.deleteCustomer(customerId);
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        PaymentMethodDao pmdao = new ConcretePaymentMethodDao();
        return pmdao.updatePaymentMethod(paymentMethod);
    }

    public Integer deletePaymentMethods(Integer customerId) {
        PaymentMethodDao pdao = new ConcretePaymentMethodDao();
        return pdao.deletePaymentMethods(customerId);
    }
}
