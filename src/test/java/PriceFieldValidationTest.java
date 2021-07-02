import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class PriceFieldValidationTest extends BaseTest{

    @DataProvider(name = "IncorrectInput")
    public static Object[][]  priceDataIncorrect() {
        return new Object[][]{
                {"a", "q"},
                {"$", "#"},
                {"!", "500"},
                {"1000", "-1500"},
        };
    }

    @DataProvider(name = "CorrectInput")
    public static Object[][]  priceDataCorrect() {
        return new Object[][]{
                {"300", "2000"},
                {"500", "501"},
                {"1000", "99999"}
        };
    }

    @Test(dataProvider = "IncorrectInput")
    @Description("Get to the section of products and insert incorrect data on the fields")
    public void verifyIncorrectField(String min, String max) {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);

        searchResultsProducts
                .openPage()
                .inputFields(min, max);

        Assert.assertFalse(searchResultsProducts.getButtonPriceOk().isEnabled());
    }

    @Test(dataProvider = "CorrectInput")
    @Description("Get to the section of products and insert correct data on the fields")
    public void verifyCorrectField(String min, String max) {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);

        searchResultsProducts
                .openPage()
                .inputFields(min, max);

        Assert.assertTrue(searchResultsProducts.getButtonPriceOk().isEnabled());
    }
}