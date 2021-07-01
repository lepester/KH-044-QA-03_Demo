package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class SortByPrice extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and simply click on 'sort by price' button")
    public void sortByPrice() {
        RozetkaTravel rozetkaTravel = new RozetkaTravel(driver);
        rozetkaTravel.openPage()
                .closeSplashWindow()
                .findTour()
                .sortByPrice()
                .getPricesBySort();
    }
}
