package com.otto.lab1.service.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.factory.impl.SweetnessFactoryImpl;
import com.otto.lab1.model.*;
import com.otto.lab1.service.UserIOService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class UserIOServiceImplTest {

    List<Sweetness> listForTest = new ArrayList<>();
    SweetnessFactory factory = new SweetnessFactoryImpl();
    UserIOService userIOService = new UserIOServiceImpl();
    int totalWeight;
    NYGift nyGift = new NYGift();

    @Before
    public void setUp() {

        listForTest.add(factory.getCandy(CandyTypes.CHUPACHUPS));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));

        nyGift.setGiftContents(listForTest);
        totalWeight = listForTest.stream().mapToInt(Sweetness::getWeightInGr).sum();
        nyGift.setTotalWeightInGr(totalWeight);

    }

    @Test
    public void getUserOutputDisplayModelTest() {

        UserOutputDisplayModel model = userIOService.getUserOutputDisplayModel(nyGift, 35, 55);

        assertTrue(model.getCandyChupaChups() == 1);
        assertTrue(model.getChocolateAlyonka() == 2);
        assertTrue(model.getSweetRafaello() == 3);


    }


}