package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;
    @FindBy(css = ".checkbox-filter__item.ng-star-inserted")
    private WebElement sellers;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose all sellers in filter")
    public void chooseAllSellersInFilter() {
        visibilityWaiter(sellers);
        List<WebElement> results = driver.findElements(By.cssSelector(".checkbox-filter__item.ng-star-inserted"));
        for (WebElement checkBox : results) {
            if (checkBox.getText().contains("Rozetka")) {
                clickableWaiter(checkBox);
                checkBox.click();
            } else if (checkBox.getText().contains("Другие продавцы")) {
                clickableWaiter(checkBox);
                checkBox.click();
                break;
            }
        }
    }
}