package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {


    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public MainPage setUserName(String username) {
        setText(userNameField, username);
        PageFactory.initElements(driver, this);
        return this;
    }

    public MainPage setPassword(String password) {
        setText(passwordField, password);
        return this;
    }

    public MainPage submit() {
        clickButton(loginButton);
        return this;
    }

    public InventoryPage login(String username, String password) {
        setUserName(username);
        setPassword(password);
        submit();
        return new InventoryPage(driver);
    }
}
