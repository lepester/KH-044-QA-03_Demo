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

    @Step("Choose seller in filter")
    public void chooseSellerInFilter(String seller) {
        clickableWaiter(sellers);
        List<WebElement> results = driver.findElements(By.cssSelector(".checkbox-filter__item.ng-star-inserted"));
        for (WebElement checkBox : results) {
            if (checkBox.getText().contains(seller)) {
                clickableWaiter(sellers);
                checkBox.click();
                break;
            }
        }
    }
}