package com.kolmakova.responseServices;

import com.kolmakova.responses.PaymentResponse;

public interface ReceiptsResponseService {

    PaymentResponse getResponse(int passengerId);
}
