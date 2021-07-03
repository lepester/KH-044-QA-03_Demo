package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class RozetkaTravelSearchResultsPage extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;
    @FindBy(css = "button.price-filter__submit")
    private WebElement submitPrice;

    public RozetkaTravelSearchResultsPage(WebDriver driver) {
        super(driver);
        visibilityWaiter(firstProduct);
    }

    @Step("Click on 'Сортировать по Цене' button" )
    public RozetkaTravelSearchResultsPage getPricesBySort() {
        visibilityWaiter(firstProduct);
        submitPrice.click();
        visibilityWaiter(firstProduct);
        return this;
    }
}
