package com.kolmakova.entities;

public class Train {

    private final int id;
    private final int number;
    private final String departureTime;
    private final String arrivalPlace;
    private final String arrivalTime;

    public Train(int id, int number, String departureTime, String arrivalPlace, String arrivalTime) {
        this.id = id;
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalPlace = arrivalPlace;
        this.arrivalTime = arrivalTime;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number=" + number +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalPlace='" + arrivalPlace + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
