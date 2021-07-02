package rozetkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends BasePage {
    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInput;
    @FindBy(xpath = "//button[contains(@class,'search-form__submit')]")
    WebElement searchButton;
    @FindBy(css = "button>svg>use[href*='icon-menu']")
    WebElement sideMenuButton;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    @Step("Search for the query product on the web-site")
    public SearchResultsPage searchProduct(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
