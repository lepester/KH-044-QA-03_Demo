package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SwitchLanguage extends BaseTest {

    @Test(groups = {"rozetkaTest"})
    @Description("switching language of the web-site to another one")
    public void switchLanguage() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(driver);
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
