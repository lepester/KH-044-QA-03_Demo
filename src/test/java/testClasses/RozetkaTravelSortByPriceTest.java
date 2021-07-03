package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

public class RozetkaTravelSortByPriceTest extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and simply click on 'sort by price' button")
    public void sortByPrice() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        rozetkaTravelHomePage
                .closeSplashWindow()
                .findTour()
                .getPricesBySort();
    }
}
