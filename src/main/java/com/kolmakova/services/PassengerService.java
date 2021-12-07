package com.kolmakova.services;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import com.kolmakova.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(int id){
        return passengerRepository.findById(id).orElse(new Passenger());
    }
}
