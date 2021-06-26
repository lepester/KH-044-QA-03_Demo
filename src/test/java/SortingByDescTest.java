import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByDescTest extends BaseTest {

    @Test
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