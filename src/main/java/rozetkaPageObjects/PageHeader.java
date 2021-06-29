package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public SearchResultsPage searchProduct(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public PageSideMenu clickSideMenuButton() {
        sideMenuButton.click();
        return new PageSideMenu(driver);
    }

    public String getSearchButtonText() {
        String title = searchButton.getText();
        return title;
    }
}
