package pageObject;

import org.openqa.selenium.WebDriver;

public class RozetkaHomePage extends BasePage {
    PageHeader header;
    PageToggledSideMenu pageToggledSideMenu;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
        pageToggledSideMenu = new PageToggledSideMenu(driver);
    }

    public PageHeader getHeader() {
        return header;
    }
}
