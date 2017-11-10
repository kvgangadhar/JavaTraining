package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcreteCustomerDao implements CustomerDao {
    public int insertCustomer(Customer customer) {
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        int id = customer.getId();
        System.out.println("Customer id#1: " + id);
        //factory.close();

        return id;
    }

    public void fetchCustomerWithAddressAndPayment(int customerId) {

    }

    public void fetchCustomerWithAddress(int customerId) {

    }

    public void deleteCustomer(Customer customer) {

        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Customer c = (Customer) session.load(Customer.class, customer.getId());
        session.delete(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted Customer id: " + c.getId());
        //factory.close();
    }
}
