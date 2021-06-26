import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByNoveltyTest extends BaseTest {

    @Test
    public void sortingByNoveltyTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("4: novelty");
        Assert.assertTrue(searchResultsProducts.getNovelty().isDisplayed());
    }
}