import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByPopularityTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by popularity' button")
    public void sortingByPopularityTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("3: popularity");
        Assert.assertTrue(searchResultsProducts.getPopularity().isDisplayed());
    }
}