package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        find(locator).click();
    }
    protected String getText(By locator){
         return find(locator).getText();
    }
    protected static String product2="Tempo Zamalek Home Match Jersey 22/23 - Fan Edition";


    protected void sendKeys(By locator, String text){
        find(locator).sendKeys(text);
    }

    protected void elementVisibilityExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
    protected void elementClickableExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }
    protected void elementInvisiblityExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
    }
    protected void selectProductName(String product){
        product2=product;
    }
}
