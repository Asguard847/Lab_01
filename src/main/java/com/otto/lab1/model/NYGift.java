package com.otto.lab1.model;

import java.util.List;

public class NYGift {

    private List<Sweetness> giftContents;
    private int totalWeightInGr;

    public List<Sweetness> getGiftContents() {
        return giftContents;
    }

    public void setGiftContents(List<Sweetness> giftContents) {
        this.giftContents = giftContents;
    }

    public int getTotalWeightInGr() {
        return totalWeightInGr;
    }

    public void setTotalWeightInGr(int totalWeightInGr) {
        this.totalWeightInGr = totalWeightInGr;
    }
}
