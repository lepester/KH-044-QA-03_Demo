import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class SortingByActionTest extends BaseTest {

    @Test
    @Description("Get to the section of products and simply click on 'sort by action' button")
    public void sortingByActionTest() {
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .settingsSort("5: action");
        Assert.assertTrue(searchResultsProducts.getAction().isDisplayed());
    }
}