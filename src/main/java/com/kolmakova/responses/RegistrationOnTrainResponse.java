package com.kolmakova.responses;
import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import java.util.List;

public class RegistrationOnTrainResponse {

    private TrainDTO selectedTrainDTO;
    private List<TrainDTO> trainDTOList;
    private PricingDTO pricingDTO;
    private String trainsIds;

    public String getTrainsIds() {
        return trainsIds;
    }

    public void setTrainsIds(String trainsIds) {
        this.trainsIds = trainsIds;
    }

    public TrainDTO getSelectTrainDTO() {
        return selectedTrainDTO;
    }

    public void setSelectTrainDTO(TrainDTO trainDTO) {
        this.selectedTrainDTO = trainDTO;
    }

    public TrainDTO getSelectedTrainDTO() {
        return selectedTrainDTO;
    }

    public void setSelectedTrainDTO(TrainDTO selectedTrainDTO) {
        this.selectedTrainDTO = selectedTrainDTO;
    }

    public PricingDTO getPricingDTO() {
        return pricingDTO;
    }

    public void setPricingDTO(PricingDTO pricingDTO) {
        this.pricingDTO = pricingDTO;
    }

    public List<TrainDTO> getTrainDTOList() {
        return trainDTOList;
    }

    public void setTrainDTOList(List<TrainDTO> trainDTOList) {
        this.trainDTOList = trainDTOList;
    }
}
