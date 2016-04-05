package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.PriceCodes;
import com.scrumtrek.simplestore.reports.JsonReportGenerator;
import com.scrumtrek.simplestore.reports.ReportGenerator;
import com.scrumtrek.simplestore.reports.StringReportGenerator;
import org.junit.Assert;
import org.junit.Test;


public class CustomerTest {

    @Test
    public void testStatementFiveItemsRegularJson() throws Exception {
        // Create movies
        ReportGenerator reportGenerator = new JsonReportGenerator();
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
                "  \"customer\": {\n" +
                "    \"name\": \"Donald Duck\",\n" +
                "    \"rentals\": [\n" +
                "      {\n" +
                "        \"movies\": [\n" +
                "          {\n" +
                "            \"title\": \"Star Wars\",\n" +
                "            \"priceCode\": \"REGULAR\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"daysRented\": 5\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"totalAmount\": 3.5\n" +
                "}", reportGenerator.generateReport(custDonaldDuck));
    }

    @Test
    public void testStatementFiveItemsRegular() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck", new StringReportGenerator());

        // Create rentals
        Rental rental2 = new Rental(5);
        rental2.addMovie(movStarWars);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custDonaldDuck), "Rental record for Donald Duck\n" +
                "\tStar Wars\t3.5\n" +
                "Amount owed is 3.5");
    }

    @Test
    public void testStatementFiveItemsChildren() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);
        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental1 = new Rental(5);
        rental1.addMovie(movCinderella);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custMickeyMouse), "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "Amount owed is 3.0");
    }

    @Test
    public void testStatementFiveItemsNewRelease() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental3 = new Rental(5);
        rental3.addMovie(movGladiator);

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custMinnieMouse), "Rental record for Minnie Mouse\n" +
                "\tGladiator\t3.0\n" +
                "Amount owed is 3.0");
    }

    @Test
    public void testStatementZeroChildren() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDRENS);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental1 = new Rental(0);
        rental1.addMovie(movCinderella);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custMickeyMouse), "Rental record for Mickey Mouse\n" +
                "\tCinderella\t1.5\n" +
                "Amount owed is 1.5");
    }

    @Test
    public void testStatementZeroRegular() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);

        // Create customers
        Customer custDonaldDuck = new Customer("Donald Duck", new StringReportGenerator());

        // Create rentals
        Rental rental2 = new Rental(0);
        rental2.addMovie(movStarWars);

        // Assign rentals to customers
        custDonaldDuck.addRental(rental2);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custDonaldDuck), "Rental record for Donald Duck\n" +
                "\tStar Wars\t2.0\n" +
                "Amount owed is 2.0");
    }

    @Test
    public void testStatementZeroNewRelease() throws Exception {
        ReportGenerator reportGenerator = new StringReportGenerator();
        // Create movies
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        // Create customers
        Customer custMinnieMouse = new Customer("Minnie Mouse", new StringReportGenerator());

        // Create rentals
        Rental rental3 = new Rental(0);
        rental3.addMovie(movGladiator);

        // Assign rentals to customers
        custMinnieMouse.addRental(rental3);

        // Print the statement
        Assert.assertEquals(reportGenerator.generateReport(custMinnieMouse), "Rental record for Minnie Mouse\n" +
                "\tGladiator\t0.0\n" +
                "Amount owed is 0.0");
    }
}