package com.otto.lab1.service.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.factory.impl.SweetnessFactoryImpl;
import com.otto.lab1.model.CandyTypes;
import com.otto.lab1.model.ChocolateTypes;
import com.otto.lab1.model.SweetTypes;
import com.otto.lab1.model.Sweetness;
import com.otto.lab1.service.GiftSortingService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GiftSortingServiceImplTest {

    SweetnessFactory factory = new SweetnessFactoryImpl();
    GiftSortingService giftSortingService = new GiftSortingServiceImpl();

    List<Sweetness> listForTest = new ArrayList<>();

    @Before
    public void setUp() {

        listForTest.add(factory.getCandy(CandyTypes.CHUPACHUPS));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getCandy(CandyTypes.ROSHEN));

    }

    @Test
    public void sortByWeightAscendingTest() {

        List<Sweetness> resultList = giftSortingService.sortByWeightAscendingOrder(listForTest);
        assertTrue(resultList.get(0).getName().equals("Roshen"));

    }

    @Test
    public void sortByWeightDescendingTest() {

        List<Sweetness> resultList = giftSortingService.sortByWeightDescendingOrder(listForTest);
        assertTrue(resultList.get(0).getName().equals("Alyonka"));

    }

    @Test
    public void sortBySugarAscendingTest() {

        List<Sweetness> resultList = giftSortingService.sortBySugarPercentAscendingOrder(listForTest);
        assertTrue(resultList.get(0).getName().equals("Rafaello"));

    }

    @Test
    public void sortBySugarDescendingTest() {

        List<Sweetness> resultList = giftSortingService.sortBySugarPercentDescendingOrder(listForTest);
        assertTrue(resultList.get(0).getName().equals("ChupaChups"));
    }

}