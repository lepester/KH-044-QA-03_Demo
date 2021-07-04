package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByDescTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by descending' button")
    public void sortingByDescTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort("2: expensive");

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("sort=expensive"));
    }
}