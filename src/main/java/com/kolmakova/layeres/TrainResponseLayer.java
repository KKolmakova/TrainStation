package com.kolmakova.layeres;

import com.kolmakova.dto.TrainDTO;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainResponseLayer {

    @Autowired
    private TrainService trainService;

    public TrainForm createRegisterPassenger(Integer trainId, List<Integer> trainsIds) {
        List<TrainDTO> trainDTOList = new ArrayList<>();

        for (Integer id : trainsIds) {
            TrainDTO trainDTO = new TrainDTO();
            trainDTO.setId(id);
            trainDTOList.add(trainDTO);
        }

        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setId(trainId);

        TrainForm trainForm = new TrainForm();
        trainForm.setSelectTrainDTO(trainDTO);
        trainForm.setTrainDTOList(trainDTOList);
        trainForm.setTrainsIds(trainService.getSelectedTrainsUrl(trainService.getTrainsByIds(trainsIds)));

        return trainForm;
    }
}
