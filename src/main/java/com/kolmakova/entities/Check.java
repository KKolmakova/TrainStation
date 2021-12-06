package com.kolmakova.entities;

import org.hibernate.annotations.Table;

import javax.persistence.*;

//@Table(appliesTo = "Check")
//@Entity
//public class Check {
//
//    @Id
//    @GeneratedValue
//    private int id;
//    @OneToMany
//    @JoinColumn(name = "train_id")
//    private String trainId;
//    @OneToMany
//    @JoinColumn(name = "passenger_id")
//    private String passengerId;
//    @Column(name = "amount")
//    private Double amount;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTrainId() {
//        return trainId;
//    }
//
//    public void setTrainId(String trainId) {
//        this.trainId = trainId;
//    }
//
//    public String getPassengerId() {
//        return passengerId;
//    }
//
//    public void setPassengerId(String passengerId) {
//        this.passengerId = passengerId;
//    }
//
//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//}
