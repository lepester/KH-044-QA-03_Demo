package rozetkaPageObjects;

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

    public PageToggledSideMenu(WebDriver driver) {
        super(driver);
    }

    public HomePage changeLanguage() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(anotherLanguage));
        anotherLanguage.click();
        return new HomePage(driver);
    }

    public CityCartPage clickCityButton() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(cityButton));
        cityButton.click();
        return new CityCartPage(driver);
    }

    public String getCurrentCity() {
        String city = cityTitle.getText();
        return city;
    }
}