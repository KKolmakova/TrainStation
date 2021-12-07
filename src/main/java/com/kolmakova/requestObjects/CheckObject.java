package com.kolmakova.requestObjects;

import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;

public class CheckObject {

    private Train train;
    private Passenger passenger;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
