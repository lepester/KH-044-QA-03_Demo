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

    @FindBy(xpath = "//i[@class='select-icon main-search__icon-departure']")
    private WebElement cityDeparture;
    @FindBy(xpath = "//div[@id='83f0378c-be12-45f3-a023-f412858caddc']")
    private WebElement cityKiev;
    @FindBy(css = "input.button")
    private WebElement searchButton;

    @FindBy(css = "i.main-search__icon-meals")
    private WebElement meals;
    @FindBy(xpath = "//div[@id='c098d41b-99c4-494b-8766-276b3aa6d773']")
    private WebElement allInclusive;

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

    @Step("Choose city departure as 'Киев'")
    public RozetkaTravelHomePage cityDeparture() {
        actions().moveToElement(cityDeparture).click().perform();
        cityKiev.click();
        return this;
    }

    @Step("Choose city arrival")
    public RozetkaTravelHomePage cityArrival(String input) {
        countryArrival.click();
        countryArrival.sendKeys(input);
        firstCountry.click();
        return this;
    }

    @Step("Choose food category as 'Всё включено'")
    public RozetkaTravelHomePage mealChoice() {
        clickableWaiter(meals);
        actions().moveToElement(meals).click().perform();
        visibilityWaiter(allInclusive);
        allInclusive.click();
        return this;
    }

    @Step("Choose date of departure as 'Сегодняшняя дата + 4 дня'")
    public RozetkaTravelHomePage dateDeparture() {
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
