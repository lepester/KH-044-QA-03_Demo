package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'search-form__submit')]")
    WebElement searchButton;
    @FindBy(css = "button>svg>use[href*='icon-menu']")
    WebElement sideMenuButton;
    @FindBy(id = "fat-menu")
    WebElement categoryButton;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    @Step("Open toggled side-menu on the page")
    public PageToggledSideMenu openSideMenu() {
        sideMenuButton.click();
        return new PageToggledSideMenu(driver);
    }

    @Step("Open category catalog")
    public CategoryPage openCategoryCatalog() {
        categoryButton.click();
        return new CategoryPage(driver);
    }

    public String getSearchButtonText() {
        String title = searchButton.getText();
        return title;
    }
}
