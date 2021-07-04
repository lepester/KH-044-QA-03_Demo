package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class CheckDeviceExchangeCost extends BaseTest {

    @DataProvider(name = "checkDevicePrice")
    public Object[][] checkDevicePrice() {
        return new Object[][]{
                {"Смартфон", "Apple", "iPhone 12 Pro Max 256Gb", 21800},
                {"Планшет", "Lenovo", "B8000 32Gb 3G", 900}
        };
    }

    @Test(dataProvider = "checkDevicePrice", groups = {"rozetkaTest"})
    @Description("checking price of device for exchange")
    @Link("https://rozetka.com.ua/pages/obmin/")
    public void checkDeviceExchangePrice(String deviceType, String deviceProducer, String deviceModel, int deviceCost) {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage homePage = new RozetkaHomePage(this.driver);
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
