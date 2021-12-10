package com.kolmakova.responseServices;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Check;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;
import com.kolmakova.responses.CheckResponse;
import com.kolmakova.services.CheckService;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CheckResponseService {

    @Autowired
    private CheckService checkService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TrainService trainService;

    public int createCheck(PassengerDTO passengerDTO, int trainId) {
        Passenger passenger = savePassenger(passengerDTO);
        Train train = getTrain(trainId);
        Double amount = 100.0;

        return checkService.saveCheck(getCheck(passenger, train, amount)).getId();
    }

    public CheckResponse getCheckResponse(int checkId) {
        CheckResponse checkResponse = new CheckResponse();
        checkResponse.setPassenger(checkService.getCheckById(checkId).getPassenger());
        checkResponse.setTrain(checkService.getCheckById(checkId).getTrain());

        return checkResponse;
    }

    private Passenger savePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);

        return passengerService.savePassenger(passenger);
    }

    private Train getTrain(int trainId) {
        return trainService.getTrainById(trainId);
    }

    private Check getCheck(Passenger passenger, Train train, double amount) {
        Check check = new Check();
        check.setPassenger(passenger);
        check.setTrain(train);
        check.setAmount(amount);

        return check;
    }
}
