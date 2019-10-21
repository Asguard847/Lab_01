package com.otto.lab1.model;

import java.util.List;

public class NYGift {

    private long GiftId;
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

    public long getGiftId() {
        return GiftId;
    }

    public void setGiftId(long giftId) {
        GiftId = giftId;
    }

    public void setTotalWeightInGr(int totalWeightInGr) {
        this.totalWeightInGr = totalWeightInGr;


    }
}
