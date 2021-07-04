package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class SellerFilterByRozetkaTest extends BaseTest{

    String rozetkaSeller = "Rozetka";

    @Test
    @Description("Get to the section of products and check the seller`s filter by Rozetka")
    public void sellerFilterByRozetkaTest(){
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .chooseSellerInFilter(rozetkaSeller);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("seller=rozetka"));
    }
}