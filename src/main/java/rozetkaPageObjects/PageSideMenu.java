package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSideMenu extends BasePage {
    @FindBy(css = "div.side-menu rz-lang a.lang__link")
    WebElement anotherLanguage;

    public PageSideMenu(WebDriver driver) {
        super(driver);
    }

    public HomePage changeLanguage() {
        anotherLanguage.click();
        return new HomePage(driver);
    }
}
