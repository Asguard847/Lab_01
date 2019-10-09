package com.otto.lab1.factory.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class SweetnessFactoryImplTest {

    SweetnessFactory factory = new SweetnessFactoryImpl();

    @Test
    public void returnSweetTest() {

        Sweet sweet = factory.getSweet(SweetTypes.KOROVKA);

        assertTrue(sweet.getName().equals("Korovka"));
        assertTrue(sweet.getWeightInGr() == 15);
        assertTrue(sweet.getSugarPerCent() == 81.8d);
        assertTrue(!sweet.isChocolate());
    }

    @Test
    public void returnCandyTest() {

        Candy candy = factory.getCandy(CandyTypes.CHUPACHUPS);

        assertTrue(candy.getName().equals("ChupaChups"));
        assertTrue(candy.getWeightInGr() == 30);
        assertTrue(candy.getSugarPerCent() == 97.8d);
        assertTrue(candy.isHasStick());
    }

    @Test
    public void returnChocolateTest() {

        Chocolate chocolate = factory.getChocolate(ChocolateTypes.ALYONKA);

        assertTrue(chocolate.getName().equals("Alyonka"));
        assertTrue(chocolate.getWeightInGr() == 100);
        assertTrue(chocolate.getSugarPerCent() == 54d);
        assertTrue(chocolate.getCocoaPercent() == 34.9d);
        assertTrue(!chocolate.isHasFiller());
    }

}