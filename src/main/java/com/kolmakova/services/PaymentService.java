package com.kolmakova.services;

import com.kolmakova.entities.Payment;

public interface PaymentService {
     Payment getOne(int checkId);

     Payment save(Payment payment);
}
