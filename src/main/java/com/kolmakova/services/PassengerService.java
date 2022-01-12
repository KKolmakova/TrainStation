package com.kolmakova.services;

import com.kolmakova.entities.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger getOne(int passengerId);

    Passenger save(Passenger passenger);

    boolean containsPayment(List<Passenger> passengers, Integer paymentId);

    boolean containsPassenger(List<Passenger> passengers, Integer passengerId);
}
