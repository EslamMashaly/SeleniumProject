package homePage;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsLetterEmail extends BaseTest {
    @Test(priority = 0,dataProvider = "newsletter")
    public void testEnteringEmailForNews(String email, String gender) throws InterruptedException {
        homePage.closePopUp();
        homePage.enterEmailForNewsLetter(email);
        Thread.sleep(2000);
        homePage.scroll();
        homePage.chooseGender("gender");
        Assert.assertEquals(homePage.getNewsLetterEmailMessage(),"Thank you for subscribing! Your request will be processed.");
    }
    @Test(priority = 1,dataProvider = "newsletter")
    public void testEnteringAlreadySentEmailForNews(String email, String gender) throws InterruptedException {
        homePage.closePopUp();
        homePage.enterEmailForNewsLetter(email);
        Thread.sleep(2000);
        homePage.scroll();
        homePage.chooseGender("gender");
        Assert.assertEquals(homePage.getAlreadySubscribedMessage(),"A subscription already exists for this e-mail.");
    }

}
