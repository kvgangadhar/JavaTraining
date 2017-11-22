package com.neagaze.imcs.db.dao;

import com.neagaze.imcs.db.entities.PaymentMethod;

import java.util.List;

/**
 * Created by neaGaze on 11/9/17.
 */
public interface PaymentMethodDao {

    void insert(PaymentMethod paymentMethod);

    List<PaymentMethod> findPaymentMethods(Integer customerId);

    PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);

    Integer deletePaymentMethods(Integer custId);
}
