package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageSideBar extends BasePage {
    Actions action;
    @FindBy(css = "div.main-sidebar__block a[href='https://rozetka.com.ua/pages/obmin/']")
    WebElement rozetkaObminLink;

    public PageSideBar(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public RozetkaObminPage openRozetkaObmin() {
        action.moveToElement(rozetkaObminLink);
        explicitWait.until(ExpectedConditions.elementToBeClickable(rozetkaObminLink));
        rozetkaObminLink.click();
        return new RozetkaObminPage(driver);
    }
}
