package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private By checkoutButton=By.cssSelector("a[class='btn _prim _md -fw']");
    private By productName=By.cssSelector("h3[class='name']");
    private By removeProductFromCartButton=By.cssSelector(".btn._def._ti.-mra");
    private By removeItemButton=By.cssSelector(".btn._prim._i.-fw.-fh");
    private By emptyCartText=By.xpath("//h2[text()='Your cart is empty!']");

    public CheckoutPage goToCheckoutPage(){
        click(checkoutButton);
        return new CheckoutPage();
    }
    public String getProductText(){
        return getText(productName);
    }
    public void removeProductFromCart(){
        click(removeProductFromCartButton);
        click(removeItemButton);
    }
    public String getEmptyCartText(){
        return getText(emptyCartText);
    }
}
