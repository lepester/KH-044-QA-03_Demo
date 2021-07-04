package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SwitchLocation extends BaseTest {

    @DataProvider(name = "searchCity")
    public Object[][] searchCity() {
        return new Object[][] {
                {"Киев"},
                {"Львов "}
        };
    }

    @Test(dataProvider = "searchCity", groups = {"rozetkaTest"})
    @Description("switching location (city) to another one")
    public void switchCity(String city) {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(this.driver);
        String currentCity = homePage.getHeader()
                .openSideMenu()
                .clickCityButton()
                .searchCity(city)
                .submitCity()
                .getHeader()
                .openSideMenu()
                .getCurrentCity();
        Assert.assertTrue(currentCity.contains(city),
                "A city has not been changed to " + city);
    }
}
