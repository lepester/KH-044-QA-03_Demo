import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaShopPage;
import pageObject.RegisterPage;

public class FieldsRegistrationTest extends BaseTest{

    @Test
    @Description("Get to the Register and enter incorrect data")
    public void incorrectInput(){
        RozetkaShopPage rozetkaShopPage = new RozetkaShopPage(driver);
        rozetkaShopPage
                .openPage()
                .goToLoginPage()
                .goToRegister()
                .formValidationAuth(
                        "Vasya",
                        "Pupkin",
                        "wasd",
                        "azr",
                        "qwerty-azerty");

        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.getValidationMsg().isDisplayed());
    }
}