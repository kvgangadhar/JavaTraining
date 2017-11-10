package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Address;
import com.neagaze.imcs.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcreteAddressDao implements AddressDao{

    public void insertAddress(Address address) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        System.out.println("Address id: " + address.getId());
        // factory.close();
    }
}
