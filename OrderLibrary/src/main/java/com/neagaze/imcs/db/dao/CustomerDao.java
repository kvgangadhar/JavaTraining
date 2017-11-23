package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    //@Query("select c from Customer c join fetch c.paymentMethodList p where c.id= (:customerId)")
    @Query("select c from Customer c where c.id= (:customerId)")
    Customer fetchCustomerWithAddressAndPayment(@Param("customerId") Integer customerId);
}
