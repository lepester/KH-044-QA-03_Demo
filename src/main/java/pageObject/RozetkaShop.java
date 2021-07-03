package pageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


public class RozetkaShop extends BasePage {
    @FindBy(xpath = "//img[@alt='Google Play']")
    private WebElement androidApp;
    @FindBy(xpath = "//img[@alt='AppStore']")
    private WebElement iphoneApp;

    public RozetkaShop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open Rozetka Shop")
    public RozetkaShop openPage() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    @Step("Open Google Play Store")
    public GooglePlay openGooglePlay() {
        androidApp.click();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new GooglePlay(driver);
    }

    @Step("Open Apple App Store")
    public AppStore openAppleStore() {
        iphoneApp.click();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new AppStore(driver);
    }
}

