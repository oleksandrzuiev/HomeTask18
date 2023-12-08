package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Step_TwoPage extends BasePage {


    @FindBy(id = "finish")
    WebElement finishButton;

    public Checkout_Step_TwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Checkout_CompletePage finish() {
        clickButton(finishButton);
        return new Checkout_CompletePage(driver);
    }
}
