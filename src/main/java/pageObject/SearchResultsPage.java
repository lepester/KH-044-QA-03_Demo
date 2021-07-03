package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//a/span[contains(@class,'goods-tile__title')]")
    List<WebElement> goodsCatalog;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click first product for switching to its page")
    public ProductPage clickFirstProduct() {
        goodsCatalog.get(0).click();
        return new ProductPage(driver);
    }
}