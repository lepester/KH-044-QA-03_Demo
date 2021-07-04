package testClasses;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.RozetkaHomePage;
import pageObject.SearchResultsPage;

public class PriceFieldValidationTest extends BaseTest{

    @DataProvider(name = "IncorrectInputPrices")
    public static Object[][]  priceDataIncorrect() {
        return new Object[][]{
                {"a", "q"},
                {"$", "#"},
                {"!", "500"},
                {"1000", "-1500"},
        };
    }

    @DataProvider(name = "CorrectInputPrices")
    public static Object[][]  priceDataCorrect() {
        return new Object[][]{
                {"300", "2000"},
                {"500", "501"},
                {"1000", "99999"}
        };
    }

    @Test(dataProvider = "IncorrectInputPrices")
    @Description("Get to the section of products and insert incorrect data into fields")
    public void incorrectPricesFieldsValidationTest(String minPrice, String maxPrice) {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .getPricesFields(minPrice, maxPrice);

        SearchResultsPage searchResultsProducts = new SearchResultsPage(driver);
        Assert.assertFalse(searchResultsProducts.isButtonPriceOkEnabled());
    }

    @Test(dataProvider = "CorrectInputPrices")
    @Description("Get to the section of products and insert correct data into fields")
    public void correctPricesFieldsValidationTest(String minPrice, String maxPrice) {
        driver.get(rozetkaHomePageLink);
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(driver);
        rozetkaHomePage
                .chooseMonitorsFromCatalog()
                .getPricesFields(minPrice, maxPrice);

        SearchResultsPage searchResultsProducts = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsProducts.isButtonPriceOkEnabled());
    }
}