package com.otto.lab1.service.impl;

import com.otto.lab1.model.NYGift;
import com.otto.lab1.service.NYGiftFillerService;
import org.junit.Test;

import static org.junit.Assert.*;

public class NYGiftFillerServiceImplTest {

    NYGiftFillerService nyGiftFillerService = new NYGiftFillerServiceImpl();

    @Test
    public void giftFillerTest() {

        NYGift nyGift = nyGiftFillerService.fillTheGift();

        assertTrue(nyGift.getTotalWeightInGr() != 0);
        assertTrue(!nyGift.getGiftContents().isEmpty());
        assertTrue(nyGift.getGiftContents().size() == 80);
        assertTrue(!nyGift.getGiftContents().contains(null));

    }

}