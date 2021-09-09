package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        explicitWait = new WebDriverWait(driver, 15);
    }

    public Actions actions() {
        return new Actions(driver);
    }

    public void clickableWaiter(WebElement webElement) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void visibilityWaiter(WebElement webElement) {
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void invisibilityWaiter(WebElement webElement) {
        explicitWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void redrawnWaiter(WebElement webElement) {
        explicitWait.until(ExpectedConditions.stalenessOf(webElement));
    }
}

