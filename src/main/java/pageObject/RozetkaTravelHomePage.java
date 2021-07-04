package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RozetkaTravelHomePage extends BasePage {

    @FindBy(css = "input.select")
    private WebElement countryArrival;
    @FindBy(css = "div.select-dropdown__item")
    private WebElement firstCountry;
    @FindBy(css = "div.j-modal__close")
    private WebElement closeButton;

    @FindBy(xpath = "//i[@class='select-icon main-search__icon-departure']")
    private WebElement cityDeparture;
    @FindBy(css = "input.button")
    private WebElement searchButton;

    @FindBy(css = "i.main-search__icon-meals")
    private WebElement meals;

    @FindBy(css = "i.main-search__icon-calendar")
    private WebElement date;
    @FindBy(css = "span.main-search__counter-button_plus")
    private WebElement plusButton;

    public RozetkaTravelHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Close splash window")
    public RozetkaTravelHomePage closeSplashWindow() {
        visibilityWaiter(closeButton);
        closeButton.click();
        return this;
    }

    @Step("Choose city departure as {city}")
    public RozetkaTravelHomePage selectCityDeparture(String city) {
        actions().moveToElement(cityDeparture).click().perform();
        List<WebElement> cities = driver.findElements(By.xpath("//*[@id]/span"));
        for (WebElement span : cities) {
            if (span.getText().contains(city)) {
                clickableWaiter(span);
                actions().moveToElement(span).click().perform();
                break;
            }
        }
        return this;
    }

    @Step("Choose country arrival as {country}")
    public RozetkaTravelHomePage selectCountryArrival(String country) {
        countryArrival.click();
        countryArrival.sendKeys(country);
        firstCountry.click();
        return this;
    }

    @Step("Choose food category")
    public RozetkaTravelHomePage selectMeals() {
        clickableWaiter(meals);
        actions().moveToElement(meals).click().perform();
        List<WebElement> mealType = driver.findElements(By.xpath("//*[@id]/span"));
        mealType.get(8).click();
        return this;
    }

    @Step("Choose date of departure")
    public RozetkaTravelHomePage selectFourDaysDate() {
        clickableWaiter(searchButton);
        actions().moveToElement(date).click().perform();
        clickableWaiter(plusButton);
        plusButton.click();
        return this;
    }

    @Step("Click 'find' button")
    public RozetkaTravelSearchResultsPage findTour() {
        searchButton.click();
        return new RozetkaTravelSearchResultsPage(driver);
    }
}
