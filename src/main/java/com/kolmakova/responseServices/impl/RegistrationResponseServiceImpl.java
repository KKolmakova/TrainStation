package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.RegistrationResponseService;
import com.kolmakova.responses.RegistrationOnTrainResponse;
import com.kolmakova.services.impl.PricingServiceImpl;
import com.kolmakova.services.impl.TrainServiceImpl;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationResponseServiceImpl implements RegistrationResponseService {

    @Autowired
    private TrainServiceImpl trainService;
    @Autowired
    private PricingServiceImpl pricingService;
    @Autowired
    private Converter converter;

    @Override
    public RegistrationOnTrainResponse getResponse(Integer pricingId) {
        RegistrationOnTrainResponse registrationOnTrainResponse = new RegistrationOnTrainResponse();

        PricingDTO pricingDTO = converter.convertToPricingDTO(pricingService.getOne(pricingId));
        TrainDTO trainDTO = converter.convertToTrainDTO(getTrain(pricingDTO.getTrainId()));

        registrationOnTrainResponse.setSelectTrainDTO(trainDTO);
        registrationOnTrainResponse.setPricingDTO(pricingDTO);

        return registrationOnTrainResponse;
    }

    private Train getTrain(Integer trainId) {
        return trainService.getOne(trainId);
    }

    private List<TrainDTO> getTrainDTOList(List<Integer> trainsIds) {
        List<Train> trainList = trainService.findByIds(trainsIds);

        return converter.convertToTrainDTOList(trainList);
    }
}
