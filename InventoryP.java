package homework18.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;

public class InventoryPage extends BasePage {


    @FindBy(css = ".shopping_cart_link")
    WebElement cartLink;

    @FindBy(className = "inventory_item_price")
    List<WebElement> price;

    @FindBy(xpath = "//*[text()='Add to cart']")
    List<WebElement> addToCartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public InventoryPage buyItemMaxPrice() {

        Double maxPrice = price.stream().map(x -> x.getText().replaceAll("\\$", ""))
                .map(Double::parseDouble).max(Comparator.comparing(Double::valueOf)).get();
        for (int i = 0; i < price.size(); i++) {
            if (price.get(i).getText().equals("$" + maxPrice)) {
                clickButton(addToCartButton.get(i));
            }
        }
        return this;
    }

    public CartPage openCartPage() {
        clickButton(cartLink);
        return new CartPage(driver);
    }
}
