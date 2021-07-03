package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

public class FindTourTest extends BaseTest {

    @Test
    @Description("Get to the Rozetka Travel and find a tour")
    public void findTourTest() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        rozetkaTravelHomePage
                .closeSplashWindow()
                .cityDeparture()
                .cityArrival("Турция")
                .dateDeparture()
                .foodChoice()
                .findTour();
    }
}
