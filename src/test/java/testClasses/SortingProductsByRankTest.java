package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByRankTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by rank' button")
    public void sortingByRankTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort("6: rank");

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("sort=rank"));
    }
}