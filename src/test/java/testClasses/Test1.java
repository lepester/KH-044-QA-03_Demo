package testClasses;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetkaPageObjects.CartPage;
import rozetkaPageObjects.HomePage;
import rozetkaPageObjects.ProductPage;

public class Test1 extends BaseTest {

    @DataProvider(name = "searchProduct")
    public Object[][] searchProduct() {
        return new Object[][]{
                {"Ноутбук"}, {"Клавиатура"}
        };
    }

    @Test(dataProvider = "searchProduct", groups = {"rozetkaTest", "buyingProductTest"})
    @Description("searching and adding products to the shopping cart")
    public void buyProduct(String searchText) {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.openPage()
                .getHeader()
                .searchProduct(searchText)
                .clickFirstProduct();
        String actualProductTitle = productPage.getProductTitle();
        Assert.assertTrue(actualProductTitle.contains(searchText),
                "The product`s title does not contain your search query.");
        CartPage cartPage = productPage.buyProduct();
        String productTitleInCart = cartPage.getProductInCartTitle();
        Assert.assertTrue(productTitleInCart.contains(actualProductTitle),
                "The product was not added into the shopping cart.");
        cartPage.closeCartPage();
    }

    @Test(groups = {"rozetkaTest"})
    @Description("switching language of the web-site to another one")
    public void switchLanguage() {
        HomePage homePage = new HomePage(driver);
        String oldSearchButtonText = homePage.openPage()
                .getHeader()
                .getSearchButtonText();
        String newSearchButtonText = homePage.getHeader()
                .openSideMenu()
                .changeLanguage()
                .getHeader()
                .getSearchButtonText();
        Assert.assertFalse(newSearchButtonText.equals(oldSearchButtonText));
    }

    @DataProvider(name = "searchCity")
    public Object[][] searchCity() {
        return new Object[][]{
                {"Киев"}
        };
    }

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
