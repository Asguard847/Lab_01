package com.otto.lab1.service.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.factory.impl.SweetnessFactoryImpl;
import com.otto.lab1.model.CandyTypes;
import com.otto.lab1.model.ChocolateTypes;
import com.otto.lab1.model.SweetTypes;
import com.otto.lab1.model.Sweetness;
import com.otto.lab1.service.FindBySugarRangeService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class FindByShugarRangeServiceImplTest {

    SweetnessFactory factory = new SweetnessFactoryImpl();
    FindBySugarRangeService findBySugarRangeService = new FindByShugarRangeServiceImpl();

    List<Sweetness> listForTest = new ArrayList<>();

    @Before
    public void setUp() {

        listForTest.add(factory.getCandy(CandyTypes.CHUPACHUPS));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getChocolate(ChocolateTypes.ALYONKA));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));
        listForTest.add(factory.getSweet(SweetTypes.RAFAELLO));

    }

    @Test
    public void findOneSweetBySugarRangeTest() {

        Sweetness result = findBySugarRangeService.findSweetnessBySugarRange(35, 40, listForTest);

        assertTrue(result.getName().equals("Rafaello"));

    }

    @Test
    public void findSetBySugarRangeTest() {

        Set<Sweetness> resultSet = findBySugarRangeService.findAllSweetnessBySugarRange(35, 55, listForTest);

        boolean containsRafaello = resultSet.stream().anyMatch(sweetness -> sweetness.getName().equals("Rafaello"));
        boolean containsAlyonka = resultSet.stream().anyMatch(sweetness -> sweetness.getName().equals("Alyonka"));

        assertTrue(resultSet.size() == 2);
        assertTrue(containsRafaello);
        assertTrue(containsAlyonka);
    }

}