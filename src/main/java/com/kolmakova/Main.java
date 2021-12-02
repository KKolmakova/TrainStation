package com.kolmakova;

import com.kolmakova.execute.Execute;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Execute().getUsers();
    }
}
