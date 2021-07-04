package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByPopularityTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by popularity' button")
    public void sortingByPopularityTest() {

        String popularityValue = "3: popularity";
        String popularityPartialLink = "sort=popularity";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .sortProductsByValue(popularityValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(popularityPartialLink));
    }
}