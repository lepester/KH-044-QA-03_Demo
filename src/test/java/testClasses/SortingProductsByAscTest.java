package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByAscTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by ascending' button")
    public void sortingByAscTest() {

        String cheapValue = "1: cheap";
        String cheapPartialLink = "sort=cheap";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .settingsSort(cheapValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(cheapPartialLink));
    }
}