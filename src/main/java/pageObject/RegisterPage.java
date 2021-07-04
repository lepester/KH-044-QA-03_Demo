package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id = "registerUserName")
    private WebElement userName;
    @FindBy(id = "registerUserSurname")
    private WebElement userSurname;
    @FindBy(id = "registerUserPhone")
    private WebElement userPhone;
    @FindBy(id = "registerUserEmail")
    private WebElement userEmail;
    @FindBy(id = "registerUserPassword")
    private WebElement userPassword;
    @FindBy(css = ".validation-message.ng-star-inserted")
    private WebElement validationMsg;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get user data and insert them into specific fields")
    public void getUserDataParameters(String name, String surname, String phone, String email, String password){
        userName.sendKeys(name);
        userSurname.sendKeys(surname);
        userPhone.sendKeys(phone);
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
    }

    public boolean isValidationMsgPresent(){
        return validationMsg.isDisplayed();
    }
}