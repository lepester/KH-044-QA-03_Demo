package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaShop extends BasePage {
    @FindBy(xpath = "//img[@alt='Google Play']")
    private WebElement androidApp;
    @FindBy(xpath = "//img[@alt='AppStore']")
    private WebElement iphoneApp;

    public RozetkaShop(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaShop openPage() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public GooglePlay openGooglePlay() {
        androidApp.click();
        return new GooglePlay(driver);
    }

    public AppStore openAppleStore() {
        iphoneApp.click();
        return new AppStore(driver);
    }

}
