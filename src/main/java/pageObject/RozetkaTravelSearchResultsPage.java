package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaTravelSearchResultsPage extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;

    public RozetkaTravelSearchResultsPage(WebDriver driver) {
        super(driver);
        visibilityWaiter(firstProduct);
    }

    @Step("Click on 'Сортировать по Цене' button" )
    public List<Integer> getPricesBySort() {
        firstProduct.isDisplayed();
        List<WebElement> prices = driver.findElements(By.xpath("(//span[@class='s-result-item__price-amount']) [position()>0 and position()<=5]"));
        List<Integer> travelPrices = prices.stream()
                .map(price -> Integer.parseInt(price.getText().replaceAll("\\s+", "")))
                .collect(Collectors.toList());

        return travelPrices;
    }
}
