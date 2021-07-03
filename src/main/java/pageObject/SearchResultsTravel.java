package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchResultsTravel extends BasePage {

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

    public SearchResultsTravel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        visibilityWaiter(firstProduct);
    }

    @Step("Set minimal price of tour")
    public SearchResultsTravel minPrice(String minInput) {
        clickableWaiter(setMinPrice);
        setMinPrice.clear();
        setMinPrice.sendKeys(minInput);
        return this;
    }

    @Step("Set maximum price of tour")
    public SearchResultsTravel maxPrice(String maxInput) {
        clickableWaiter(setMaxPrice);
        setMaxPrice.clear();
        setMaxPrice.sendKeys(maxInput);
        submitPrice.click();
        firstProduct.isDisplayed();
        return this;
    }

    @Step("Click 'OK' button")
    public SearchResultsTravel sortByPrice() {
        sortByPrice.click();
        firstProduct.isDisplayed();
        return this;
    }

    @Step("Find a product by price sort")
    public SearchResultsTravel getPricesBySort() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));
        String[] str = new String[2];
        int size = str.length;
        for (int i = 0; i < size; i++) {
            str[i] = prices.get(i).getText().replace(" ", "" );

        }
        int[] pricesArr = new int [size];
        for (int i = 0; i < size; i++) {
            pricesArr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < pricesArr.length - 1; i++) {
            Assert.assertTrue(pricesArr[i] <= pricesArr[i+1]);
        }
        return this;
    }

    @Step("Find a product by price filter")
    public SearchResultsTravel getPricesByFilter() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));

        String[] str = new String[5];
        int size = str.length;
        for (int i = 0; i < size; i++) {
            str[i] = prices.get(i).getText().replace(" ", "");
        }
        int[] pricesArr = new int [size];
        for (int i = 0; i < size; i++) {
            pricesArr[i] = Integer.parseInt(str[i]);
            Assert.assertTrue(16500 < pricesArr[i]);
            Assert.assertTrue(pricesArr[i] < 21000);
        }
        return this;
    }
}

