package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsByActionTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by action' button")
    public void sortingByActionTest() {

        String actionValue = "5: action";
        String actionPartialLink = "sort=action";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .sortProductsByValue(actionValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(actionPartialLink));
    }
}