package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.mscapi.CPublicKey;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResults extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;
    @FindBy(xpath = "(//input[@type='number']) [1]")
    private WebElement setMinPrice;
    @FindBy(xpath = "(//input[@type='number']) [2]")
    private WebElement setMaxPrice;
    @FindBy(css = "button.price-filter__submit")
    private WebElement submitPrice;
    @FindBy(xpath = "//button[contains(text(), 'Цене')]")
    private WebElement sortByPrice;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        visibilityWaiter(firstProduct);
    }

    public SearchResults minPrice(String minInput) {
        clickableWaiter(setMinPrice);
        setMinPrice.clear();
        setMinPrice.sendKeys(minInput);
        return this;
    }

    public SearchResults maxPrice(String maxInput) {
        clickableWaiter(setMaxPrice);
        setMaxPrice.clear();
        setMaxPrice.sendKeys(maxInput);
        submitPrice.click();
        firstProduct.isDisplayed();
        return this;
    }

    public SearchResults sortByPrice() {
        sortByPrice.click();
        firstProduct.isDisplayed();
        return this;
    }

    public SearchResults getPrices() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));
        List<String> originalPrices = prices.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedPrices = originalPrices.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedPrices);
        return this;
    }

}
