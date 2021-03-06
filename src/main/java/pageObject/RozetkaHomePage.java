package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class RozetkaHomePage extends BasePage {
    PageHeader header;
    PageToggledSideMenu pageToggledSideMenu;

    @FindBy(xpath = "//img[@alt='Google Play']")
    private WebElement androidApp;
    @FindBy(xpath = "//img[@alt='AppStore']")
    private WebElement iphoneApp;
    @FindBy(css = "body")
    private WebElement body;
    @FindBy(css = "button.menu__toggle")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;

    @FindBy(css = ".main-auth__button")
    private WebElement authButton;
    public RozetkaHomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
        pageToggledSideMenu = new PageToggledSideMenu(driver);
    }

    public PageHeader getHeader() {
        return header;
    }

    @Step("Open Login Page")
    public LoginPage goToLoginPage(){
        clickableWaiter(authButton);
        authButton.click();
        return new LoginPage(driver);
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

    @Step("Open https://rozetka.com.ua/pages/obmin/ web-site for determination of device`s exchange cost")
    public RozetkaObminPage openRozetkaObminPage() {
        driver.get("https://rozetka.com.ua/pages/obmin/");
        return new RozetkaObminPage(driver);
    }

    @Step("Open monitors from catalog")
    public SearchResultsPage chooseMonitorsFromCatalog() {
        catalog.click();
        displaySection.click();
        return new SearchResultsPage(driver);
    }
}
