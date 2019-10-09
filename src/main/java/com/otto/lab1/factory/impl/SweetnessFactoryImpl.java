package com.otto.lab1.factory.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.model.*;
import org.springframework.stereotype.Component;

@Component
public class SweetnessFactoryImpl implements SweetnessFactory {

    @Override
    public Candy getCandy(CandyTypes type) {
        Candy candy = new Candy();
        candy.setName(type.getCandyName());
        candy.setWeightInGr(type.getWeightInGr());
        candy.setSugarPerCent(type.getSugarPercent());
        candy.setHasStick(type.isHasStick());
        return candy;
    }

    @Override
    public Sweet getSweet(SweetTypes type) {
        Sweet sweet = new Sweet();
        sweet.setName(type.getSweetName());
        sweet.setWeightInGr(type.getWeightInGr());
        sweet.setSugarPerCent(type.getSugarPercent());
        sweet.setChocolate(type.isChocolate());
        return sweet;
    }

    @Override
    public Chocolate getChocolate(ChocolateTypes type) {
        Chocolate chocolate = new Chocolate();
        chocolate.setName(type.getChocolateName());
        chocolate.setWeightInGr(type.getWeightInGr());
        chocolate.setSugarPerCent(type.getSugarPercent());
        chocolate.setCocoaPercent(type.getCocoaPercent());
        chocolate.setHasFiller(type.isHasFiller());

        return chocolate;
    }
}
