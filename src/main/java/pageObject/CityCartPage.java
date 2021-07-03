package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CityCartPage extends BasePage {
    @FindBy(xpath = "//form[contains(@class,'header-location__search')]//input[contains(@name,'search')]")
    WebElement citySearchField;
    @FindBy(css = "div.header-location__footer button")
    WebElement submitCityButton;

    public CityCartPage(WebDriver driver) {
        super(driver);
    }

    public CityCartPage searchCity(String city) {
        citySearchField.clear();
        citySearchField.sendKeys(city);
        citySearchField.sendKeys(Keys.ARROW_DOWN);
        citySearchField.sendKeys(Keys.ENTER);
        return new CityCartPage(driver);
    }

    public RozetkaHomePage submitCity() {
        submitCityButton.click();
        return new RozetkaHomePage(driver);
    }
}
