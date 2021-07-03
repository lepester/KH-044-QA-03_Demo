package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageToggledSideMenu extends BasePage {
    @FindBy(css = "div.side-menu rz-lang a.lang__link")
    WebElement anotherLanguage;
    @FindBy(xpath = "//button[contains(@class,'city-toggle')]")
    WebElement cityButton;
    @FindBy(css = "span.city-toggle__text")
    WebElement cityTitle;
    @FindBy(css = "a.side-menu__button[href*='help']")
    WebElement referenceCenter;

    public PageToggledSideMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click button of the language for switching page to another language")
    public RozetkaHomePage changeLanguage() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(anotherLanguage));
        anotherLanguage.click();
        return new RozetkaHomePage(driver);
    }

    @Step("Click button for switching to another location (city)")
    public CityCartPage clickCityButton() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(cityButton));
        cityButton.click();
        return new CityCartPage(driver);
    }

    public String getCurrentCity() {
        String city = cityTitle.getText();
        return city;
    }

    @Step("Click button to get to reference center page")
    public RozetkaReferenceCenterPage openReferenceCenter() {
        referenceCenter.click();
        return new RozetkaReferenceCenterPage(driver);
    }
}
