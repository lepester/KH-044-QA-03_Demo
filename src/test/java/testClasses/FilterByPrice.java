package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class FilterByPrice extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and set minimum and maximum price for a tour")
    public void filterByPrice() {
        RozetkaTravel rozetkaTravel = new RozetkaTravel(driver);
        rozetkaTravel.openPage()
                .closeSplashWindow()
                .findTour()
                .minPrice("16500")
                .maxPrice("21000")
                .getPricesByFilter();
    }
}
