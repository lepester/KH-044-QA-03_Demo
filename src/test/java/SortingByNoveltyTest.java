import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByNoveltyTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by novelty' button")
    public void sortingByNoveltyTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("4: novelty");
        Assert.assertTrue(searchResultsProducts.getNovelty().isDisplayed());
    }
}