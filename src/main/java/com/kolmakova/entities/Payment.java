package com.kolmakova.entities;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_id")
    private Pricing pricing;

    @Column(name = "amount")
    private double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public static Builder builder(){
        return new Payment().new Builder();
    }

    public class Builder {

        private Builder() { }

        public Builder setId(Integer id){
            Payment.this.id = id;
            return this;
        }

        public Builder setTrain(Train train){
            Payment.this.train = train;
            return this;
        }

        public Builder setPassenger(Passenger passenger){
            Payment.this.passenger = passenger;
            return this;
        }

        public Builder setPricing(Pricing pricing){
            Payment.this.pricing = pricing;
            return this;
        }

        public Builder setAmount(Double amount){
            Payment.this.amount = amount;
            return this;
        }

        public Payment build(){
            return Payment.this;
        }
    }
}
