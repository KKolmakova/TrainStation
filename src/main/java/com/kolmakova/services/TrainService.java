package com.kolmakova.services;

import com.kolmakova.entities.Train;

import java.util.Date;
import java.util.List;

public interface TrainService {

    Train getById(int trainId);

    List<Train> getByParameters(String arrivalPlace, Date departureDate, Date departureTime);

    List<String> getAllArrivalPlaces();
}
