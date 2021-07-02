import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObject.SearchResultsProducts;

public class ChooseSellerFilter extends BaseTest{

    @Test
    @Description("Get to the section of products and check the seller`s filter")
    public void sellerFilterTest(){
        String[] moreFilters = new String[]{"Rozetka", "Другие продавцы"};
        SearchResultsProducts searchResultsProducts = new SearchResultsProducts(driver);
        searchResultsProducts
                .openPage()
                .chooseSellerFilter(moreFilters);
    }
}
