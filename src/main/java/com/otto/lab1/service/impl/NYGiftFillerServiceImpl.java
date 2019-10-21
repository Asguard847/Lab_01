package com.otto.lab1.service.impl;

import com.otto.lab1.factory.SweetnessFactory;
import com.otto.lab1.factory.impl.SweetnessFactoryImpl;
import com.otto.lab1.model.*;
import com.otto.lab1.service.NYGiftFillerService;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NYGiftFillerServiceImpl implements NYGiftFillerService {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private NYGift nyGift;
    private SweetnessFactory factory = new SweetnessFactoryImpl();
    private Random random = new Random();

    @Override
    public NYGift fillTheGift() {

        nyGift = new NYGift();
        List<Sweetness> giftContents = new ArrayList<>();
        giftContents.addAll(addSweets());
        giftContents.addAll(addChocolates());
        giftContents.addAll(addCandies());

        nyGift.setGiftContents(giftContents);
        nyGift.setTotalWeightInGr(findWeight(giftContents));

        LOG.info("The gift is ready!");

        return nyGift;

    }

    private List<Sweet> addSweets() {

        List<Sweet> sweets = new ArrayList<>();
        SweetTypes[] sweetTypes = SweetTypes.values();

        for (int i = 0; i < 50; i++) {
            int randomVal = random.nextInt(4);
            sweets.add(factory.getSweet(sweetTypes[randomVal]));
        }
        return sweets;
    }

    private List<Chocolate> addChocolates() {

        List<Chocolate> chocolates = new ArrayList<>();
        ChocolateTypes[] chocolateTypes = ChocolateTypes.values();

        for (int i = 0; i < 10; i++) {
            int randomVal = random.nextInt(3);
            chocolates.add(factory.getChocolate(chocolateTypes[randomVal]));
        }

        return chocolates;
    }

    private List<Candy> addCandies() {

        List<Candy> candies = new ArrayList<>();
        CandyTypes[] candyTypes = CandyTypes.values();

        for (int i = 0; i < 20; i++) {
            int randomVal = random.nextInt(2);
            candies.add(factory.getCandy(candyTypes[randomVal]));
        }
        return candies;
    }

    private int findWeight(List<Sweetness> giftContents) {

        int totalWeightInGr = giftContents.stream().mapToInt(sweetness -> sweetness.getWeightInGr()).sum();
        return totalWeightInGr;
    }
}
