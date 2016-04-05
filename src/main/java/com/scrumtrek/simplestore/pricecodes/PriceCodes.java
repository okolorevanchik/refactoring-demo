package com.scrumtrek.simplestore.pricecodes;

/**
 * Price codes for movies categories
 */
public enum PriceCodes {
    REGULAR(2.0, 1.5, 2),
    NEW_RELEASE(0.0, 3.0, 0),
    CHILDRENS(1.5, 1.5, 3);

    /**
     * Standard cost of film
     */
    private double startPrice;

    /**
     * The cost of the film depending on the number of rolled days
     */
    private double amountPrice;

    /**
     * Number of rental days
     */
    private int lowCostDaysCount;

    PriceCodes(double startPrice, double amountPrice, int lowCostDaysCount) {
        this.startPrice = startPrice;
        this.amountPrice = amountPrice;
        this.lowCostDaysCount = lowCostDaysCount;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getAmountPrice() {
        return amountPrice;
    }

    public int getLowCostDaysCount() {
        return lowCostDaysCount;
    }
}
