package com.kolmakova.services.impl;

import com.kolmakova.entities.Passenger;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger getOne(int passengerId) {
        return passengerRepository.getOne(passengerId);
    }

    @Override
    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
