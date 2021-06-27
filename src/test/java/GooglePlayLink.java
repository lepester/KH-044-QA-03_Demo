import org.testng.annotations.Test;
import pageObject.RozetkaShop;

public class GooglePlayLink extends BaseTest {
    @Test
    public void googlePlayLink() {
        RozetkaShop rozetkaShop = new RozetkaShop(driver);
        rozetkaShop.openPage()
                .openGooglePlay();
    }
}
