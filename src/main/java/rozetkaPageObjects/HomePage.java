package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    PageHeader header;
    PageSideMenu pageSideMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
        pageSideMenu = new PageSideMenu(driver);
    }

    public HomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return new HomePage(driver);
    }

    public PageSideMenu openSideMenu() {
        return header.clickSideMenuButton();
    }

    public String getSearchButtonText() {
        return  header.getSearchButtonText();
    }

    public String getCurrentCity() {
        return pageSideMenu.getCurrentCity();
    }

    public SearchResultsPage searchProduct(String searchText) {
        return header.searchProduct(searchText);
    }
}
