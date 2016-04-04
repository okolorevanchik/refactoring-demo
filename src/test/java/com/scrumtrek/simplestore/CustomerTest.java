package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;


public class CustomerTest {

    @Test
    public void testStatementFiveItems() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Customer custDonaldDuck = new Customer("Donald Duck");
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custDonaldDuck.addRental(rental2);
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMickey = custMickeyMouse.Statement();
        String statementDonald = custDonaldDuck.Statement();
        String statementMinnie = custMinnieMouse.Statement();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.");
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points.");
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points.");
    }


    @Test
    public void testStatementZeroItems() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Customer custDonaldDuck = new Customer("Donald Duck");
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 0);
        Rental rental2 = new Rental(movStarWars, 0);
        Rental rental3 = new Rental(movGladiator, 0);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custDonaldDuck.addRental(rental2);
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMickey = custMickeyMouse.Statement();
        String statementDonald = custDonaldDuck.Statement();
        String statementMinnie = custMinnieMouse.Statement();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points.");
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points.");
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points.");
    }
}