package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import pageObject.RozetkaReferenceCenterPage;

public class HelperCenterTest extends BaseTest {
    private String query = "доставка";

    @Description("Search for references in reference center to get help")
    @Link("https://help.rozetka.com.ua/hc/")
    @Test
    public void getHelp() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(driver);
        RozetkaReferenceCenterPage rozetkaReferenceCenterPage = homePage.getHeader()
                .openSideMenu()
                .openReferenceCenter();
        boolean ifReferenceSearchResultsContainQuery = rozetkaReferenceCenterPage.searchForReference(query)
                .getReferenceSearchResult(query);
        Assert.assertTrue(ifReferenceSearchResultsContainQuery);
    }
}
