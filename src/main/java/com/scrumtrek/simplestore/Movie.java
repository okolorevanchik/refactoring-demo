package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.PriceCodes;

/**
 * Class information on film
 */
public class Movie {

    /**
     * Title movie
     */
    private String title;

    /**
     * Price code movie
     */
    private PriceCodes priceCode;

    public Movie(String title, PriceCodes priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCodes getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}

