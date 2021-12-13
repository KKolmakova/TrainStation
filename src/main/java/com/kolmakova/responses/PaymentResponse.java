package com.kolmakova.responses;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.dto.PaymentDTO;
import com.kolmakova.dto.TrainDTO;

public class PaymentResponse {

    private PaymentDTO paymentDTO;
    private PassengerDTO passengerDTO;
    private TrainDTO trainDTO;

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
}
