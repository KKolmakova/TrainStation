package com.kolmakova.services.impl;

import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PaymentRepository;
import com.kolmakova.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getOne(int checkId) {
        return paymentRepository.findById(checkId).orElse(new Payment());
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

}
