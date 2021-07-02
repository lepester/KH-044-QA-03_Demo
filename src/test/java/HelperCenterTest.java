import org.testng.annotations.Test;
import pageObject.RozetkaMainPage;

public class HelperCenterTest extends BaseTest{
    @Test
    public void productTest() {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        // RozetkaSearchResults rozetkaSearchResults = new RozetkaSearchResults(driver);
        rozetkaMainPage.openHelper()
                .openPageHelper();
    }
}
