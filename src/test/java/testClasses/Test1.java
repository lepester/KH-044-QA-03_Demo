package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetkaPageObjects.HomePage;

public class Test1 extends BaseTest {

    @Test(groups = {"rozetkaTest"})
    @Description("switching language of the web-site to another one")
    public void switchLanguage() {
        HomePage homePage = new HomePage(driver);
        String oldSearchButtonText = homePage.getHeader()
                .getSearchButtonText();
        String newSearchButtonText = homePage.getHeader()
                .openSideMenu()
                .changeLanguage()
                .getHeader()
                .getSearchButtonText();
        Assert.assertFalse(newSearchButtonText.equals(oldSearchButtonText));
    }
}
