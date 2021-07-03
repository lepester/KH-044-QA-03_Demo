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

    public WebDriverWait pageLoading() {
        return new WebDriverWait(driver, 25);
    }

    public void clickableWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.elementToBeClickable(wait));
    }

    public void visibilityWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.visibilityOf(wait));
    }

    public void invisibilityWaiter(WebElement wait) {
        pageLoading().until(ExpectedConditions.invisibilityOf(wait));
    }

    public void redrawnWaiter(WebElement wait){
        pageLoading().until(ExpectedConditions.stalenessOf(wait));
    }
}

