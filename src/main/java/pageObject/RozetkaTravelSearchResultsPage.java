package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaTravelSearchResultsPage extends BasePage {

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

    public RozetkaTravelSearchResultsPage(WebDriver driver) {
        super(driver);
        visibilityWaiter(firstProduct);
    }
}
