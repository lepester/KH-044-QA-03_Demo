package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RegisterPage;
import pageObject.RozetkaHomePage;

public class RegistrationValidationTest extends BaseTest{

    String name = "Thomas";
    String surname = "West";
    String phone = "wasd";
    String email = "azr";
    String password = "qwerty-azerty";

    @Test
    @Description("Get to the Register and enter incorrect data")
    public void incorrectInput(){
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .goToLoginPage()
                .goToRegister()
                .dataParameters(name, surname, phone, email, password);

        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.getValidationMsg().isDisplayed());
    }
}