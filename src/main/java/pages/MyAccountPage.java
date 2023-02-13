package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage extends BasePage{
    private By closeAccountButton= By.linkText("Close Account");
    private By closingReasonDropDown=By.id("fi-reasons");
    private By confirmClosingCheckbox=By.xpath("//label[contains(text(),'Yes, I wish to definitely close my Jumia account a')]");
    private By closeMyAccountButton=By.cssSelector(".btn._prim.-mts.-fw");
    private By cookiesMessageCloseButton=By.xpath("//button[@class='cls']");
    private By closingAssertionText=By.cssSelector(".-fs16.-pts.-m");
    public void goToCloseAccount(){
        click(closeAccountButton);
    }
    public void chooseAReasonForClosingAccount() throws InterruptedException {
        Select dropDown= new Select(find(closingReasonDropDown));
        dropDown.selectByIndex(1);
        Thread.sleep(3000);
    }
    public void selectClosingCheckBox(){
        click(confirmClosingCheckbox);
    }

    public void pressCloseMyAccountButton(){
        click(closeMyAccountButton);
    }
    public void closeCookiesMessage(){
        click(cookiesMessageCloseButton);
    }

    public String getClosingAccountConfirmationMessage(){
        return getText(closingAssertionText);
    }
    public void scroll(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,300)");
    }
}
