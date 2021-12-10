package com.kolmakova.responseServices;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.dto.TrainSearchRequest;
import com.kolmakova.entities.Train;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchResponseService {

    @Autowired
    private TrainService trainService;

    public TrainResponse getTrainResponse(TrainSearchRequest trainSearchRequest) {
        List<Train> trains = trainService.getByArrivalPlace(trainSearchRequest.getArrivalPlace());
        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        return getTrainResponse(trains, trainsIdsUrl);
    }

    private TrainResponse getTrainResponse(List<Train> trains, String trainsIdsUrl) {
        TrainResponse trainResponse = new TrainResponse();
        trainResponse.setTrainDTOList(getTrainDTOList(trains));
        trainResponse.setTrainsIds(trainsIdsUrl);

        return trainResponse;
    }

    private List<TrainDTO> getTrainDTOList(List<Train> trains){
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Train train : trains) {
            TrainDTO trainDTO = new TrainDTO();
            BeanUtils.copyProperties(train, trainDTO);
            trainDTOList.add(trainDTO);
        }

        return trainDTOList;
    }
}
