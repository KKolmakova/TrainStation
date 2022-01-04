package com.kolmakova.services;

import com.kolmakova.entities.Train;

import java.util.Date;
import java.util.List;

public interface TrainService {
    Train getOne(int id);

    List<Integer> getTrainsId(List<Train> trains);

    String getSelectedTrainsUrl(List<Train> trains);

    List<Train> findByIds(List<Integer> id);

    List<Train> getByParameters(String arrivalPlace, Date departureDate, Date departureTime);

    List<String> getArrivalPlaces();
}
