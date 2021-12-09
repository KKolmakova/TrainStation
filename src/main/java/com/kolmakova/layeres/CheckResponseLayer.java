package com.kolmakova.layeres;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.entities.Check;
import com.kolmakova.entities.Passenger;
import com.kolmakova.services.CheckService;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.TrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CheckResponseLayer {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private TrainService trainService;

    public int createCheckForm(PassengerDTO passengerDTO, int trainId) {
        Check check = new Check();

        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDTO, passenger);

        Passenger savedPassenger =  passengerService.savePassenger(passenger);
        check.setPassenger(savedPassenger);
        check.setTrain(trainService.getTrainById(trainId));
        check.setAmount(100.0);

       Check saved =  checkService.saveCheck(check);
//        check.setPassenger(savePassenger(passengerDTO));
//        check.setTrain(trainService.getTrainById(trainId));
//        check.setAmount(100.00);
//        checkService.saveCheck(check);

        return trainId;
    }

}
