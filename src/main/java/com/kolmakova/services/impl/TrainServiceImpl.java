package com.kolmakova.services.impl;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import com.kolmakova.services.TrainService;
import com.kolmakova.util.TrainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train getById(int trainId) {
        return trainRepository.findById(trainId).orElse(new Train());
    }

    @Override
    public List<Train> getByParameters(String arrivalPlace, Date departureDate, Date departureTime) {
        Specification<Train> specification = TrainUtils.getWithParams(arrivalPlace, departureDate, departureTime);
        return trainRepository.findAll(specification);
    }

    @Override
    public List<String> getAllArrivalPlaces(){
        return trainRepository.getAllArrivalPlaces();
    }
}
