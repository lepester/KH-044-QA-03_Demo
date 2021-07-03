package testClasses;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaTravelHomePage;

public class RozetkaTravelSortByPriceTest extends BaseTest {
    @Test
    @Description("Get to the Rozetka Travel and simply click on 'sort by price' button")
    public void sortByPrice() {
        driver.get(rozetkaTravelLink);
        RozetkaTravelHomePage rozetkaTravelHomePage = new RozetkaTravelHomePage(driver);
        rozetkaTravelHomePage
                .closeSplashWindow()
                .findTour()
                .getPricesBySort();
        Assert.assertTrue(driver.findElement(By.cssSelector("span.s-result-item__price-amount")).isDisplayed());
    }
}
