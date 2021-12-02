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

    public TrainComponent() {
        entitiesUtils = new EntitiesUtils();
        String urlToDB = "jdbc:mysql://localhost:3306/TrainStation";
        String userName = "root";
        String userPassword = "root";
        trainStation = new JDBC(userName, userPassword, urlToDB);
    }

    public ArrayList<Train> getAllTrains() throws SQLException {
        return entitiesUtils.getTrains("SELECT * FROM Train", trainStation);
    }
}
