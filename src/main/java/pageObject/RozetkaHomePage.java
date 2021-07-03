package pageObject;

import org.openqa.selenium.WebDriver;

public class RozetkaHomePage extends BasePage {
    PageHeader header;

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
    }

    public PageHeader getHeader() {
        return header;
    }
}
