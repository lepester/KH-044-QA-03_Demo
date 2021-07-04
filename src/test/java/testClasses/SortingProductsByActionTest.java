package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByActionTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by action' button")
    public void sortingByActionTest() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort("5: action");

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("sort=action"));
    }
}