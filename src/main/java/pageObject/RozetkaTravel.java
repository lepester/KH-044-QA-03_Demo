package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RozetkaTravel extends BasePage {

    @FindBy(css = "input.select")
    private WebElement countryArrival;
    @FindBy(id = "b478e17d-1b77-4131-a06f-eb0532465677")
    private WebElement cityDeparture;
    @FindBy(css = "div.select-dropdown__item")
    private WebElement firstCountry;
    @FindBy(css = "div.j-modal__close")
    private WebElement closeButton;
    @FindBy(id = "630b15af-6cef-4385-89ef-b3e8672e55a6")
    private WebElement apartments;

    @FindBy(id = "c871479d-87a4-43ec-960a-f2397e960fa3")
    private WebElement threeStar;
    @FindBy(id = "0857daff-755c-48b1-af70-9c34b8cb15d0")
    private WebElement fourStar;
    @FindBy(id = "e8c8b48c-0dce-4aa2-81c5-7c53219b4a08")
    private WebElement fiveStar;

    @FindBy(xpath = "//div[@class='select-toggle select-toggle_has-icon']")
    private WebElement city;
    @FindBy(css = "input.button")
    private WebElement searchButton;
    @FindBy(xpath = "(//div[@class='select-box']) [3]")
    private WebElement rating;

    @FindBy(xpath = "//div[contains(text(), 'Тип питания')]")
    private WebElement food;
    @FindBy(id = "c098d41b-99c4-494b-8766-276b3aa6d773")
    private WebElement noFood;

    @FindBy(xpath = "(//div[@class='select-box']) [5]")
    private WebElement date;
    @FindBy(css = "span.main-search__counter-button_plus")
    private WebElement plusButton;

    @FindBy(xpath = "(//div[@class='select-box']) [6]")
    private WebElement nightCount;

    @FindBy(xpath = "(//div[@class='select-box']) [7]")
    private WebElement peopleCount;


    @FindBy(xpath = "(//span[@class='main-search__counter-button main-search__counter-button_plus']) [1]")
    private WebElement fromPlus;
    @FindBy(xpath = "(//span[@class='main-search__counter-button main-search__counter-button_minus']) [2]")
    private WebElement toMinus;




    public RozetkaTravel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RozetkaTravel openPage() {
        driver.get("https://rozetka.travel/");
        return this;
    }

    public RozetkaTravel closeSplashWindow() {
        visibilityWaiter(closeButton);
        closeButton.click();
        return this;
    }

    public RozetkaTravel cityDeparture() {
        city.click();
        return this;
    }

    public RozetkaTravel cityArrival(String input) {
        countryArrival.click();
        countryArrival.sendKeys(input);
        firstCountry.click();
        return this;
    }

    public RozetkaTravel hotelScore() {
        clickableWaiter(searchButton);
        rating.click();
        threeStar.click();
        fourStar.click();
        fiveStar.click();
        apartments.click();
        return this;
    }

    public RozetkaTravel foodChoice() {
        clickableWaiter(food);
        food.click();
        visibilityWaiter(noFood);
        noFood.click();
        return this;
    }

    public RozetkaTravel dateDeparture() {
        clickableWaiter(searchButton);
        date.click();
        visibilityWaiter(plusButton);
        plusButton.click();
        return this;
    }

    public RozetkaTravel nightCount() {
        clickableWaiter(nightCount);
        nightCount.click();
        fromPlus.click();
        toMinus.click();
        return this;
    }

    public SearchResults findTour() {
        searchButton.click();
        return new SearchResults(driver);
    }

}