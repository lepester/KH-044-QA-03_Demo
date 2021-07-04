package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByNoveltyTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by novelty' button")
    public void sortingByNoveltyTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort("4: novelty");

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("sort=novelty"));
    }
}