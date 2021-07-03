package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RozetkaHomePage extends BasePage {

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open https://rozetka.com.ua/pages/obmin/ web-site for determination of device`s exchange cost")
    public RozetkaObminPage openRozetkaObminPage() {
        driver.get("https://rozetka.com.ua/pages/obmin/");
        return new RozetkaObminPage(driver);
    }
}
