package pages;

import org.openqa.selenium.By;

public class PersonalDetailsPage extends BasePage{
    private By firstNameField=By.id("input_first_name");
    private By shortFNameText=By.id("invalid-max-length-text-field-error-message");
    private By middleNameField=By.id("input_middle_name");
    private By lastNameField=By.id("input_last_name");
    private By phoneField=By.name("phone[number]");
    private By invalidPhoneText=By.id("api-error");
        private By continueButton3 =By.xpath("//div[@id='card_profile_details']//div[@class='mdc-touch-target-wrapper']");
    private By genderField=By.id("gender");
    private By genderMale=By.cssSelector("li[data-value='M']");
    private By genderFemale=By.cssSelector("li[data-value='F']");
    private By birthDateField=By.id("input_birth_date");
    private By termsCheckBox=By.cssSelector("#acceptTC");
    private By continueButton4=By.cssSelector("button[id='confirmBtn'] span[class='mdc-button__touch']");
    private By pinNumberField=By.xpath("//div[@id='pin']//input[@aria-label='digit 1']");
    private By invalidFirstNameMessage=By.xpath("//div[@id='validation_first_name']//span[@id='invalid-max-length-text-field-error-message']");
    private By invalidLastNameMessage=By.xpath("//div[@id='validation_last_name']//span[@id='invalid-max-length-text-field-error-message']");



    public void enterFirstName(String firstName){
        sendKeys(firstNameField,firstName);
    }
    public void enterMiddleName(String middleName){
        sendKeys(middleNameField,middleName);
    }
    public void enterLastName(String lastName){
        sendKeys(lastNameField,lastName);
        //elementVisibilityExplicitWait(invalidFirstNameMessage,5);
    }
    public void enterPhoneNumber(String number){
        sendKeys(phoneField,number);
        elementVisibilityExplicitWait(continueButton3,3);
    }
    public void pressContinue(){
        click(continueButton3);
    }
    public void chooseGender(String gender){
        click(genderField);
        if(gender=="male")
            click(genderMale);
        if (gender=="female")
            click(genderFemale);
    }
    public void chooseBirthDate(String birthDate){
        click(genderField);
        sendKeys(birthDateField,birthDate);
    }

    public void selectCheckBox(){
        click(termsCheckBox);
        elementVisibilityExplicitWait(continueButton4,3);
    }
    public void finishSigning(){
        click(continueButton4);
    }

    public void enterPinNumber(String pinNumber){
        sendKeys(pinNumberField,pinNumber);
    }
    public String getShortFNameText(){
        return getText(shortFNameText);
    }
    public String getInvalidPhoneText(){
        elementVisibilityExplicitWait(invalidPhoneText,5);
        return getText(invalidPhoneText);
    }
    public String getInvalidFNameText(){
        elementVisibilityExplicitWait(invalidFirstNameMessage,5);
        return getText(invalidFirstNameMessage);
    }
    public String getInvalidLNameText(){
        elementVisibilityExplicitWait(invalidLastNameMessage,5);
        return getText(invalidLastNameMessage);
    }
}
