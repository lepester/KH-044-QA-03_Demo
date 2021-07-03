package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    @FindBy(css = "div.layout_with_sidebar")
    private WebElement resultsGrid;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose all sellers in filter")
    public SearchResultsPage chooseSellerFilter(String []filtersArray) {
        try {
            for (String moreFilter : filtersArray) {
                WebElement checkBox = driver.findElement(By.xpath("//label[@for='" + moreFilter + "']"));
                clickableWaiter(checkBox);
                checkBox.click();
                resultsGrid.isDisplayed();
            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        return this;
    }
}