package com.kolmakova.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class TrainDTO {

    private Integer id;
    private int number;
    private String arrivalPlace;
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private Date departureDate;
    @DateTimeFormat(pattern = "HH:mm", iso = DateTimeFormat.ISO.TIME)
    private Date departureTime;
    private int kilometers;
    private List<PricingDTO> pricingDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public List<PricingDTO> getPricingDTOList() {
        return pricingDTOList;
    }

    public void setPricingDTOList(List<PricingDTO> pricingDTOList) {
        this.pricingDTOList = pricingDTOList;
    }

    @Override
    public String toString() {
        return "TrainDTO{" +
                "id=" + id +
                ", number=" + number +
                ", arrivalPlace='" + arrivalPlace + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime='" + departureTime + '\'' +
                ", kilometers=" + kilometers +
                '}';
    }
}


