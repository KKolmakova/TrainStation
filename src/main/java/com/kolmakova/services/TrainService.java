package com.kolmakova.services;

import com.kolmakova.entities.Train;
import com.kolmakova.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> list(){
        return trainRepository.findAll();
    }
}
