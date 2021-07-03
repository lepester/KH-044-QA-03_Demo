package testClasses;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class FindTour extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and find a tour")
    public void findTourTest() {
        RozetkaTravel rozetkaTravel = new RozetkaTravel(driver);
        rozetkaTravel.openPage()
                .closeSplashWindow()
                .cityDeparture()
                .cityArrival("Турция")
                .dateDeparture()
                .foodChoice()
                .findTour();
    }
}

