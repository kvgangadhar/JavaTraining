package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.PaymentMethod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
@Repository
public interface PaymentMethodDao extends CrudRepository<PaymentMethod, Integer>{

    //@Query("select p from PaymentMethod p where p.customer.id =:customerId")
    @Query("select p from Customer c join c.paymentMethodList p where c.id = :customerId")
    List<PaymentMethod> findPaymentMethods(Integer customerId);

}
