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

    @Step("Find a product by price sort")
    public RozetkaTravelSearchResultsPage getPricesBySort() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));
        String[] str = new String[5];
        int size = str.length;
        for (int i = 0; i < size; i++) {
            str[i] = prices.get(i).getText().replace(" ", "");
        }
        int[] pricesArr = new int[size];
        for (int i = 0; i < size; i++) {
            pricesArr[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < pricesArr.length - 1; i++) {
            Assert.assertTrue(pricesArr[i] <= pricesArr[i + 1]);
        }
        return this;
    }
}
