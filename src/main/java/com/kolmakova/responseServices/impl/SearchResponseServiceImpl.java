package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Pricing;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.SearchResponseService;
import com.kolmakova.responses.RegistrationOnTrainResponse;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchResponseServiceImpl implements SearchResponseService {

    @Autowired
    private TrainService trainService;
    @Autowired
    private Converter converter;

    @Override
    public RegistrationOnTrainResponse getResponse(TrainDTO trainDTO) {
        RegistrationOnTrainResponse registrationOnTrainResponse = new RegistrationOnTrainResponse();

//        List<Train> trains = trainService.getByArrivalPlace(trainDTO.getArrivalPlace());
        List<Train> trains = trainService.getByParameters(trainDTO.getArrivalPlace(), trainDTO.getDepartureDate(), trainDTO.getDepartureTime());
        List<TrainDTO> trainDTOList = getTrainsWithFreePlaces(converter.convertToTrainDTOList(trains));

        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        registrationOnTrainResponse.setTrainDTOList(trainDTOList);
        registrationOnTrainResponse.setTrainsIds(trainsIdsUrl);

        return registrationOnTrainResponse;
    }

    private List<TrainDTO> getTrainsWithFreePlaces(List<TrainDTO> trainDTOList) {
        List<TrainDTO> trainsWithFreeSeats = new ArrayList<>();

        for (TrainDTO train : trainDTOList) {
            List<PricingDTO> pricingList = train.getPricingDTOList();
            List<PricingDTO> pricingWithFreeSeats = new ArrayList<>();

            for (PricingDTO pricing : pricingList) {
                if (pricing.getSeatsNumber() > 0) {
                    pricingWithFreeSeats.add(pricing);
                }
            }

            if (!pricingWithFreeSeats.isEmpty()) {
                train.setPricingDTOList(pricingWithFreeSeats);
                trainsWithFreeSeats.add(train);
            }
        }

        return trainsWithFreeSeats;
    }
}
