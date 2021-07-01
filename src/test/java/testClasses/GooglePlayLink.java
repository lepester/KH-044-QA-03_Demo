package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaShop;

public class GooglePlayLink extends BaseTest {
    @Test
    @Description("Get to the Rozetka Shop and check mobile app link for Android")
    public void googlePlayLink() {
        RozetkaShop rozetkaShop = new RozetkaShop(driver);
        rozetkaShop.openPage()
                .openGooglePlay();
    }
}
