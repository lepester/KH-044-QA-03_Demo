package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaShop;

public class AppStoreLink extends BaseTest {
    @Test
    @Description("Get to the Rozetka Shop and check mobile app link for Apple Iphone")
    public void appStoreLinkTest() {
        RozetkaShop rozetkaShop = new RozetkaShop(driver);
        rozetkaShop.openPage()
                .openAppleStore();
    }
}

