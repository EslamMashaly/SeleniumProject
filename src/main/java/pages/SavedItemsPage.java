package pages;

import org.openqa.selenium.By;

public class SavedItemsPage extends BasePage{
    private By removeSavedItemButton= By.xpath("//button[text()='Remove']");
    private By emptyWishListAssertion=By.xpath("//h2[contains(text(),'You haven’t saved an item yet!')]");

    public void removeSavedItem(){
        click(removeSavedItemButton);
    }
    public String getAssertionText(){
       return getText(emptyWishListAssertion);
    }
}
