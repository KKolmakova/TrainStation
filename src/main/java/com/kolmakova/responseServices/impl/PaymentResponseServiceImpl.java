package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.PaymentResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.services.TrainService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentResponseServiceImpl implements PaymentResponseService {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentResponse create(PassengerDTO passengerDTO, int trainId) {
        Passenger passenger = savePassenger(passengerDTO);
        Train train = getTrain(trainId);
        Double amount = 100.0;

        Payment payment = Payment.builder()
                .setPassenger(passenger)
                .setTrain(train)
                .setAmount(amount)
                .build();

        PaymentResponse paymentResponse = new PaymentResponse();

        PaymentDTO savedPaymentDTO = converter.convertToPaymentDTO(paymentService.savePayment(payment));
        paymentResponse.setPaymentDTO(savedPaymentDTO);

        return paymentResponse;
    }

    @Override
    public PaymentResponse getResponse(int paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);

        PaymentResponse paymentResponse = new PaymentResponse();

        paymentResponse.setPassengerDTO(converter.convertToPassengerDTO(payment.getPassenger()));
        paymentResponse.setTrainDTO(converter.convertToTrainDTO(payment.getTrain()));
        paymentResponse.setPaymentDTO(converter.convertToPaymentDTO(payment));

        return paymentResponse;
    }

    private Passenger savePassenger(PassengerDTO passengerDTO) {
        return passengerService.savePassenger(converter.convertToPassenger(passengerDTO));
    }

    private Train getTrain(int trainId) {
        return trainService.getTrainById(trainId);
    }
}
