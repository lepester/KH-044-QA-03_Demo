package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

public class RozetkaTravelFilterByPriceTest extends BaseTest {

    @Test
    @Description("Get to the Rozetka Travel and set minimum and maximum price for a tour")
    public void filterByPrice() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        rozetkaTravelHomePage
                .closeSplashWindow()
                .findTour()
                .minPrice("16500")
                .maxPrice("21000")
                .getPricesByFilter();
    }
}
