package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppStorePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'ROZETKA')]")
    private WebElement appName;

    public AppStorePage(WebDriver driver) {
        super(driver);
        appName.isDisplayed();
    }
}
