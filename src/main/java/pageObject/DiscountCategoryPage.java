package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountCategoryPage extends BasePage{
    @FindBy (xpath = "//ul[contains(@class,'portal-navigation')]//li[1]")
    WebElement DiscountAccessories;
    protected DiscountCategoryPage(WebDriver driver) {
        super(driver);
    }

}
