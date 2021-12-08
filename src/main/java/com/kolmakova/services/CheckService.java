package com.kolmakova.services;

import com.kolmakova.entities.Check;
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
}
