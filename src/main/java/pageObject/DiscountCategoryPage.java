package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountCategoryPage extends BasePage {
    @FindBy(css = "a[href*='utsenennye-aksessuary']")
    WebElement discountAccessories;

    protected DiscountCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open accessories category")
    public DiscountAccessoriesPage openDiscountAccessoriesPage() {
        clickableWaiter(discountAccessories);
        discountAccessories.click();
        return new DiscountAccessoriesPage(driver);
    }
}
