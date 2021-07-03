package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebDriverWait explicitWait() {
        return new WebDriverWait(driver, 15);
    }

    public void clickableWaiter(WebElement wait) {
        explicitWait().until(ExpectedConditions.elementToBeClickable(wait));
    }

    public void visibilityWaiter(WebElement wait) {
        explicitWait().until(ExpectedConditions.visibilityOf(wait));
    }

    public void invisibilityWaiter(WebElement wait) {
        explicitWait().until(ExpectedConditions.invisibilityOf(wait));
    }

    public void redrawnWaiter(WebElement wait){
        explicitWait().until(ExpectedConditions.stalenessOf(wait));
    }
}

