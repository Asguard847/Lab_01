package com.otto.lab1.dao;

import com.otto.lab1.model.NYGift;

public interface NyGiftDao {

    void persistNyGift(NYGift gift);

    NYGift getNYGift();

}
