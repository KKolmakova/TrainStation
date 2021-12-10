package com.kolmakova.responseServices;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainResponseService {

    @Autowired
    private TrainService trainService;

    public TrainResponse createRegisterPassenger(Integer trainId, List<Integer> trainsIds) {
        List<TrainDTO> trainDTOList = getTrainDTOList(trainsIds);

        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setId(trainId);

        return getTrainResponse(trainsIds, trainDTOList, trainDTO);
    }

    private TrainResponse getTrainResponse(List<Integer> trainsIds, List<TrainDTO> trainDTOList, TrainDTO trainDTO) {
        TrainResponse trainResponse = new TrainResponse();

        trainResponse.setSelectTrainDTO(trainDTO);
        trainResponse.setTrainDTOList(trainDTOList);
        trainResponse.setTrainsIds(trainService.getSelectedTrainsUrl(trainService.getTrainsByIds(trainsIds)));

        return trainResponse;
    }

    private List<TrainDTO> getTrainDTOList(List<Integer> trainsIds) {
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Integer id : trainsIds) {
            TrainDTO trainDTO = new TrainDTO();
            trainDTO.setId(id);
            trainDTOList.add(trainDTO);
        }

        return trainDTOList;
    }
}
