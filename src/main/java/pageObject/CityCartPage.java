package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CityCartPage extends BasePage {
    Actions action;
    @FindBy(xpath = "//form[contains(@class,'header-location__search')]//input[contains(@name,'search')]")
    WebElement citySearchField;
    @FindBy(css = "div.header-location__footer button")
    WebElement submitCityButton;
    @FindBy(css = "ul.autocomplete__list li")
    List<WebElement> citiesList;

    public CityCartPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public CityCartPage searchCity(String city) {
        citySearchField.clear();
        citySearchField.sendKeys(city);
        return new CityCartPage(driver);
    }

    public CityCartPage clickFirstCityInList() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(citiesList));
        citiesList.get(0).click();
        return new CityCartPage(driver);
    }

    public RozetkaHomePage submitCity() {
        submitCityButton.click();
        return new RozetkaHomePage(driver);
    }
}
