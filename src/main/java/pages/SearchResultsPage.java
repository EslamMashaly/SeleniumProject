package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private By allItems = By.xpath("//h3[@class='name']");
    private By addToCartButton=By.xpath("//a[@class='core']/following-sibling::footer/form");
    private By addToCartButton2=By.id("add-to-cart");
    private By addedToCartAssertion=By.cssSelector(".-pam.-f1");
    private By addedToWishListAssertion=By.cssSelector(".cnt");
    private By cartButton=By.id("ci");
    private By viewButton=By.cssSelector("a[href='/catalog/?q=harry+potter+books&viewType=list#catalog-listing']");
    private By brands =By.xpath("(//div[@class='-phs -pvxs -df -d-co -h-168 -oya -sc'])[1]/a");
    private By brandAndSizeCheckBox =By.cssSelector(".fk-cb.-me-start.-fsh0");
    private By searchBrand=By.cssSelector("input[placeholder='Search']");
    private By discountPercentage=By.xpath("//div[@class='-pbxs -df -d-co']/a");
    private By saveItemButton=By.xpath("//button[@class='btn _def _i _rnd -mas -bg-wt']");
    private By sliderMin=By.className("min");
    private By sliderMax=By.className("max");
    //private By slider=By.cssSelector("input[value='8'][name='x']");
   /* public void slider(){
        Actions a= new Actions(driver);
        a.dragAndDropBy(find(slider),41430,149000);
    }*/

    public Boolean assertSearchResults(String searchWord) {
        int j = 0;
        Boolean x = false;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            //System.out.println(name);
            if (name.contains(searchWord.substring(1))) {
                j++;
                if (j == 5) {
                    x = true;
                    break;
                }
            }
        }
        return x;
    }

    public void changeListView(){
        click(viewButton);
    }

    public void addToCart(String product) {
        String productToBuy=product ;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if(name.contains(productToBuy)){
                products.get(i).click();
                click(addToCartButton2);
                elementVisibilityExplicitWait(addedToCartAssertion,10);
                driver.navigate().back();
                break;
            }
        }
    }
    public void addToWishList(String product){
            String productToSave=product ;
            List<WebElement> products = driver.findElements(allItems);
            for (int i = 0; i < products.size(); i++) {
                String name = products.get(i).getText();
                if(name.contains(productToSave)){
                    products.get(i).click();
                    click(saveItemButton);
                    elementVisibilityExplicitWait(addedToWishListAssertion,10);
                    driver.navigate().back();
                    break;
                }
            }
        }
    public CartPage gotoCart(){
        click(cartButton);
        return new CartPage();
    }

    public void scroll(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,100)");
    }

    public ProductPage choosingTheProductToBuy(String product) {
        String productToBuy = product;
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains(productToBuy)) {
                products.get(i).click();
                break;
            }
        }
        return new ProductPage();
    }

    public void chooseBrand(String brand) throws InterruptedException {
        //sendKeys(searchBrand,brand);
        List<WebElement> brandsList=driver.findElements(brands);
        for (int i=0; i<brandsList.size(); i++) {
            String brandName = brandsList.get(i).getText();
            if(brandName.contains(brand)){
                Thread.sleep(2000);
                driver.findElements(brands).get(i).click();
                break;
            }

        }
    }
    public void chooseSize(String size){
        List<WebElement> sizes=driver.findElements(brands);
        for (int i=0; i<sizes.size(); i++) {
            String sizeText = sizes.get(i).getText();
            if(sizeText.contains(size)){
                driver.findElements(brandAndSizeCheckBox).get(i).click();
                break;
            }

        }
    }
    public void chooseDiscountPercentage(String percentage){
        List<WebElement> discountPercentages=driver.findElements(discountPercentage);
        for (int i=0; i<discountPercentages.size(); i++) {
            String discountText = discountPercentages.get(i).getText();
            if(discountText.contains(percentage)){
                driver.findElements(discountPercentage).get(i).click();
                break;
            }

        }
    }
    public void choosePriceRange(String min){
        click(sliderMin);

        sendKeys(sliderMin,Keys.BACK_SPACE+min);
    }
   }

/*
  public void addToCart() {
        int j = 0;
        String[] itemsToAddToCart = {"Harry Potter And The Philosopher's Stone", "Harry Potter And The Chamber Of Secrets","Harry Potter And The Prisoner Of Azkaban"};
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            List itemsToAddToCartList = Arrays.asList(itemsToAddToCart);
            if(itemsToAddToCartList.contains(name)){
                driver.findElements(addToCartButton).get(i).click();
                if (j == itemsToAddToCart.length) {
                    break;
                }
            }
        }
    }

 products.get(i).click();
                click(addToCartButton2);
                elementVisibilityExplicitWait(addedToCartAssertion,10);
                driver.navigate().back();

int j = 0;
        String[] itemsToAddToCart = {"Harry Potter And The Philosopher's Stone", "Harry Potter And The Chamber Of Secrets","Harry Potter And The Prisoner Of Azkaban"};
        List<WebElement> products = driver.findElements(allItems);
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            List itemsToAddToCartList = Arrays.asList(itemsToAddToCart);
            if (itemsToAddToCartList.contains(name)) {
                j++;
                driver.findElements(allItems).get(i);
                click(addToCartButton2);
                driver.navigate().back();
                if (j == itemsToAddToCart.length) {
                    break;
                }
            }
        }*/

