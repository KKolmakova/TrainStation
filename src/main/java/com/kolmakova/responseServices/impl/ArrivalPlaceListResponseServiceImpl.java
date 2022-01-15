package com.kolmakova.responseServices.impl;

import com.kolmakova.responses.ArrivalPlaceListResponse;
import com.kolmakova.responseServices.ArrivalPlaceListResponseService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalPlaceListResponseServiceImpl implements ArrivalPlaceListResponseService {

    @Autowired
    private TrainService trainService;

    public ArrivalPlaceListResponse getResponse() {
        ArrivalPlaceListResponse arrivalPlaceListResponse = new ArrivalPlaceListResponse();
        arrivalPlaceListResponse.setTrainsArrivalPlaces(trainService.getAllArrivalPlaces());

        return arrivalPlaceListResponse;
    }
}
