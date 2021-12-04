package com.kolmakova.entities;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Table(appliesTo = "Train")
@Entity
public class Train {

    @Id
    @GeneratedValue
    private int id;
    private int number;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "arrival_place")
    private String arrivalPlace;
    @Column(name = "departure_date")
    private String departureDate;

    public Train() {
    }

    public Train(int id, int number, String departureTime, String arrivalPlace, String departureDate) {
        this.id = id;
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalPlace = arrivalPlace;
        this.departureDate = departureDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number=" + number +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalPlace='" + arrivalPlace + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
