package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.ConnectionFactory;
import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class ConnectionFactoryImpl implements ConnectionFactory {

    @Override
    public Connection getH2Connection() throws SQLException {

        String dbUrl = "jdbc:h2:tcp://localhost/~/lab1";
        String username = "sa";
        String password = "";

        JdbcConnectionPool connectionPool =
                JdbcConnectionPool.create(dbUrl, username, password);

        return connectionPool.getConnection();
    }

    @Override
    public Connection getMySQLConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getPostgreConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getMicrosoftConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getMongoDbConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getOracleConnection() throws SQLException {
        return null;
    }


}
