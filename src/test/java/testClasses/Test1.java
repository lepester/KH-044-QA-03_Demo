package testClasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rozetkaPageObjects.*;

public class Test1 extends BaseTest {

    @DataProvider(name = "searchProduct")
    public Object[][] searchProduct() {
        return new Object[][] {
                {"Ноутбук"},
                {"Клавиатура"}
        };
    }

    @DataProvider(name = "searchCity")
    public Object[][] searchCity() {
        return new Object[][] {
                {"Киев"}
        };
    }

    @Test(dataProvider = "searchProduct", groups = {"rozetkaTest", "buyingProductTest"})
    public void buyProduct(String searchText) {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.openPage()
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
    public void switchLanguage() {
        HomePage homePage = new HomePage(driver);
        String oldSearchButtonText = homePage.openPage()
                .getSearchButtonText();
        String newSearchButtonText = homePage.openSideMenu()
                .changeLanguage()
                .getSearchButtonText();
        Assert.assertFalse(newSearchButtonText.equals(oldSearchButtonText));
    }

    @Test(dataProvider = "searchCity", groups = {"rozetkaTest"})
    public void switchCity(String city) {
        HomePage homePage = new HomePage(driver);
        String currentCity = homePage.openPage()
                .openSideMenu()
                .clickCityButton()
                .searchCity(city)
                .submitCity()
                .openSideMenu()
                .getCurrentCity();
        Assert.assertTrue(currentCity.contains(city), "A city has not been changed to " + city);
    }
}
