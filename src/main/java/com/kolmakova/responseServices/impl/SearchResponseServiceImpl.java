package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.SearchResponseService;
import com.kolmakova.responses.TrainResponse;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SearchResponseServiceImpl implements SearchResponseService {

    @Autowired
    private TrainService trainService;
    @Autowired
    private Converter converter;

    @Override
    public TrainResponse getResponse(TrainDTO trainDTO) {
        TrainResponse trainResponse = new TrainResponse();

        List<Train> trains = trainService.getByArrivalPlace(trainDTO.getArrivalPlace());
        List<TrainDTO> trainDTOList = converter.convertToTrainDTOList(trains);

        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        trainResponse.setTrainDTOList(trainDTOList);
        trainResponse.setTrainsIds(trainsIdsUrl);

        return trainResponse;
    }
}
