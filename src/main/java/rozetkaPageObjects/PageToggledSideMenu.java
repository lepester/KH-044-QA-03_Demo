package rozetkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageToggledSideMenu extends BasePage {
    @FindBy(css = "div.side-menu rz-lang a.lang__link")
    WebElement anotherLanguage;

    public PageToggledSideMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click button of the language for switching page to another language")
    public HomePage changeLanguage() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(anotherLanguage));
        anotherLanguage.click();
        return new HomePage(driver);
    }
}
