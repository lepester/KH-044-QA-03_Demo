package rozetkaPageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    PageHeader header;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new PageHeader(driver);
    }

    @Step("Open https://rozetka.com.ua/ web-site home page")
    public HomePage openPage() {
        driver.get("https://rozetka.com.ua/");
        return new HomePage(driver);
    }

    public PageHeader getHeader() {
        return header;
    }
}