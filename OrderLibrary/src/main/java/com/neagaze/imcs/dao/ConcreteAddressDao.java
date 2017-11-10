package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Address;
import com.neagaze.imcs.service.ConcreteDbService;
import com.neagaze.imcs.util.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by neaGaze on 11/9/17.
 */
public class ConcreteAddressDao implements AddressDao {

    final static Logger logger = Logger.getLogger(ConcreteAddressDao.class);

    public void insertAddress(Address address) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        System.out.println("Address id: " + address.getId());
        logger.debug("Address id: " + address.getId());
        // factory.close();
    }

    public Address updateAddress(Address address) {

        SessionFactory factory1 = HibernateUtils.buildSessionFactory();
        Session session = factory1.openSession();
        session.beginTransaction();
        session.saveOrUpdate(address);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    public int deleteAddress(Integer custId) {
        SessionFactory factory = HibernateUtils.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        String query = "delete FROM Address AS addr WHERE addr.id = :id";
        int i = session.createQuery(query).setInteger("id", custId).executeUpdate();

        session.getTransaction().commit();
        session.close();
        System.out.println("Delete address id: " + i);
        logger.debug("Delete address id: " + i);
        return i;
    }
}
