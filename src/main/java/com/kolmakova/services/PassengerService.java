package com.kolmakova.services;

import com.kolmakova.entities.Passenger;

public interface PassengerService {
    Passenger getOne(int passengerId);

    Passenger save(Passenger passenger);
}
