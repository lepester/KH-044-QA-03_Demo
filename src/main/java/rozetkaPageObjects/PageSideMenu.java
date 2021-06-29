package rozetkaPageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageSideMenu extends BasePage {
    @FindBy(css = "div.side-menu rz-lang a.lang__link")
    WebElement anotherLanguage;
    @FindBy(xpath = "//button[contains(@class,'city-toggle')]")
    WebElement cityButton;
    @FindBy(css = "span.city-toggle__text")
    WebElement cityTitle;

    public PageSideMenu(WebDriver driver) {
        super(driver);
    }

    public HomePage changeLanguage() {
        anotherLanguage.click();
        return new HomePage(driver);
    }

    public CityCartPage clickCityButton() {
        cityButton.click();
        return new CityCartPage(driver);
    }

    public String getCurrentCity() {
        String city = cityTitle.getText();
        return city;
    }
}
