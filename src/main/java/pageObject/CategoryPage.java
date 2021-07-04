package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,'https://rozetka.com.ua/rasprodaja/c83850')]")
    WebElement discountProductsButton;

    protected CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open discount category page")
    public DiscountCategoryPage openDiscountCategoryPage() {
        discountProductsButton.click();
        return new DiscountCategoryPage(driver);
    }
}
