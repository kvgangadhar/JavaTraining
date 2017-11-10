package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.PaymentMethod;
import com.neagaze.imcs.util.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcretePaymentMethodDao implements PaymentMethodDao {

    final static Logger logger = Logger.getLogger(ConcretePaymentMethodDao.class);

    public void insert(PaymentMethod paymentMethod) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(paymentMethod);
        session.getTransaction().commit();
        session.close();
        System.out.println("Payment id: " + paymentMethod.getId());
        logger.debug("Payment id: " + paymentMethod.getId());
    }

    public List<PaymentMethod> findPaymentMethods(Integer customerId) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from PaymentMethod as pm WHERE pm.customer.id = :id").
                setInteger("id", customerId);

        List<PaymentMethod> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(paymentMethod);
        session.getTransaction().commit();
        session.close();
        return paymentMethod;
    }

    public Integer deletePaymentMethods(Integer custId) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        String query = "delete FROM PaymentMethod AS pm WHERE pm.customer.id = :id";
        int i = session.createQuery(query).setInteger("id", custId).executeUpdate();

        // session.delete(null);
        session.getTransaction().commit();
        session.close();
        //System.out.println("Payment id: " + paymentMethod.getId());
        return null;
    }
}
