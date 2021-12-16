package com.kolmakova.responseServices;

import com.kolmakova.responses.RegistrationOnTrainResponse;

import java.util.List;

public interface RegistrationResponseService {

    RegistrationOnTrainResponse getResponse(Integer pricingId);
}
