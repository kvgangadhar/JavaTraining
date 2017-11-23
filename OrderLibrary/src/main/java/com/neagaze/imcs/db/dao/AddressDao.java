package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by neaGaze on 11/9/17.
 */
@Repository
public interface AddressDao extends CrudRepository<Address, Integer>{
/*
    void insertAddress(Address address);

    Address updateAddress(Address address);

    int deleteAddress(Integer custId);
    */
}
