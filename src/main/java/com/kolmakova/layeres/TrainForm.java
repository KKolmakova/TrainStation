package com.kolmakova.layeres;
import com.kolmakova.dto.TrainDTO;
import java.util.List;

public class TrainForm {

    private String visibilityPart;
    private TrainDTO selectedTrainDTO;
    private List<TrainDTO> trainDTOList;
    private String trainsIds;

    public String getTrainsIds() {
        return trainsIds;
    }

    public void setTrainsIds(String trainsIds) {
        this.trainsIds = trainsIds;
    }

    public String getVisibilityPart() {
        return visibilityPart;
    }

    public void setVisibilityPart(String visibilityPart) {
        this.visibilityPart = visibilityPart;
    }

    public TrainDTO getSelectTrainDTO() {
        return selectedTrainDTO;
    }

    public void setSelectTrainDTO(TrainDTO trainDTO) {
        this.selectedTrainDTO = trainDTO;
    }

    public List<TrainDTO> getTrainDTOList() {
        return trainDTOList;
    }

    public void setTrainDTOList(List<TrainDTO> trainDTOList) {
        this.trainDTOList = trainDTOList;
    }
}
