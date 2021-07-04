package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaTravelSearchResultsPage extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;
    @FindBy(xpath = "//form[contains(@class,'price-filter')]//input[1]")
    private WebElement setMinPrice;
    @FindBy(xpath = "//form[contains(@class,'price-filter')]//input[2]")
    private WebElement setMaxPrice;
    @FindBy(css = "button.price-filter__submit")
    private WebElement submitPrice;

    public RozetkaTravelSearchResultsPage(WebDriver driver) {
        super(driver);
        visibilityWaiter(firstProduct);
    }

    @Step("Set minimal price of tour")
    public RozetkaTravelSearchResultsPage minPrice(String minInput) {
        clickableWaiter(setMinPrice);
        setMinPrice.clear();
        setMinPrice.sendKeys(minInput);
        return this;
    }

    @Step("Set maximum price of tour")
    public RozetkaTravelSearchResultsPage maxPrice(String maxInput) {
        clickableWaiter(setMaxPrice);
        setMaxPrice.clear();
        setMaxPrice.sendKeys(maxInput);
        submitPrice.click();
        visibilityWaiter(firstProduct);
        return this;
    }

    @Step("Find a product by price filter")
    public List<Integer> getPricesByFilter() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));
        List<Integer> travelPrices = prices.stream()
                    .map(price -> Integer.parseInt(price.getText().replaceAll("\\s+", "")))
                    .collect(Collectors.toList());

        return travelPrices;
    }
}
