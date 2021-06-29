package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    PageHeader header;

    @FindBy(xpath = "//input[@name='search']")
    WebElement searchInput;
    @FindBy(xpath = "//button[contains(@class,'search-form__submit')]")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
    }

    public HomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return new HomePage(driver);
    }

    public SearchResultsPage searchProduct(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage chooseMonitorsCategoryInCatalog() {
        return header.chooseMonitorsCategoryInCatalog();
    }
}
