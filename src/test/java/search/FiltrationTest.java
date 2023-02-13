package search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;

public class FiltrationTest extends BaseTest {
    @Test
    public void filtrationTest() throws InterruptedException {
        login();
        String searchWord="laptop";
        var searchResultsPage=homePage.search(searchWord);
        Assert.assertTrue(searchResultsPage.assertSearchResults(searchWord));
        searchResultsPage.scroll();
        searchResultsPage.chooseBrand("Acara");
      //  searchResultsPage.chooseSize("6-12 m");
       // searchResultsPage.chooseDiscountPercentage("20% or more");
        //searchResultsPage.choosePriceRange("7000");

    }

}
