package com.kolmakova.dto;

public class PaymentDTO {

    private Integer id;
    private TrainDTO trainDTO;
    private PassengerDTO passengerDTO;
    private double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainDTO getTrainDTO() {
        return trainDTO;
    }

    public void setTrainDTO(TrainDTO trainDTO) {
        this.trainDTO = trainDTO;
    }

    public PassengerDTO getPassengerDTO() {
        return passengerDTO;
    }

    public void setPassengerDTO(PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", trainDTO=" + trainDTO +
                ", passengerDTO=" + passengerDTO +
                ", amount=" + amount +
                '}';
    }
}
