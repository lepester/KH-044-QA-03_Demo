package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends BasePage {

    @FindBy(css = "button.menu__toggle")
    private WebElement catalog;
    @FindBy(xpath = "//a[@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    private WebElement displaySection;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open monitors from catalog")
    public SearchResultsPage chooseMonitorsFromCatalog() {
        catalog.click();
        displaySection.click();
        return new SearchResultsPage(driver);
    }
}
