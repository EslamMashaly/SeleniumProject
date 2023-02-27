package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.AuthenticationPage;
import pages.BasePage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage homePage;
    protected BasePage basePage;

    @Parameters("BrowserName")
    @BeforeMethod
    public void setUp(String browserName)   {
        //ChromeOptions options=new ChromeOptions();
        // options.addArguments("headless");
        // String browserName="chrome";
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

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
        authenticationPage.enterEmail("b0328669e731@drmail.in");
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
        data[0][0]="aba5740296ff@drmail.in";
        data[0][1]="male";
        data[1][0]="b3d792f89dba@drmail.in";
        data[1][1]="female";

        return data;
    }
}
