package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppStore extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'ROZETKA')]")
    private WebElement appName;

    public AppStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        appName.isDisplayed();
    }
}
