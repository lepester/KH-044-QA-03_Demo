package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.CartPage;
import pageObject.RozetkaHomePage;
import pageObject.ProductPage;

public class addProductIntoCart extends BaseTest {

    @DataProvider(name = "searchProduct")
    public Object[][] searchProduct() {
        return new Object[][]{
                {"Ноутбук"},
                {"Клавиатура"}
        };
    }

    @Test(dataProvider = "searchProduct", groups = {"rozetkaTest", "buyingProductTest"})
    @Description("searching and adding products to the shopping cart")
    public void buyProduct(String searchText) {
        driver.get(url);
        RozetkaHomePage homePage = new RozetkaHomePage(driver);
        ProductPage productPage = homePage.getHeader()
                .searchProduct(searchText)
                .clickFirstProduct();
        String actualProductTitle = productPage.getProductTitle();
        Assert.assertTrue(actualProductTitle.contains(searchText),
                "The product`s title does not contain your search query.");
        CartPage cartPage = productPage.buyProduct();
        String productTitleInCart = cartPage.getTitleOfProductInShoppingCart();
        Assert.assertTrue(productTitleInCart.contains(actualProductTitle),
                "The product was not added into the shopping cart.");
        cartPage.closeCartPage();
    }
}
