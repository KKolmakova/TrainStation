package com.kolmakova.services.impl;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.TrainUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train getOne(int id) {
        return trainRepository.findById(id).orElse(new Train());
    }

    @Override
    public List<Integer> getTrainsId(List<Train> trains) {
        List<Integer> trainsId = new ArrayList<>();
        for (Train train : trains) {
            trainsId.add(train.getId());
        }

        return trainsId;
    }

    @Override
    public String getSelectedTrainsUrl(List<Train> trains) {
        List<Integer> ids = getTrainsId(trains);
        return StringUtils.join(ids, ',');
    }

    @Override
    public List<Train> findByIds(List<Integer> id) {
        return trainRepository.findAllById(id);
    }

    @Override
    public List<Train> getByParameters(String arrivalPlace, Date departureDate, Date departureTime) {
        Specification<Train> specification = TrainUtils.getWithParams(arrivalPlace, departureDate, departureTime);
        return trainRepository.findAll(specification);
    }

    @Override
    public List<String> getArrivalPlaces(){
        return trainRepository.getArrivalPlaces();
    }
}
