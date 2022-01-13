package com.kolmakova.responseServices;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responses.PaymentResponse;

public interface CreatePaymentResponseService {

    PaymentResponse create(PassengerDTO passengerDTO, int trainId, int pricingId);

    PaymentResponse getResponse(int paymentId);
}
