package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RegisterPage;
import pageObject.RozetkaHomePage;

public class RegistrationValidationTest extends BaseTest{

    @Test
    @Description("Get to the Register and enter incorrect data")
    public void incorrectInput(){

        String name = "Thomas";
        String surname = "West";
        String phone = "wasd";
        String email = "azr";
        String password = "qwerty-azerty";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .goToLoginPage()
                .goToRegister()
                .getUserDataParameters(name, surname, phone, email, password);

        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.isValidationMsgPresent());
    }
}