package com.kolmakova.services.impl;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger getById(int passengerId) {
        return passengerRepository.getOne(passengerId);
    }

    @Override
    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public boolean containsPayment(List<Passenger> passengers, Integer paymentId) {
        if (Objects.isNull(passengers) || Objects.isNull(paymentId)) {
            return false;
        }

        for (Passenger passenger : passengers) {
            if (Objects.isNull(passenger.getPaymentList())) {
                return false;
            }
            for (Payment payment : passenger.getPaymentList()) {
                if (paymentId.equals(payment.getId())) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean containsPassenger(List<Passenger> passengers, Integer passengerId) {
        if (Objects.isNull(passengers) || Objects.isNull(passengerId)) {
            return false;
        }

        for (Passenger passenger : passengers) {
            if (passengerId.equals(passenger.getId())) {
                return true;
            }
        }

        return false;
    }
}
