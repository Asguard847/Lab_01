package com.otto.lab1.dao;

import com.otto.lab1.model.Sweet;
import com.otto.lab1.model.Sweetness;

import java.util.List;

public interface SweetDao {

    void persistSweets(List<Sweetness> sweetnesses, int giftId);

    void updateSweet(Sweet sweet);

    void deleteSweet(int id);

    List<Sweet> getSweetsByGiftId(int id);
}
