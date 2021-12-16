package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.RegistrationResponseService;
import com.kolmakova.responses.RegistrationOnTrainResponse;
import com.kolmakova.services.PricingService;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationResponseServiceImpl implements RegistrationResponseService {

    @Autowired
    private TrainService trainService;
    @Autowired
    private PricingService pricingService;
    @Autowired
    private Converter converter;

    @Override
    public RegistrationOnTrainResponse getResponse(Integer trainId, Integer pricingId, List<Integer> trainsIds) {
        RegistrationOnTrainResponse registrationOnTrainResponse = new RegistrationOnTrainResponse();

        TrainDTO trainDTO = converter.convertToTrainDTO(getTrain(trainId));
        List<TrainDTO> trainDTOList = getTrainDTOList(trainsIds);
        PricingDTO pricingDTO = converter.convertToPricingDTO(pricingService.getPricingById(pricingId));
        String trainsUrl = trainService.getSelectedTrainsUrl(trainService.getTrainsByIds(trainsIds));

        registrationOnTrainResponse.setSelectTrainDTO(trainDTO);
        registrationOnTrainResponse.setTrainDTOList(trainDTOList);
        registrationOnTrainResponse.setPricingDTO(pricingDTO);
        registrationOnTrainResponse.setTrainsIds(trainsUrl);

        return registrationOnTrainResponse;
    }

    private Train getTrain(Integer trainId) {
        return trainService.getTrainById(trainId);
    }

    private List<TrainDTO> getTrainDTOList(List<Integer> trainsIds) {
        List<Train> trainList = trainService.getTrainsByIds(trainsIds);

        return converter.convertToTrainDTOList(trainList);
    }
}
