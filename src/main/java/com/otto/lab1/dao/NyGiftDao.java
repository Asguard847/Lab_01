package com.otto.lab1.dao;

import com.otto.lab1.model.NYGift;

import java.sql.Connection;

public interface NyGiftDao {

    int persistNyGift(NYGift gift, Connection connection);

    NYGift getNYGift(int id, Connection connection);

}
