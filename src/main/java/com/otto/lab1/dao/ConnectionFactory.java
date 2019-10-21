package com.otto.lab1.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {

    Connection getH2Connection() throws SQLException;

    Connection getMySQLConnection() throws SQLException;

    Connection getPostgreConnection() throws SQLException;

    Connection getMicrosoftConnection() throws SQLException;

    Connection getMongoDbConnection() throws SQLException;

    Connection getOracleConnection() throws SQLException;


}
