package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends BasePage {

    @FindBy(css = ".main-auth__button")
    private WebElement authButton;
    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login Page")
    public LoginPage goToLoginPage(){
        clickableWaiter(authButton);
        authButton.click();
        return new LoginPage(driver);
    }
}
