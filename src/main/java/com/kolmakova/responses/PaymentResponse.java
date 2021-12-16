package com.kolmakova.responses;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.PricingDTO;
import com.kolmakova.dto.TrainDTO;

public class PaymentResponse {

    private PaymentDTO paymentDTO;
    private PassengerDTO passengerDTO;
    private TrainDTO trainDTO;
    private PricingDTO pricingDTO;

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    public PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public TrainDTO getTrainDTO() {
        return trainDTO;
    }

    public void setTrainDTO(TrainDTO trainDTO) {
        this.trainDTO = trainDTO;
    }

    public PricingDTO getPricingDTO() {
        return pricingDTO;
    }

    public void setPricingDTO(PricingDTO pricingDTO) {
        this.pricingDTO = pricingDTO;
    }
}
