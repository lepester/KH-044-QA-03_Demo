package rozetkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'search-form__submit')]")
    WebElement searchButton;
    @FindBy(css = "button>svg>use[href*='icon-menu']")
    WebElement sideMenuButton;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    @Step("Open toggled side-menu on the page")
    public PageToggledSideMenu openSideMenu() {
        sideMenuButton.click();
        return new PageToggledSideMenu(driver);
    }

    public String getSearchButtonText() {
        String title = searchButton.getText();
        return title;
    }
}
