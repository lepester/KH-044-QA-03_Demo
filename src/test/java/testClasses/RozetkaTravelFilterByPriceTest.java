package testClasses;

import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

import java.util.List;

public class RozetkaTravelFilterByPriceTest extends BaseTest {

    @Test
    @Description("Get to the Rozetka Travel and set minimum and maximum price for a tour")
    public void filterByPrice() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        List<Integer> travelPrices = rozetkaTravelHomePage.closeSplashWindow()
                .findTour()
                .minPrice("10000")
                .maxPrice("21000")
                .getPricesByFilter();

        for (Integer price:travelPrices) {
            Assert.assertTrue(10000 <= price && price <= 21000);
        }
    }
}
