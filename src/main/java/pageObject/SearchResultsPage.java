package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//a/span[contains(@class,'goods-tile__title')]")
    List<WebElement> goodsCatalog;
    @FindBy(css = ".button.slider-filter__button")
    private WebElement buttonPriceOk;
    @FindBy(xpath = "//input[@formcontrolname = 'min']")
    private WebElement minPrice;
    @FindBy(xpath = "//input[@formcontrolname = 'max']")
    private WebElement maxPrice;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click first product for switching to its page")
    public ProductPage clickFirstProduct() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(goodsCatalog));
        goodsCatalog.get(0).click();
        return new ProductPage(driver);
    }

    @Step("Insert the min and max prices into fields")
    public void getPricesFields(String min, String max){
        visibilityWaiter(minPrice);
        minPrice.clear();
        minPrice.sendKeys(min);
        maxPrice.clear();
        maxPrice.sendKeys(max);
    }

    public boolean isButtonPriceOkEnabled(){
        return buttonPriceOk.isEnabled();
    }
}