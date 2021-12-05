package com.kolmakova.dto;

import com.kolmakova.entities.Train;

import java.util.List;

public class ControllerDTO {

    private Train train;
    private int trainId;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }
}
