import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByDescTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by descending' button")
    public void sortingByDescTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("2: expensive");
        int[] arrExpensive = searchResultsProducts.getPrices();
        for (int i = 0; i < arrExpensive.length - 1; i++) {
            Assert.assertTrue(arrExpensive[i] >= arrExpensive[i + 1]);
        }
    }
}