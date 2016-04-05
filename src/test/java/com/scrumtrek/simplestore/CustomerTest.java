package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.PriceCodes;
import com.scrumtrek.simplestore.reports.JsonReportGenerator;
import com.scrumtrek.simplestore.reports.StringReportGenerator;
import org.junit.Assert;
import org.junit.Test;


public class CustomerTest {

    @Test
    public void testStatementFiveItemsRegularJson() throws Exception {
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck", new JsonReportGenerator());

        // Create rentals
        Rental rental2 = new Rental(5);
        rental2.addMovie(movStarWars);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        Assert.assertEquals("{\n" +
                "  \"nameCustomer\": \"Donald Duck\",\n" +
                "  \"movieMap\": {\n" +
                "    \"Star Wars\": 3.5\n" +
                "  },\n" +
                "  \"totalAmount\": 3.5,\n" +
                "  \"frequentRenterPoints\": 1\n" +
                "}", custDonaldDuck.statement());
    }

    @Test
    public void testStatementFiveItemsRegular() throws Exception {
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck", new StringReportGenerator());

        // Create rentals
        Rental rental2 = new Rental(5);
        rental2.addMovie(movStarWars);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        String statementDonald = custDonaldDuck.statement();

        // Print the statement
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementFiveItemsChildren() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);
        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental1 = new Rental(5);
        rental1.addMovie(movCinderella);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        String statementMickey = custMickeyMouse.statement();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementFiveItemsNewRelease() throws Exception {
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental3 = new Rental(5);
        rental3.addMovie(movGladiator);

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMinnie = custMinnieMouse.statement();

        // Print the statement
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementZeroChildren() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental1 = new Rental(0);
        rental1.addMovie(movCinderella);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Generate invoice
        String statementMickey = custMickeyMouse.statement();

        // Print the statement
        Assert.assertEquals(statementMickey, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementZeroRegular() throws Exception {
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck", new StringReportGenerator());

        // Create rentals
        Rental rental2 = new Rental(0);
        rental2.addMovie(movStarWars);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Generate invoice
        String statementDonald = custDonaldDuck.statement();

        // Print the statement
        Assert.assertEquals(statementDonald, "Rental record for Donald Duck\n" +
                "\tStar Wars\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points.");
    }

    @Test
    public void testStatementZeroNewRelease() throws Exception {
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental3 = new Rental(0);
        rental3.addMovie(movGladiator);

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Generate invoice
        String statementMinnie = custMinnieMouse.statement();

        // Print the statement
        Assert.assertEquals(statementMinnie, "Rental record for Minnie Mouse\n" +
                "\tGladiator\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points.");
    }
}