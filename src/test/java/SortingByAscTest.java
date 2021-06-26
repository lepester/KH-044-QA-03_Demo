import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByAscTest extends BaseTest {

    @Test
    public void sortingByAscTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("1: cheap");
        int[] arrCheap = searchResultsProducts.getPrices();
        for (int i = 0; i < arrCheap.length - 1; i++) {
            Assert.assertTrue(arrCheap[i] <= arrCheap[i + 1]);
        }
    }
}