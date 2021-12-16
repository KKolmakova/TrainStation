package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.ReceiptsResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReceiptsResponseServiceImpl implements ReceiptsResponseService {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private Converter converter;

    public PaymentResponse getResponse(int passengerId){
        PaymentResponse paymentResponse = new PaymentResponse();

        PassengerDTO passengerDTO = converter.convertToPassengerDTO(passengerService.getPassengerById(passengerId));
        paymentResponse.setPassengerDTO(passengerDTO);

        return paymentResponse;
    }
}
