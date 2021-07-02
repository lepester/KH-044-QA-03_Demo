package rozetkaPageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    PageHeader header;
    PageToggledSideMenu pageToggledSideMenu;
    PageSideBar pageSideBar;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
        pageToggledSideMenu = new PageToggledSideMenu(driver);
        pageSideBar = new PageSideBar(driver);
    }

    public HomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return new HomePage(driver);
    }

    public PageHeader getHeader() {
        return header;
    }

    public PageSideBar getPageSideBar() {
        return pageSideBar;
    }

    public RozetkaObminPage openRozetkaObminPage() {
        driver.get("https://rozetka.com.ua/pages/obmin/");
        return new RozetkaObminPage(driver);
    }
}