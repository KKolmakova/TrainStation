package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentResponse;

public interface ReceiptListResponseService {

    PaymentResponse getResponse(int passengerId);
}
