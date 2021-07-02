package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetkaPageObjects.HomePage;

public class Test1 extends BaseTest {

    @DataProvider(name = "checkDevicePrice")
    public Object[][] checkDevicePrice() {
        return new Object[][]{
                {"Смартфон", "Apple", "iPhone 12 Pro Max 256Gb", 21800}
        };
    }

    @Test(dataProvider = "checkDevicePrice", groups = {"rozetkaTest"})
    @Description("checking price of device for exchange")
    @Link("https://rozetka.com.ua/pages/obmin/")
    public void checkDeviceExchangePrice(String deviceType, String deviceProducer, String deviceModel, int deviceCost) {
        HomePage homePage = new HomePage(this.driver);
        int actualDeviceCost = homePage.openRozetkaObminPage()
                .inputDeviceType(deviceType)
                .inputDeviceProducer(deviceProducer)
                .inputDeviceModel(deviceModel)
                .chooseTurnedOnDevice()
                .chooseDeviceScreenWorks()
                .chooseDeviceAllFunctionsWork()
                .chooseDeviceWithScreenWithoutScratches()
                .chooseDeviceWithCoverWithoutScratches()
                .getDeviceCost();
        Assert.assertTrue(actualDeviceCost >= deviceCost,
                "Actual device cost is less than declared.");
    }
}
