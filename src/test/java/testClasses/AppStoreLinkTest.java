package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class AppStoreLinkTest extends BaseTest {
    @Test
    @Description("Get to the Rozetka Shop and check mobile app link for Apple Iphone")
    public void appStoreLinkTest() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openAppleStore();
    }
}
