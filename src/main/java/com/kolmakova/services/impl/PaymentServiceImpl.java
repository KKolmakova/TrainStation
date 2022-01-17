package com.kolmakova.services.impl;

import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PaymentRepository;
import com.kolmakova.responseServices.CreatePaymentResponseService;
import com.kolmakova.services.PaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = Logger.getLogger(CreatePaymentResponseService.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(new Payment());
    }

    @Override
    public Payment save(Payment payment) {
        LOG.info(String.format("Create new payment number %s for passenger %s on train number %s", payment.getId(),
                payment.getPassenger().getName(), payment.getTrain().getNumber()));

        return paymentRepository.save(payment);
    }
}
