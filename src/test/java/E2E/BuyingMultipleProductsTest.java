package E2E;

import base.BaseTest;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

public class BuyingMultipleProductsTest extends BaseTest {
    @Test
    public void purchaseMultipleProductsE2E() {
        login();
        String searchWord="harry potter books";
        var searchResultsPage=homePage.search(searchWord);
       // try {
            //searchResultsPage.cancelCookiesMessage();
            searchResultsPage.addToCart("Harry Potter And The Philosopher's Stone");
            searchResultsPage.addToCart("Harry Potter And The Chamber Of Secrets");
            searchResultsPage.addToCart("Harry Potter And The Prisoner Of Azkaban");
        //} catch (ElementClickInterceptedException e) {
            //searchResultsPage.cancelCookiesMessage();
       // }
        var cartPage=searchResultsPage.gotoCart();
        var checkOutPage= cartPage.goToCheckoutPage();
        checkOutPage.chooseDoorDeliveryRadioButton();
        checkOutPage.pressProceedToNextStepButton();
    }
}
