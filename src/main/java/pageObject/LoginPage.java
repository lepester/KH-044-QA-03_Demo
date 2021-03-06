package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = ".auth-modal__register-link.ng-star-inserted")
    private WebElement registerButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Register Page")
    public RegisterPage goToRegister(){
        clickableWaiter(registerButton);
        registerButton.click();
        return new RegisterPage(driver);
    }
}