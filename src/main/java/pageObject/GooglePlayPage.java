package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePlayPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'ROZETKA')]")
    private WebElement appName;

    public GooglePlayPage(WebDriver driver) {
        super(driver);
        appName.isDisplayed();
    }
}
