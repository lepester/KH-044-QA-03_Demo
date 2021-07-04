package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaTravelHomePage extends BasePage {

    @FindBy(css = "div.j-modal__close")
    private WebElement closeButton;
    @FindBy(css = "input.button")
    private WebElement searchButton;

    public RozetkaTravelHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Close splash window")
    public RozetkaTravelHomePage closeSplashWindow() {
        visibilityWaiter(closeButton);
        closeButton.click();
        return this;
    }

    @Step("Click 'find' button")
    public RozetkaTravelSearchResultsPage findTour() {
        searchButton.click();
        return new RozetkaTravelSearchResultsPage(driver);
    }
}
