package com.kolmakova.responses;

import com.kolmakova.entities.Check;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;

public class CheckResponse {

    private Check check;
    private Passenger passenger;
    private Train train;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
