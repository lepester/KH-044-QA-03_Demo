package rozetkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    PageHeader header;
    PageToggledSideMenu pageToggledSideMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
        pageToggledSideMenu = new PageToggledSideMenu(driver);
    }

    public PageHeader getHeader() {
        return header;
    }
}