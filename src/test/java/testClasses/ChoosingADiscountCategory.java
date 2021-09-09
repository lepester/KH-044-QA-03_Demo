package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;

public class ChoosingADiscountCategory extends BaseTest {
    String titleAccessories = "Уцененные аксессуары";

    @Test
    @Description("Choose a discount accessories category")
    public void choosingDiscountAccessoriesCategory() {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        String actualTitle = rozetkaHomePage.getHeader().openCategoryCatalog().openDiscountCategoryPage().openDiscountAccessoriesPage().getTitleText();
        Assert.assertEquals(titleAccessories, actualTitle);
    }
}
