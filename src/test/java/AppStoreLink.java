import org.testng.annotations.Test;
import pageObject.RozetkaShop;

public class AppStoreLink extends BaseTest {
    @Test
    public void appStoreLinkTest() {
        RozetkaShop rozetkaShop = new RozetkaShop(driver);
        rozetkaShop.openPage()
                .openAppleStore();
    }
}
