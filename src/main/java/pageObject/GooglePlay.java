package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePlay extends BasePage {
    @FindBy(css = "button.LkLjZd")
    private WebElement appName;

    public GooglePlay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        visibilityWaiter(appName);
    }
}
