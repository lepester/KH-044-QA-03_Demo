import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.RegisterPage;

public class FieldsRegistrationTest extends BaseTest{

    @Test
    public void incorrectInput(){
        HomePage homePage = new HomePage(driver);
        homePage
                .openPage()
                .goToLoginPage()
                .goToRegister()
                .formValidationAuth("Vasya", "Pupkin","wasd", "azr", "qwerty-azerty");

        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.getValidationMsg().isDisplayed());
    }
}