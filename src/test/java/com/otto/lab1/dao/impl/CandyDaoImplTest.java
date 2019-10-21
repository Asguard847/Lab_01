package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.CandyDao;
import com.otto.lab1.dao.ConnectionFactory;
import com.otto.lab1.model.Candy;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;

public class CandyDaoImplTest {

    ConnectionFactory connectionFactory;
    Connection connection;
    CandyDao candyDao;

    @Before
    public void setUp() throws SQLException {

        connectionFactory = new ConnectionFactoryImpl();
        connection = connectionFactory.getH2Connection();
        candyDao = new CandyDaoImpl(connection);

    }

    @Test
    public void getCandysByGiftId() {

        List<Candy> candies = candyDao.getCandysByGiftId(5);
        assertTrue(candies.size()!=0);
    }
}
