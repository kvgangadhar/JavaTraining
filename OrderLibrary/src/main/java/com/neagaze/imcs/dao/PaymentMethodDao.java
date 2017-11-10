package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.PaymentMethod;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface PaymentMethodDao {

    void insert(PaymentMethod paymentMethod);

    List<PaymentMethod> fetch(int customerId);

    void update(PaymentMethod paymentMethod);

    void delete(int paymentId);
}
