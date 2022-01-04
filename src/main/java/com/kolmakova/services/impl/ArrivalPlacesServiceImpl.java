package com.kolmakova.services.impl;

import com.kolmakova.responses.ArrivalPlaceListResponse;
import com.kolmakova.services.ArrivalPlacesService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivalPlacesServiceImpl implements ArrivalPlacesService {

    @Autowired
    private TrainService trainService;

    public ArrivalPlaceListResponse getResponse() {
        ArrivalPlaceListResponse arrivalPlaceListResponse = new ArrivalPlaceListResponse();
        arrivalPlaceListResponse.setTrainsArrivalPlaces(trainService.getArrivalPlaces());

        return arrivalPlaceListResponse;
    }
}
