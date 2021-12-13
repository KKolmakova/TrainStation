package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.TrainResponseService;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainResponseServiceImpl implements TrainResponseService {

    @Autowired
    private TrainService trainService;
    @Autowired
    private Converter converter;

    @Override
    public TrainResponse getResponse(Integer trainId, List<Integer> trainsIds) {
        TrainResponse trainResponse = new TrainResponse();

        TrainDTO trainDTO = converter.convertToTrainDTO(getTrain(trainId));
        List<TrainDTO> trainDTOList = getTrainDTOList(trainsIds);
        String trainsUrl = trainService.getSelectedTrainsUrl(trainService.getTrainsByIds(trainsIds));

        trainResponse.setSelectTrainDTO(trainDTO);
        trainResponse.setTrainDTOList(trainDTOList);
        trainResponse.setTrainsIds(trainsUrl);

        return trainResponse;
    }

    private Train getTrain(Integer trainId) {
        return trainService.getTrainById(trainId);
    }

    private List<TrainDTO> getTrainDTOList(List<Integer> trainsIds) {
        List<Train> trainList = trainService.getTrainsByIds(trainsIds);

        return converter.convertToTrainDTOList(trainList);
    }
}
