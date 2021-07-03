package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaTravel extends BasePage {

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

    public RozetkaTravel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open Rozetka Travel")
    public RozetkaTravel openPage() {
        driver.get("https://rozetka.travel/");
        return this;
    }

    @Step("Close splash window")
    public RozetkaTravel closeSplashWindow() {
        visibilityWaiter(closeButton);
        closeButton.click();
        return this;
    }

    @Step("Choose city departure")
    public RozetkaTravel cityDeparture() {
        city.click();
        return this;
    }

    @Step("Choose city arrival")
    public RozetkaTravel cityArrival(String input) {
        countryArrival.click();
        countryArrival.sendKeys(input);
        firstCountry.click();
        return this;
    }

    @Step("Choose food category")
    public RozetkaTravel foodChoice() {
        clickableWaiter(food);
        food.click();
        visibilityWaiter(noFood);
        noFood.click();
        return this;
    }

    @Step("Choose date of departure")
    public RozetkaTravel dateDeparture() {
        clickableWaiter(searchButton);
        date.click();
        clickableWaiter(plusButton);
        plusButton.click();
        return this;
    }

    @Step("Click 'find' button")
    public SearchResultsTravel findTour() {
        searchButton.click();
        return new SearchResultsTravel(driver);
    }
}