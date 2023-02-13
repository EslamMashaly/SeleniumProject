package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    private By productAddedMessage=By.xpath("//div[@id='jm']//div[@class='cnt']");
    private By addToCartButton = By.id("add-to-cart");

    private By productSize = By.xpath("//label[text()='XXL']");
    private By productQuantityButton = By.xpath("//div[5]//form[1]//button[2]");
    private By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private By viewCartButton = By.xpath("//a[text()='View Cart and Checkout']");


    public void addToCart(){
        click(addToCartButton);
    }
    public void chooseQuantity(){
        click(productQuantityButton);
        }

    public CartPage goToCartAndCheckout(){
        elementVisibilityExplicitWait(productAddedMessage,5);
        click(viewCartButton);
        return new CartPage();
    }
}
