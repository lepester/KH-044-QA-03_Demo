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
    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInput;

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

    @Step("Search for the query product on the web-site")
    public SearchResultsPage searchProduct(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
