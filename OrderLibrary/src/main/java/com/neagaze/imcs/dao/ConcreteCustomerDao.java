package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Customer;
import com.neagaze.imcs.util.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcreteCustomerDao implements CustomerDao {

    final static Logger logger = Logger.getLogger(ConcreteCustomerDao.class);

    public int insertCustomer(Customer customer) {
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        int id = customer.getId();
        System.out.println("Customer id#1: " + id);
        logger.debug("Customer id#1: " + id);
        //factory.close();

        return id;
    }

    public Customer fetchCustomerWithAddressAndPayment(int customerId) {
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
/*
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", customerId));
        Customer customer = (Customer) criteria.list().get(0);
*/
        Query q = session.createQuery("FROM Customer AS c WHERE c.id = "+customerId);
        Customer customer =  (Customer) q.list().get(0);
        int size = customer.getPaymentMethodList().size();
        System.out.println("size after loading lazy list:  " + size);
        logger.debug("size after loading lazy list:  " + size);
        transaction.commit();
        session.close();

        return customer;
    }

    public Customer fetchCustomerWithAddress(int customerId) {
        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Query q = session.createQuery("FROM Customer AS c WHERE c.id = " + customerId);
        Customer customer =  (Customer) q.list().get(0);
        transaction.commit();
        session.close();

        return customer;
    }

    public void deleteCustomer(Integer customerId) {

        SessionFactory factory = HibernateUtils.getFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Customer c = (Customer) session.load(Customer.class, customerId);
        session.delete(c);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted Customer id: " + c.getId());
        logger.debug("Deleted Customer id: " + c.getId());
    }
}
