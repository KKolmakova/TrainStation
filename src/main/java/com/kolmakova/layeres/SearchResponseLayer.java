package com.kolmakova.layeres;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.dto.TrainSearchRequest;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchResponseLayer {

    @Autowired
    private TrainService trainService;

    public SearchForm getSearchForm(TrainSearchRequest trainSearchRequest) {
        List<Train> trains = trainService.getByArrivalPlace(trainSearchRequest.getArrivalPlace());
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Train train : trains) {
            TrainDTO trainDTO = new TrainDTO();
            BeanUtils.copyProperties(train, trainDTO);
            trainDTOList.add(trainDTO);
        }

        String trainsIdsUrl = trainService.getSelectedTrainsUrl(trains);

        SearchForm searchForm = new SearchForm();
        searchForm.setTrainDTOList(trainDTOList);
        searchForm.setTrainsIds(trainsIdsUrl);

        return searchForm;
    }
}
