package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_CompletePage extends BasePage {


    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public Checkout_CompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public InventoryPage backInventoryPage() {
        clickButton(backHomeButton);
        return new InventoryPage(driver);
    }
}
