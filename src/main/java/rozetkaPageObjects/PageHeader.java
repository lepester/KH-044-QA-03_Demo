package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageHeader extends BasePage {
    @FindBy(css = "button#fat-menu")
    WebElement catalogButton;
    @FindBy(xpath = "//fat-menu/div")
    WebElement catalogContent;
    @FindBy(xpath = "//fat-menu//a[@class='menu__link'][@href='https://hard.rozetka.com.ua/monitors/c80089/']")
    WebElement catalogMonitorLink;

    @FindBy(xpath = "//li[contains(@class,'header-actions__item--user')]//button")
    WebElement signInButton;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage chooseMonitorsCategoryInCatalog() {
        catalogButton.click();
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(catalogContent));
        catalogMonitorLink.click();
        return new SearchResultsPage(driver);
    }
}
