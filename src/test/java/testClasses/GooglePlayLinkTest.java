package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class GooglePlayLinkTest extends BaseTest {
    @Test
    @Description("Get to the Rozetka Shop and check mobile app link for Android")
    public void googlePlayLink() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage.openGooglePlay();
    }
}
