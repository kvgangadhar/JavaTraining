package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.PaymentMethod;
import com.neagaze.imcs.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcretePaymentMethodDao implements PaymentMethodDao {

    public void insert(PaymentMethod paymentMethod) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(paymentMethod);
        session.getTransaction().commit();
        session.close();
        System.out.println("Payment id: " + paymentMethod.getId());
        factory.close();
    }

    public List<PaymentMethod> fetch(int customerId) {
        return null;
    }

    public void update(PaymentMethod paymentMethod) {

    }

    public void delete(int paymentId) {

    }
}
