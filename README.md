# Selenium Framework project for testing Jumia's website.

The project uses Selenium with Java, Maven and TestNG framework. 
Designed with POM pattern.
Supports Multiple Browsers.
Supports Headless Running.
Generates ExtentReport with screenshots of failed scripts.

## I tested these functionalities:
* Registration
* Logging in
* Logging out
* Changing Language
* Entering email for Newsletter
* Searching
* Saving and removing Items from the Wishlist
* Adding and removing Items from the cart
* Checking out 
* Closing Account
* ### And two E2E scenarios
  * Purchasing one product from adding to the cart to checking out
  * Purchasing Multiple products from adding to the cart to checking out

## To try this test in your environment please check the following steps:
___
* Firstly, make sure Jumia's website is working in your environment.
[Jumia](https://www.jumia.com.eg)
* Choose a browser to run the test on (Edge, Chrome, Firefox) by adding the browser name in the parameter value in the testng.xml file.
* Provide a valid registration email in the email field in RegisterTest class. (src/test/java/register/RegisterTests.java).
```java
    private String email="e75e1e540da0@drmail.in";
    private String password="gETZKvbhZ9m#Tpa";
```
* Put the same email in the login method in the BaseTest class.
```java
    public void login(){
        homePage.closePopUp();
        AuthenticationPage authenticationPage=homePage.goToSignInPage();
        authenticationPage.enterEmail("e75e1e540da0@drmail.in");
```
* Provide two different valid emails for the newsletter in the DataProvider method in BaseTest class.
```java
 @DataProvider(name = "newsletter")
    public Object [][] newsLetterField(){
        Object[][] data=new Object[2][2];
        data[0][0]="e75e1e540da0@drmail.in";
        data[0][1]="male";
        data[1][0]="7f4351590e26@drmail.in";
        data[1][1]="female";

        return data;
    }
```
* Run the tests from the testng.xml file.
___
### Note: This project was for learning purposes and used a real website so some tests may be deprecated over time.
#### Thanks 