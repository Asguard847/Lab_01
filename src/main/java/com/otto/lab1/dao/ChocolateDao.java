package com.otto.lab1.dao;

import com.otto.lab1.model.Chocolate;
import com.otto.lab1.model.Sweetness;

import java.util.List;

public interface ChocolateDao {

    void persistChocolates(List<Sweetness> sweetnesses, int giftId);

    void updateChocolate(Chocolate chocolate);

    void deleteChocolate(int id);

    List<Chocolate> getChocolatesByGiftId(int id);
}
