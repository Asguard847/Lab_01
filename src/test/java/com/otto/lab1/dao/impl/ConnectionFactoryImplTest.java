package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.ConnectionFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionFactoryImplTest {


    ConnectionFactory connectionFactory = new ConnectionFactoryImpl();

    @Test
    public void testH2Connection() throws SQLException {
        assertNotNull(connectionFactory.getH2Connection());
    }

}