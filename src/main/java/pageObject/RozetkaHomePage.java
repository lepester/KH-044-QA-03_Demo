package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class RozetkaHomePage extends BasePage {

    @FindBy(xpath = "//img[@alt='Google Play']")
    private WebElement androidApp;
    @FindBy(xpath = "//img[@alt='AppStore']")
    private WebElement iphoneApp;
    @FindBy(css = "body")
    private WebElement body;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Google Play Store")
    public GooglePlayPage openGooglePlay() {
        androidApp.click();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new GooglePlayPage(driver);
    }
    @Step("Open Apple App Store")
    public AppStorePage openAppleStore() {
        iphoneApp.click();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new AppStorePage(driver);
    }
}
