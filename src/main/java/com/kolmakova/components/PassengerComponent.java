package com.kolmakova.components;

import com.kolmakova.db.JDBC;
import com.kolmakova.entities.Passenger;
import com.kolmakova.utils.EntitiesUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class PassengerComponent {

    private final EntitiesUtils entitiesUtils;
    private final JDBC trainStation;

    public PassengerComponent() {
        entitiesUtils = new EntitiesUtils();
        String urlToDB = "jdbc:mysql://localhost:3306/TrainStation";
        String userName = "root";
        String userPassword = "root";
        trainStation = new JDBC(userName, userPassword, urlToDB);
    }

    public ArrayList<Passenger> getAllPassengers() throws SQLException {
        return entitiesUtils.getPassengers("SELECT * FROM Passenger", trainStation);
    }

    public void save(Passenger passenger) throws SQLException {
        trainStation.executeSetRequest("INSERT INTO Passenger(name, surname, sex, birth_date, document_type, " +
                "document_series) VALUES('".concat(passenger.getName()) + "','"
                .concat(passenger.getSurname()) + "','"
                .concat(passenger.getSex()) + "','"
                .concat(passenger.getBirthDate()) + "','"
                .concat(passenger.getDocumentType()) + "','"
                .concat(passenger.getDocumentSeries()) + "');");
    }
}
