package com.kolmakova.services;

import com.kolmakova.entities.Payment;

public interface PaymentService {

     Payment getById(int paymentId);

     Payment save(Payment payment);
}
