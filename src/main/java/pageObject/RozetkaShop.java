package pageObject;

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
    @FindBy(css = "body")
    private WebElement body;

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
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new GooglePlay(driver);
    }

    public AppStore openAppleStore() {
        iphoneApp.click();
        ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return new AppStore(driver);
    }

}
