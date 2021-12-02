package com.kolmakova.utils;

import com.kolmakova.db.JDBC;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Train;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntitiesUtils {

    public ArrayList<Train> getTrains(String query, JDBC trainStation) throws SQLException {
        ResultSet resultSet = trainStation.executeGetRequest(query);
        ArrayList<Train> trains = new ArrayList<>();
        while (resultSet.next()) {
            Train train = new Train(
                    resultSet.getInt("id"),
                    resultSet.getInt("number"),
                    resultSet.getString("departure_time"),
                    resultSet.getString("arrival_place"),
                    resultSet.getString("arrival_time")
            );
            trains.add(train);
        }
        return trains;
    }

    public ArrayList<Passenger> getPassengers(String query, JDBC trainStation) throws SQLException {
        ResultSet resultSet = trainStation.executeGetRequest(query);
        ArrayList<Passenger> passengers = new ArrayList<>();
        while (resultSet.next()) {
            Passenger passenger = new Passenger(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("sex"),
                    resultSet.getString("birth_date"),
                    resultSet.getString("document_type"),
                    resultSet.getString("document_series")
            );

            passengers.add(passenger);
        }
        return passengers;
    }
}