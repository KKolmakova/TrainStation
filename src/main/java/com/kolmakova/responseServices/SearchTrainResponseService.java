package com.kolmakova.responseServices;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.responses.RegistrationOnTrainResponse;

public interface SearchTrainResponseService {

    RegistrationOnTrainResponse getResponse(TrainDTO trainDTO);
}
