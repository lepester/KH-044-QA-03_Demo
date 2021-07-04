package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SellerFilterByOtherSellersTest extends BaseTest{

    String otherSellersRU = "Другие продавцы";
    String otherSellersUA = "Інші продавці";

    @Test
    @Description("Get to the section of products and check the seller`s filter by others sellers")
    public void sellerFilterTest(){
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .chooseSellerInFilter(otherSellersRU);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("seller=other"));
    }
}