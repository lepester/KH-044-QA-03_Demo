package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SortingProductsTest extends BaseTest {

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

    @Test
    @Description("Get to the section of products and simply click on 'sort by descending' button")
    public void sortingByDescTest() {

        String expensiveValue = "2: expensive";
        String expensivePartialLink = "sort=expensive";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .sortProductsByValue(expensiveValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expensivePartialLink));
    }

    @Test
    @Description("Get to the section of products and simply click on 'sort by ascending' button")
    public void sortingByAscTest() {

        String cheapValue = "1: cheap";
        String cheapPartialLink = "sort=cheap";

        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .sortProductsByValue(cheapValue);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(cheapPartialLink));
    }

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