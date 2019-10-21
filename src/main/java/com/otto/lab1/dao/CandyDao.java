package com.otto.lab1.dao;

import com.otto.lab1.model.Candy;
import com.otto.lab1.model.Sweetness;

import java.util.List;

public interface CandyDao {

    void persistCandys(List<Sweetness> sweetnesses, int giftId);

    void updateCandy(Candy candy);

    void deleteCandy(int id);

    List<Candy> getCandysByGiftId(int id);

}
