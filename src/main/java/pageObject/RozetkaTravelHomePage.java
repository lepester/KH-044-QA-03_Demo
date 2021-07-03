package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaTravelHomePage extends BasePage {

    @FindBy(css = "input.select")
    private WebElement countryArrival;
    @FindBy(css = "div.select-dropdown__item")
    private WebElement firstCountry;
    @FindBy(css = "div.j-modal__close")
    private WebElement closeButton;

    @FindBy(xpath = "//div[@class='select-toggle select-toggle_has-icon']")
    private WebElement city;
    @FindBy(css = "input.button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(), 'Тип питания')]")
    private WebElement food;
    @FindBy(id = "c098d41b-99c4-494b-8766-276b3aa6d773")
    private WebElement noFood;

    @FindBy(xpath = "(//div[@class='select-box']) [5]")
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

    @Step("Choose city departure")
    public RozetkaTravelHomePage cityDeparture() {
        city.click();
        return this;
    }

    @Step("Choose city arrival")
    public RozetkaTravelHomePage cityArrival(String input) {
        countryArrival.click();
        countryArrival.sendKeys(input);
        firstCountry.click();
        return this;
    }

    @Step("Choose food category")
    public RozetkaTravelHomePage foodChoice() {
        clickableWaiter(food);
        food.click();
        visibilityWaiter(noFood);
        noFood.click();
        return this;
    }

    @Step("Choose date of departure")
    public RozetkaTravelHomePage dateDeparture() {
        clickableWaiter(searchButton);
        date.click();
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
