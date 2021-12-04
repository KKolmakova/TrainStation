package com.kolmakova.components;

import com.kolmakova.db.JDBC;
import com.kolmakova.entities.Train;
import com.kolmakova.utils.EntitiesUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class TrainComponent {

    private final EntitiesUtils entitiesUtils;
    private final JDBC trainStation;
    private ArrayList<Train> trains;

    public TrainComponent() throws SQLException {
        entitiesUtils = new EntitiesUtils();
        String urlToDB = "jdbc:mysql://localhost:3306/TrainStation";
        String userName = "root";
        String userPassword = "root";
        trainStation = new JDBC(userName, userPassword, urlToDB);
        trains = entitiesUtils.getTrains("SELECT * FROM Train", trainStation);
    }

    public ArrayList<Train> getAllTrains() throws SQLException {
        return trains;
    }

    public ArrayList<Train> findSelectedTrains(Train train) throws SQLException {
        trains = entitiesUtils.getTrains("SELECT * FROM Train WHERE arrival_place='".concat(train.getArrivalPlace()) + "'", trainStation);
        return trains;
    }
}
