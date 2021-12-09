package com.kolmakova.layeres;

import com.kolmakova.dto.TrainDTO;

import java.util.List;

public class SearchForm {

    private List<TrainDTO> trainDTOList;
    private String trainsIds;

    public List<TrainDTO> getTrainDTOList() {
        return trainDTOList;
    }

    public void setTrainDTOList(List<TrainDTO> trainDTOList) {
        this.trainDTOList = trainDTOList;
    }

    public String getTrainsIds() {
        return trainsIds;
    }

    public void setTrainsIds(String trainsIds) {
        this.trainsIds = trainsIds;
    }
}
