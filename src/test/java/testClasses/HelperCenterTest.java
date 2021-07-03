package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import pageObject.RozetkaReferenceCenterPage;

public class HelperCenterTest extends BaseTest {
    @Test
    public void productTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(driver);
        RozetkaReferenceCenterPage rozetkaReferenceCenterPage = homePage.getHeader()
                .openSideMenu()
                .openReferenceCenter();
        String referenceQuery = rozetkaReferenceCenterPage.getReferenceQuery();
        boolean ifReferenceSearchResultsContainQuery = rozetkaReferenceCenterPage.searchForReference()
                .getReferenceSearchResult(referenceQuery);
        Assert.assertTrue(ifReferenceSearchResultsContainQuery);
    }
}
