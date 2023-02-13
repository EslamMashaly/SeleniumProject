package search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {
    @Test(priority = 0,dataProvider = "search")
    public void testingRelevantSearchResults(String searchWord)  {
        //login();
        homePage.closePopUp();
        var searchResultsPage=homePage.search(searchWord);
        Assert.assertTrue(searchResultsPage.assertSearchResults(searchWord));
    }

}
/* @Test(priority = 1)
    public void testingRelevantSearchResultsInArabic() throws InterruptedException {
        //login();
        String searchWord="كتاب";
        var searchResultsPage=homePage.search(searchWord);
        Thread.sleep(2000);
        Assert.assertTrue(searchResultsPage.assertSearchResults(searchWord));

    }*/