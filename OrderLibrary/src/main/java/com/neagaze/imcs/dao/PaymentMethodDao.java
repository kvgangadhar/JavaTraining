package com.neagaze.imcs.dao;

import com.neagaze.imcs.entities.PaymentMethod;

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
