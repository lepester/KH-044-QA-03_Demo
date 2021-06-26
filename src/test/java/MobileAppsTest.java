import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaShop;

public class MobileAppsTest extends BaseTest {
    @Test
    public void mobileAppsTest() {
        String expectedTitle = "https://play.google.com/store/apps/details/?id=ua.com.rozetka.shop&referrer=utm_source%3Dfullversion%26utm_medium%3Dsite%26utm_campaign%3Dfullversion";
        RozetkaShop rozetkaShop = new RozetkaShop(driver);
        rozetkaShop.openPage()
                .openGooglePlay();
        String actualTitle = driver.getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
