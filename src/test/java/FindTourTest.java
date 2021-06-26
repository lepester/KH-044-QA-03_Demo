import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class FindTourTest extends BaseTest {
    @Test
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
