package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaTravelSearchResultsPage extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;

    public RozetkaTravelSearchResultsPage(WebDriver driver) {
        super(driver);
        visibilityWaiter(firstProduct);
    }
}
