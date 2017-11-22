package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.Address;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface AddressDao {

    void insertAddress(Address address);

    Address updateAddress(Address address);

    int deleteAddress(Integer custId);
}
