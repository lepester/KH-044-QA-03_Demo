package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends BasePage {

    @FindBy(css = "div.s-result-item")
    private WebElement firstProduct;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        firstProduct.isDisplayed();
    }

}
