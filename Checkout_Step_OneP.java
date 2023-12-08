package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Step_OnePage extends BasePage {


    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    public Checkout_Step_OnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        setText(firstNameField, firstName);
    }

    public void setLastName(String lastName) {
        setText(lastNameField, lastName);
    }

    public void setPostalCode(String postalCode) {
        setText(postCodeField, postalCode);
    }

    public Checkout_Step_OnePage sendYourInformation() {
        clickButton(continueButton);
        return this;
    }

    public Checkout_Step_TwoPage setYourInformationAndContinue(String firstName, String lastName, String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        sendYourInformation();
        return new Checkout_Step_TwoPage(driver);
    }
}
