package com.otto.lab1.model;

public abstract class Sweetness {

    protected int id;
    protected String name;
    protected int weightInGr;
    protected double sugarPerCent;
    protected int giftId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightInGr() {
        return weightInGr;
    }

    public void setWeightInGr(int weightInGr) {
        this.weightInGr = weightInGr;
    }

    public double getSugarPerCent() {
        return sugarPerCent;
    }

    public void setSugarPerCent(double sugarPerCent) {
        this.sugarPerCent = sugarPerCent;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }
}
