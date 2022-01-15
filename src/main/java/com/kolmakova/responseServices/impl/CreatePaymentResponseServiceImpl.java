package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;
import com.kolmakova.entities.*;
import com.kolmakova.responseServices.CreatePaymentResponseService;
import com.kolmakova.responses.PaymentResponse;
import com.kolmakova.services.*;
import com.kolmakova.utils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CreatePaymentResponseServiceImpl implements CreatePaymentResponseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreatePaymentResponseServiceImpl.class);

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private PricingService pricingService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private Converter converter;

    @Override
    public PaymentResponse create(PassengerDTO passengerDTO, int trainId, int pricingId) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Passenger passenger = savePassenger(passengerDTO);
        addPassengerToCurrentAccount(passenger);

        Train train = getTrain(trainId);

        Pricing pricing = pricingService.getById(pricingId);
        Double amount = pricing.getPrice();

        savePricing(pricing);

        Payment payment = Payment.builder()
                .setPassenger(passenger)
                .setTrain(train)
                .setPricing(pricing)
                .setAmount(amount)
                .build();

        paymentService.save(payment);
        PaymentDTO savedPaymentDTO = converter.convertToPaymentDTO(payment);

        paymentResponse.setPaymentDTO(savedPaymentDTO);

        return paymentResponse;
    }

    @Override
    public PaymentResponse getResponse(int paymentId) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Payment payment = paymentService.getById(paymentId);

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
        Passenger passenger = converter.convertToPassenger(passengerDTO);
        Optional<Document> document = documentService.getByType(passengerDTO.getDocumentDTO().getType());

        passenger.setDocumentType(document.orElse(null));
        return passengerService.save(passenger);
    }

    private void addPassengerToCurrentAccount(Passenger passenger) {
        User authenticated = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Account> accountOptional = accountService.getOne(authenticated.getUsername());

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Passenger> passengers = account.getPassengers();
            passengers.add(passenger);

            account.setPassengers(passengers);
            accountService.save(account);
        } else {
            LOGGER.error("Can't find account for user with login: {}", authenticated.getUsername());
        }
    }

    private void savePricing(Pricing pricing) {
        pricing.setSeatsNumber(pricing.getSeatsNumber() - 1);
        pricingService.save(pricing);
    }

    private Train getTrain(int trainId) {
        return trainService.getById(trainId);
    }
}
