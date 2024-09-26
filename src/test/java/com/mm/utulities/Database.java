package com.mm.utulities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;
    private Connection connection = null;
    private final String DB_URL = "jdbc:sqlserver://server12.efectura.com:1433;databaseName=MEDIAMARKT;encrypt=true;trustServerCertificate=true;";
    private final String DB_USERNAME = "dev_hero";
    private final String DB_PASSWORD = "6KQlSamV4D2x7T9179STCK";

    private Database() {
        try {
            this.connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new Database();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instance.getConnection();
    }

}
