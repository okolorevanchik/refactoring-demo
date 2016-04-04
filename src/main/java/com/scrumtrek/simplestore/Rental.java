package com.scrumtrek.simplestore;

import java.util.HashSet;
import java.util.Set;

public class Rental {
    Set<Order> orderSet = new HashSet<>();



    public Rental addOrder(Order o) {
        orderSet.add(o);
        return this;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}

