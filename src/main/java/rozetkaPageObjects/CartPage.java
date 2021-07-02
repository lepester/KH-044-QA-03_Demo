package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(xpath = "//a[contains(@class,'cart-receipt__submit')]")
    WebElement productSubmitButton;
    @FindBy(xpath = "//rz-checkout-order")
    WebElement clientForm;
    @FindBy(css = "a.cart-product__title")
    List<WebElement> productTitle;
    @FindBy(css = "button.modal__close")
    WebElement closeCartPageButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfProductInShoppingCart() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(productSubmitButton));
        String title = productTitle.get(0).getText();
        return title;
    }

    public CartPage closeCartPage() {
        closeCartPageButton.click();
        return new CartPage(driver);
    }
}
