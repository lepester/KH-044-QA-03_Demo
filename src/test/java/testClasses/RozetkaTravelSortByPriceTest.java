package testClasses;

import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

import java.util.List;

public class RozetkaTravelSortByPriceTest extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and simply click on 'sort by price' button")
    public void sortByPrice() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        List<Integer> travelPrices =  rozetkaTravelHomePage.closeSplashWindow()
                .findTour()
                .getPricesBySort();

        for (Integer price : travelPrices) {
            Assert.assertTrue(2000 <= price && price <= 400000);
        }
    }
}
