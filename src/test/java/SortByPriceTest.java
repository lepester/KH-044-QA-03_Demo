import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class SortByPriceTest extends BaseTest {
    @Test
    public void sortByPrice() {
        RozetkaTravel rozetkaTravel = new RozetkaTravel(driver);
        rozetkaTravel.openPage()
                .closeSplashWindow()
                .findTour()
                .sortByPrice()
                .getPrices();
    }
}
