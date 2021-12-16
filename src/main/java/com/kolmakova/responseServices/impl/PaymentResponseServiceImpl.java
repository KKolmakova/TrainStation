package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.entities.Pricing;
import com.kolmakova.entities.Train;
import com.kolmakova.responseServices.PaymentResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PaymentService;
import com.kolmakova.services.PricingService;
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
    private PricingService pricingService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentResponse create(PassengerDTO passengerDTO, int trainId, int pricingId) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Passenger passenger = savePassenger(passengerDTO);
        Train train = getTrain(trainId);

        Pricing pricing = pricingService.getPricingById(pricingId);
        Double amount = pricing.getPrice();

        savePricing(pricing);

        Payment payment = Payment.builder()
                .setPassenger(passenger)
                .setTrain(train)
                .setPricing(pricing)
                .setAmount(amount)
                .build();

        paymentService.savePayment(payment);
        PaymentDTO savedPaymentDTO = converter.convertToPaymentDTO(payment);

        paymentResponse.setPaymentDTO(savedPaymentDTO);

        return paymentResponse;
    }

    @Override
    public PaymentResponse getResponse(int paymentId) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Payment payment = paymentService.getPaymentById(paymentId);

        PaymentDTO paymentDTO = converter.convertToPaymentDTO(payment);
        PassengerDTO passengerDTO = converter.convertToPassengerDTO(payment.getPassenger());
        TrainDTO trainDTO = converter.convertToTrainDTO(payment.getTrain());
        PricingDTO pricingDTO = converter.convertToPricingDTO(payment.getPricing());

        paymentResponse.setPassengerDTO(passengerDTO);
        paymentResponse.setTrainDTO(trainDTO);
        paymentResponse.setPaymentDTO(paymentDTO);
        paymentResponse.setPricingDTO(pricingDTO);

        return paymentResponse;
    }

    private Passenger savePassenger(PassengerDTO passengerDTO) {
        return passengerService.savePassenger(converter.convertToPassenger(passengerDTO));
    }

    private void savePricing(Pricing pricing) {
        pricing.setSeatsNumber(pricing.getSeatsNumber() - 1);
        pricingService.savePricing(pricing);
    }

    private Train getTrain(int trainId) {
        return trainService.getTrainById(trainId);
    }
}
