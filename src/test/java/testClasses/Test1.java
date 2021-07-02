package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetkaPageObjects.HomePage;

public class Test1 extends BaseTest {

    @Test(dataProvider = "searchCity", groups = {"rozetkaTest"})
    @Description("switching location (city) to another one")
    public void switchCity(String city) {
        HomePage homePage = new HomePage(this.driver);
        String currentCity = homePage.openPage()
                .getHeader()
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
