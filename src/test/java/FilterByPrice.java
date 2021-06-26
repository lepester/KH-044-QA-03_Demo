import org.testng.annotations.Test;
import pageObject.RozetkaTravel;

public class FilterByPrice extends BaseTest {
    @Test
    public void filterByPrice() {
        RozetkaTravel rozetkaTravel = new RozetkaTravel(driver);
        rozetkaTravel.openPage()
                .closeSplashWindow()
                .findTour()
                .minPrice("16500")
                .maxPrice("21000");
    }
}
