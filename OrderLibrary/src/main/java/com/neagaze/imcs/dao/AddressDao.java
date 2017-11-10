package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.Address;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface AddressDao {

    void insertAddress(Address address);

    Address updateAddress(Address address);

    int deleteAddress(Integer custId);
}
