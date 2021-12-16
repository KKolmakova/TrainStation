package com.kolmakova.dto;

import com.kolmakova.entities.Pricing;

import java.sql.Date;
import java.util.List;

public class TrainDTO {

    private Integer id;
    private int number;
    private String arrivalPlace;
    private Date departureDate;
    private String departureTime;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
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


