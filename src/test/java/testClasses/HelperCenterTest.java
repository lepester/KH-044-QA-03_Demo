package testClasses;

import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class HelperCenterTest extends BaseTest {
    @Test
    public void productTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(driver);
        homePage.getHeader()
                .openSideMenu()
                .openReferenceCenter()
                .searchForReference();
    }
}
