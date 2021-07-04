package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
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
                .selectCityDeparture("Харьков")
                .selectCountryArrival("Турция")
                .selectFourDaysDate()
                .selectMeals()
                .findTour();
        String actualString = driver.getTitle();
        String expectedString = "Горящие туры в Турцию";
        Assert.assertEquals("Турцию", expectedString.substring(expectedString.length()-"Турцию".length()), actualString);
    }
}
