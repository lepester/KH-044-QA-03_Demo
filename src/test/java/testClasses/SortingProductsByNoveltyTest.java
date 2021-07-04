package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByNoveltyTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by novelty' button")
    public void sortingByNoveltyTest() {

        String noveltyValue = "4: novelty";
        String noveltyPartialLink = "sort=novelty";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .sortProductsByValue(noveltyValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(noveltyPartialLink));
    }
}