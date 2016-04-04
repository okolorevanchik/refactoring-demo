package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;


public class CustomerTest {

    @Test
    public void testStatementFiveItemsRegular() throws Exception {
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental().addOrder(new Order(movStarWars, 5));

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        String statementDonald = custDonaldDuck.StatementString();

        // Print the statement
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementFiveItemsChildren() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental().addOrder(new Order(movCinderella, 5));


        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        String statementMickey = custMickeyMouse.StatementString();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementFiveItemsNewRelease() throws Exception {
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental3 = new Rental().addOrder(new Order(movGladiator, 5));

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMinnie = custMinnieMouse.StatementString();

        // Print the statement
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points.");
    }

    @Test
    public void testStatementZeroChildren() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental().addOrder(new Order(movCinderella, 0));

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        String statementMickey = custMickeyMouse.StatementString();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementZeroRegular() throws Exception {
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck");

        // Create rentals
        Rental rental2 = new Rental().addOrder(new Order(movStarWars, 0));

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        String statementDonald = custDonaldDuck.StatementString();

        // Print the statement
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementZeroNewRelease() throws Exception {
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental3 = new Rental().addOrder(new Order(movGladiator, 0));

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMinnie = custMinnieMouse.StatementString();

        // Print the statement
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points.");
    }
}