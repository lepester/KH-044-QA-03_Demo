package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByPopularityTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by popularity' button")
    public void sortingByPopularityTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort("3: popularity");

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("sort=popularity"));
    }
}