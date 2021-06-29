package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class,'product__title')]")
    WebElement productTitle;
    @FindBy(xpath = "//div[contains(@class,'product-about__block')]//button[contains(@class,'buy-button')]")
    WebElement buyButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        explicitWait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public CartPage buyProduct() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(buyButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(buyButton).build().perform();
        buyButton.click();
        return new CartPage(driver);
    }
}
