package com.kolmakova.services;

import com.kolmakova.entities.Check;
import com.kolmakova.entities.Train;
import com.kolmakova.repositories.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    @Autowired
    private CheckRepository checkRepository;

    public Check saveCheck(Check check){
        return checkRepository.save(check);
    }

    public Check getCheckById(int checkId){
        return checkRepository.findById(checkId).orElse(new Check());
    }
}
