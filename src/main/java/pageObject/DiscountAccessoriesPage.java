package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountAccessoriesPage extends BasePage{
    @FindBy(css = "h1.catalog-heading ng-star-inserted")
    WebElement titlePage;
    protected DiscountAccessoriesPage(WebDriver driver) {
        super(driver);
    }
}
