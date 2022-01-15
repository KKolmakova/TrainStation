package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.RegistrationOnTrainResponseService;
import com.kolmakova.responses.RegistrationOnTrainResponse;
import com.kolmakova.services.impl.PricingServiceImpl;
import com.kolmakova.services.impl.TrainServiceImpl;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationOnTrainResponseServiceImpl implements RegistrationOnTrainResponseService {

    @Autowired
    private TrainServiceImpl trainService;
    @Autowired
    private PricingServiceImpl pricingService;
    @Autowired
    private Converter converter;

    @Override
    public RegistrationOnTrainResponse getResponse(Integer pricingId) {
        RegistrationOnTrainResponse registrationOnTrainResponse = new RegistrationOnTrainResponse();

        PricingDTO pricingDTO = converter.convertToPricingDTO(pricingService.getById(pricingId));
        TrainDTO trainDTO = converter.convertToTrainDTO(getTrain(pricingDTO.getTrainId()));

        registrationOnTrainResponse.setSelectTrainDTO(trainDTO);
        registrationOnTrainResponse.setPricingDTO(pricingDTO);

        return registrationOnTrainResponse;
    }

    private Train getTrain(Integer trainId) {
        return trainService.getById(trainId);
    }
}
