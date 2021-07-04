package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(css = "a.cart-product__title")
    List<WebElement> productTitle;
    @FindBy(css = "button.modal__close")
    WebElement closeCartPageButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProductInShoppingCart() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(productTitle));
        String title = productTitle.get(0).getText();
        return title;
    }

    public ProductPage closeCartPage() {
        closeCartPageButton.click();
        return new ProductPage(driver);
    }
}
