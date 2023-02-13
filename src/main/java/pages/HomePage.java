package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
private By accountButton =By.cssSelector("label[for='dpdw-login']");
private By myAccountButton=By.linkText("My Account");
private By signInButton=By.cssSelector("a[class='btn _prim -fw _md']");
private By logOutButton=By.cssSelector("button[type='submit']");
private By savedItemsButton=By.linkText("Saved Items");
private By popUp=By.xpath("//button[@aria-label='newsletter_popup_close-cta']");
private By searchBar=By.id("fi-q");
private By searchButton=By.cssSelector(".btn._prim._md.-mls.-fsh0");
private By signingAssertionText=By.cssSelector("label[for='dpdw-login']");
private By cartButton=By.id("ci");
private By arabicLanguageButton=By.cssSelector("a[class='-vrl -fs0'] span[class='-dif -i-ctr -fs12']");
private By changingLanguageAssertionText=By.xpath("//label[text()='تسجيل الدخول']");

public void closePopUp(){
    click(popUp);
}
public AuthenticationPage goToSignInPage(){
    click(accountButton);
    click(signInButton);
    return new AuthenticationPage();
}
public SearchResultsPage search(String searchWord){
    sendKeys(searchBar,searchWord);
    click(searchButton);
    return  new SearchResultsPage();
}
public String getAssertionText(){
    return getText(signingAssertionText);
}

public MyAccountPage goToMyAccountPage()   {
    click(accountButton);
    click(myAccountButton);
    return new MyAccountPage();
}
    public SavedItemsPage goToSavedItemsPage()   {
        click(accountButton);
        click(savedItemsButton);
        return new SavedItemsPage();
    }
public void Logout(){
    click(accountButton);
    click(logOutButton);
}
public String logOutAssertionText(){
    return getText(accountButton);
}

public CartPage gotoCart(){
    click(cartButton);
    return new CartPage();
}
public void changeToArabic(){
    click(arabicLanguageButton);
}
public String arabicAssertionText(){
    return getText(changingLanguageAssertionText);
}
}

