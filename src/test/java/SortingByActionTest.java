import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByActionTest extends BaseTest {

    @Test
    public void sortingByActionTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("5: action");
        Assert.assertTrue(searchResultsProducts.getAction().isDisplayed());
    }
}