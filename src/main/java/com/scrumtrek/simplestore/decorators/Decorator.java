package com.scrumtrek.simplestore.decorators;

import com.scrumtrek.simplestore.Customer;

/**
 * The interface is responsible for the
 * generation of information on request
 */
public interface Decorator {

    /**
     * Generating information Method
     *
     * @param customer customer object
     * @return string info
     */
    String generateReport(Customer customer);
}
