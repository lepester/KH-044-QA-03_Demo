package testClasses;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SellerFilterTest extends BaseTest{

    @Test
    @Description("Get to the section of products and check the seller`s filter")
    public void sellerFilterTest(){
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .chooseAllSellersInFilter();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("seller=other,rozetka"));
    }
}