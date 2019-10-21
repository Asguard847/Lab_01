package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.ConnectionFactory;
import com.otto.lab1.dao.NyGiftDao;
import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.Sweetness;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class NyGiftDaoImplTest {

    ConnectionFactory connectionFactory;
    Connection connection;
    NyGiftDao nyGiftDao;

    @Before
    public void setUp() throws SQLException {
        connectionFactory = new ConnectionFactoryImpl();
        connection = connectionFactory.getH2Connection();
        nyGiftDao = new NyGiftDaoImpl(new CandyDaoImpl(connection),
                new ChocolateDaoImpl(connection), new SweetDaoImpl(connection));
    }


    @Test
    public void getGiftTest(){

        NYGift gift = nyGiftDao.getNYGift(5, connection);
        List<Sweetness> sweetnesses = gift.getGiftContents();

        assertNotNull(gift);
        assertTrue(sweetnesses.size()!=0);

    }

}