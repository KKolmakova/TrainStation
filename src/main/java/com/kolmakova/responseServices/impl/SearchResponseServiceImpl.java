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
        List<Train> trains = trainService.getByArrivalPlace(trainDTO.getArrivalPlace());
        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        return getTrainResponse(trains, trainsIdsUrl);
    }

    private TrainResponse getTrainResponse(List<Train> trains, String trainsIdsUrl) {
        TrainResponse trainResponse = new TrainResponse();
        trainResponse.setTrainDTOList(converter.convertToTrainDTOList(trains));
        trainResponse.setTrainsIds(trainsIdsUrl);

        return trainResponse;
    }
}
