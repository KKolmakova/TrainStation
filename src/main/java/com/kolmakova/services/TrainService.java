package com.kolmakova.services;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> list() {
        return trainRepository.findAll();
    }

    public List<Train> getByArrivalPlace(String arrivalPlace) {
        return trainRepository.findTrainByArrival(arrivalPlace);
    }

    public Train getTrainById(int id) {
        return trainRepository.getTrainById(id);
    }

    public List<Integer> getTrainsId(List<Train> trains) {
        List<Integer> trainsId = new ArrayList<>();
        for (Train train : trains) {
            trainsId.add(train.getId());
        }

        return trainsId;
    }

    public List<Train> getTrainsByIdes(Integer[] id){
        return trainRepository.getTrainsByIdes(id);
    }
}
