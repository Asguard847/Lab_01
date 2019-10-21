package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.ConnectionFactory;
import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcConnectionPool;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactoryImpl implements ConnectionFactory {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Connection getH2Connection() throws SQLException {

        Properties properties = new Properties();

        try{
            properties.load(ConnectionFactoryImpl.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            LOG.error("Could not read properties from file");
        }
        JdbcConnectionPool connectionPool =
                JdbcConnectionPool.create(properties.getProperty("DB_URL"),
                        properties.getProperty("DB_USERNAME"),
                        properties.getProperty("DB_PASSWORD"));
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
