package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pages.AuthenticationPage;
import pages.BasePage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;
    protected BasePage basePage;


    @BeforeMethod
    public void setUp()   {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.jumia.com.eg");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage=new BasePage();
        basePage.setDriver(driver);
        homePage=new HomePage();


    }

    @AfterMethod
    public void tearDown(){
      driver.quit();
    }

    /*********************LOGIN**************************/
    public void login(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("e75e1e540da0@drmail.in");
        var signInPage= authenticationPage.continueSigningIn();
        signInPage.enterPassword("gETZKvbhZ9m#Tpa");
        signInPage.completeSigningIn();
        Assert.assertTrue(homePage.getAssertionText().contains("Hi, "));
    }

    /*********************DATAPROVIDERS**************************/
    @DataProvider
    public Object [][] getData(){
        Object[][] data=new Object[2][2];
            data[0][0]="12345";
            data[0][1]="12345";
            data[1][0]="#$@#!";
            data[1][1]="#$@#!";
            return data;
    }

    @DataProvider(name = "search")
    public Object [][] searchField(){
        Object[][] data=new Object[4][1];
        data[0][0]="jeans";
        data[1][0]="table";
        data[2][0]="watch";
        data[3][0]="كتاب";

        return data;
    }

    @DataProvider(name = "newsletter")
    public Object [][] newsLetterField(){
        Object[][] data=new Object[2][2];
        data[0][0]="e75e1e540da0@drmail.in";
        data[0][1]="male";
        data[1][0]="7f4351590e26@drmail.in";
        data[1][1]="female";

        return data;
    }
}
